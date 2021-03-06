package com.netease.mybatis.utils;
//import com.netease.mybatis.annotations.Select;
import com.netease.mybatis.annotation.Select;
import com.netease.mybatis.cfg.Configuration;
import com.netease.mybatis.cfg.Mapper;
import com.netease.mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  parse config file
 */
public class XMLConfigBuilder {


    /**
     *      dom4j+xpath
     */
    public static Configuration loadConfiguration(InputStream config){
        try{
            // define configuration Object of connection encapsulated (the configuration Object of mybatis)
            Configuration cfg = new Configuration();

            //1.get SAXReader Object
            SAXReader reader = new SAXReader();
            //2.get Document Object according to byte input stream
            Document document = reader.read(config);
            //3.get root node
            Element root = document.getRootElement();
            List<Element> propertyElements = root.selectNodes("//property");
            for(Element propertyElement : propertyElements){
                String name = propertyElement.attributeValue("name");
                if("driver".equals(name)){
                    String driver = propertyElement.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if("url".equals(name)){
                    String url = propertyElement.attributeValue("value");
                    cfg.setUrl(url);
                }
                if("username".equals(name)){
                    String username = propertyElement.attributeValue("value");
                    cfg.setUsername(username);
                }
                if("password".equals(name)){
                    String password = propertyElement.attributeValue("value");
                    cfg.setPassword(password);
                }
            }
            //取出mappers中的所有mapper标签，判断他们使用了resource还是class属性
            List<Element> mapperElements = root.selectNodes("//mappers/mapper");
            //遍历集合
            for(Element mapperElement : mapperElements){
                //判断mapperElement使用的是哪个属性
                Attribute attribute = mapperElement.attribute("resource");
                if(attribute != null){
                    System.out.println("use xml");
                    //表示有resource属性，用的是XML
                    //取出属性的值
                    String mapperPath = attribute.getValue();//获取属性的值"com/itheima/dao/IUserDao.xml"
                    //把映射配置文件的内容获取出来，封装成一个map
                    Map<String,Mapper> mappers = loadMapperConfiguration(mapperPath);
                    //给configuration中的mappers赋值
                    cfg.setMappers(mappers);
                } else {
                    System.out.println("use annotation");
                    String daoClassPath = mapperElement.attributeValue("class");
                    Map<String, Mapper> mappers = loadMapperAnnotation(daoClassPath);
                    cfg.setMappers(mappers);
                }
            }
            //返回Configuration
            return cfg;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try {
                config.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 根据传入的参数，解析XML，并且封装到Map中
     * @param mapperPath    映射配置文件的位置
     * @return  map中包含了获取的唯一标识（key是由dao的全限定类名和方法名组成）
     *          以及执行所需的必要信息（value是一个Mapper对象，里面存放的是执行的SQL语句和要封装的实体类全限定类名）
     */
    private static Map<String,Mapper> loadMapperConfiguration(String mapperPath)throws IOException {
        InputStream in = null;
        try{
            //定义返回值对象
            Map<String,Mapper> mappers = new HashMap<String,Mapper>();
            //1.根据路径获取字节输入流
            in = Resources.getResourceAsStream(mapperPath);
            //2.根据字节输入流获取Document对象
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            //3.获取根节点
            Element root = document.getRootElement();
            //4.获取根节点的namespace属性取值
            String namespace = root.attributeValue("namespace");//是组成map中key的部分
            //5.获取所有的select节点
            List<Element> selectElements = root.selectNodes("//select");
            //6.遍历select节点集合
            for(Element selectElement : selectElements){
                //取出id属性的值      组成map中key的部分
                String id = selectElement.attributeValue("id");
                //取出resultType属性的值  组成map中value的部分
                String resultType = selectElement.attributeValue("resultType");
                //取出文本内容            组成map中value的部分
                String queryString = selectElement.getText();
                //创建Key
                String key = namespace+"."+id;
                //创建Value
                Mapper mapper = new Mapper();
                mapper.setQueryString(queryString);
                mapper.setResultType(resultType);
                //把key和value存入mappers中
                mappers.put(key,mapper);
            }
            return mappers;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            in.close();
        }
    }

    private static Map<String, Mapper> loadMapperAnnotation(String daoClassPath) throws ClassNotFoundException {
        Map<String, Mapper> mappers = new HashMap<String, Mapper>();
        Class daoClass = Class.forName(daoClassPath);
        Method[] methods = daoClass.getMethods();
        for (Method method : methods) {
            boolean isAnnotated = method.isAnnotationPresent(Select.class);
            if (isAnnotated) {
                Mapper mapper = new Mapper();
                Select selectAnnotation = method.getAnnotation(Select.class);
                String queryString = selectAnnotation.value();
                mapper.setQueryString(queryString);
                Type type = method.getGenericReturnType();
                if(type instanceof ParameterizedType) {
                    ParameterizedType ptype = (ParameterizedType)type;
                    Type[] types = ptype.getActualTypeArguments();
                    Class domainClass = (Class)types[0];
                    String resultType = domainClass.getName();
                    mapper.setResultType(resultType);
                }
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String key = className + "." + methodName;
                mappers.put(key, mapper);
            }
        }
        return mappers;
    }
}
