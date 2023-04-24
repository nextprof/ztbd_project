package com.example.ztbd_project.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.example.ztbd_project.domain"
})
@EnableTransactionManagement
@EnableSpringDataWebSupport
public class DataConfig {



    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ztbd");
        dataSource.setUsername("root");
        dataSource.setPassword("letmein");
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(0);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(50);
        dataSource.setMinEvictableIdleTimeMillis(10);
        dataSource.setTestWhileIdle(true);
        return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setPackagesToScan(
                "com.example.ztbd.domain"
        );
        lef.setDataSource(dataSource());
        lef.setPersistenceUnitName("master");
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setJpaProperties(getProperties());
        return lef;
    }

    public HibernateJpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return jpaVendorAdapter;
    }

    private Properties getProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect.storage_engine", "innodb");
                setProperty("hibernate.id.new_generator_mappings", "false");
                setProperty("hibernate.hbm2ddl.auto", "create");
//                setProperty("hibernate.hbm2ddl.auto", "update");

                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

                setProperty("hibernate.connection.useUnicode", "true");
                setProperty("hibernate.connection.characterEncoding", "UTF-8");
                setProperty("hibernate.connection.charSet", "UTF-8");

                setProperty("connection.useUnicode", "true");
                setProperty("connection.characterEncoding", "utf-8");
                setProperty("connection.charSet", "utf-8");

                setProperty("org.hibernate.FlushMode", "COMMIT");
                setProperty("hibernate.format_sql", "false");
                setProperty("hibernate.show_sql", "true");
            }
        };

    }

    @Primary
    @Bean(name = "transactionTemplate")
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager());
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
        return transactionTemplate;
    }


    @Bean(name = "readOnlyTransactionTemplate")
    public TransactionTemplate readOnlyTransactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager());
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        transactionTemplate.setReadOnly(true);
        return transactionTemplate;
    }


    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}

