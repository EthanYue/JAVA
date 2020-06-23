package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
* replace spring xml
*/
@Configuration
@ComponentScan("com.netease")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
public class SpringConfiguration {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;

    @Bean(name="runner")  // storage method return value into spring container
    @Scope("singleton")  // avoid problems of threading security when runner is singleton
    public QueryRunner createQueryRunner() {
        return new QueryRunner();
    }

    @Bean(name="dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
}
