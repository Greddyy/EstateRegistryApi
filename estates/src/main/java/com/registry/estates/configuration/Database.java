package com.registry.estates.configuration;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class Database {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseWebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(false)
                .setName("estate_records.sql")
                .setType(EmbeddedDatabaseType.H2)
                .ignoreFailedDrops(true)
                .addScripts("classpath:estate_records.sql")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.registry.estates");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
        em.setJpaProperties(properties);

        return em;
    }
//    private final Environment environment;
//
//    @Autowired
//    public Database(Environment environment) {
//        this.environment = environment;
//    }
//
//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public DataSource dataSource (){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource){
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setPackagesToScan("com.registry.estates");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(vendorAdapter);
//
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", environment.getProperty("app.datasource.hbnt.dialect"));
//        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
//        bean.setJpaProperties(properties);
//
//        return bean;
//    }
}
