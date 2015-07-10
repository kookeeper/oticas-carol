package br.com.msystem.oticas.carol.util;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DBConfig {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bean = new BasicDataSource();
		bean.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		bean.setUrl("jdbc:derby:" + getRootPath() + "/MyDB;create=true");
		bean.setUsername("usuario");
		bean.setPassword("senha");

		return bean;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceUnitName("oticas.carol");
		bean.setDataSource(dataSource());
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter
				.setDatabasePlatform("org.hibernate.dialect.DerbyDialect");
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		bean.setJpaProperties(jpaProperties);

		return bean;
	}

//	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager bean = new JpaTransactionManager(
				(EntityManagerFactory) entityManagerFactory());
		return bean;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor postProcessos() {
		PersistenceAnnotationBeanPostProcessor bean = new PersistenceAnnotationBeanPostProcessor();
		return bean;
	}

	private String getRootPath() {
		return System.getProperty("user.home");
	}

}
