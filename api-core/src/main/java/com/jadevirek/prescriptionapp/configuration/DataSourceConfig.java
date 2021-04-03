package src.main.java.com.jadevirek.prescriptionapp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@Scope("singleton")
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
public class DataSourceConfig {

    private static volatile DataSourceBuilder dataSource;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getInstanceOfDataSource() {
        if (Objects.isNull(dataSource)) {
            synchronized (DataSourceConfig.class) {
                if (Objects.isNull(dataSource)) {
                    dataSource = DataSourceBuilder.create();
                }
            }
        }
        return dataSource.build();
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getInstanceOfDataSource());
        sessionFactoryBean.setPackagesToScan("src.main.java.com.jadevirek.prescriptionapp.model");
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }
}
