package com.netease.day03.reflect;

import com.netease.util.printUtils;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {


    public static void main(String[] args) throws Exception {

//        reflectDemo();
//        reflectTest();
//        getReflectClass();

        annoReflect();
    }

    /**
     * reflect methods demo
     * get functions
     * 1.get member vars
     * Field[] getFields()
     * Field getField(String name)
     * Field[] getDeclareFields()
     * Field getDeclaredField(String name)
     * 2.get constructor methods
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(class<?>... parameterTypes)
     * Constructor<T> getDeclaredConstructor(class<?>... parameterTypes)
     * Constructor<?>[] getDeclaredConstructors()
     * 3.get member methods
     * Method[] getMethods()
     * Method getMethod(String name, class<?>... parameterTypes)
     * Method[] getDeclaredMethods()
     * Method getDeclaredMethod(String name, class<?>... parameterTypes)
     * 4.get class name
     * String getName()
     * @throws Exception
     */
    public static void reflectDemo() throws Exception {
        Class personClass = Person1.class;

        Field[] fields = personClass.getFields(); // get public member vars;
        for (Field field : fields) {
            System.out.println(field);
        }

        Field a = personClass.getField("a");  // get public member var with name;
        Person1 person = new Person1();
        System.out.println(a.get(person));
        a.set(person, "a");
        System.out.println(a.get(person));

        printUtils.print("=", 50);

        Field[] declaredFields = personClass.getDeclaredFields(); // get all member vars;
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field declaredField = personClass.getDeclaredField("d");  // get member var with name;
        declaredField.setAccessible(true); // ignore safe check of modifiers, named as violence reflection;
        System.out.println(declaredField.get(person));

        printUtils.print("=", 50);

        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor constructor = personClass.getConstructor(String.class); // get constructors;
        System.out.println(constructor);
        Object a1 = constructor.newInstance("a"); // create a new Object with constructor;
        System.out.println(a.get(a1));

        printUtils.print("=", 50);

        Method[] methods = personClass.getMethods();  // get methods
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method); // get method name
        }
        printUtils.print("=", 20);
        Method method = personClass.getMethod("getA");  // get a method with method name then invoke it;
        System.out.println(method);
        method.invoke(person);

        Method eat = personClass.getMethod("eat", String.class); // get a method with method name and args class;
        System.out.println(eat);
        eat.invoke(person, "aaa");

        printUtils.print("=", 50);

        System.out.println(personClass.getName()); // get class name include package name of the class;

        printUtils.print("=", 50);
    }

    /**
     * load class and invoke method according to properties
     * @throws Exception
     */
    public static void reflectTest() throws Exception {
        Properties properties = new Properties(); // create Properties object;
        ClassLoader classLoader = ReflectDemo.class.getClassLoader(); // load properties;
        InputStream resourceAsStream = classLoader.getResourceAsStream("com/netease/day03/reflect/cfg.properties");
        properties.load(resourceAsStream);

        String className = properties.getProperty("className"); // read properties;
        String methodName = properties.getProperty("methodName");

        Class cls = Class.forName(className); // load the class in memory;
        Object obj = cls.newInstance(); // create object instance;
        Method method = cls.getMethod(methodName, String.class); // get method with name;
        method.invoke(obj, "aaa"); // invoke method;
    }

    /**
     * the methods of get Class Object
     * @throws Exception
     * conclusion: the same *.class will be loaded once in runtime;
     */
    public static void getReflectClass() throws Exception {
        Class person1 = Class.forName("com.netease.day03.reflect.Person1"); // this method is used to properties file;
        System.out.println(person1);

        Class<Person1> person2 = Person1.class; // this method is used to send args
        System.out.println(person2);

        Person1 p = new Person1();
        Class person3 = p.getClass();
        System.out.println(person3);

        System.out.println(person1 == person2); // true;
        System.out.println(person1 == person3); // true;
    }

    /**
     * annotation replace properties
     */
    @Configuration(className = "com.netease.day03.reflect.Person1", methodName = "eat")
    public static void annoReflect() throws Exception {
        Method annoReflect = ReflectDemo.class.getMethod("annoReflect"); // get method object;
        Configuration cfg = annoReflect.getAnnotation(Configuration.class); // get annotation;
        String className = cfg.className();
        String methodName = cfg.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className); // load the class in memory;
        Object obj = cls.newInstance(); // create object instance;
        Method method = cls.getMethod(methodName, String.class); // get method with name;
        method.invoke(obj, "aaa"); // invoke method;
    }
}


class Person1 {
    public String a;
    protected String b;
    String c;
    private String d;

    public Person1() {

    }

    public Person1(String a) {
        this.a = a;
    }

    public String getA() {
        System.out.println(a);
        return a;
    }

    public void eat(String s) {
        System.out.println(s);
    }
}

