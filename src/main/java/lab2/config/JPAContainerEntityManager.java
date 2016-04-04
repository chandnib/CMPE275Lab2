package lab2.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is a java based configuration file for persistence using JPA It creates
 * an EntityFactoryManager bean and datasource by using dependency injection
 *
 * @author : Group Lab
 * @version : 19
 */
@Configuration
@ComponentScan("lab2")
@EnableTransactionManagement /*
								 * tells spring that the classes
								 * with @Transactional annotatation should be
								 * wrapped with the Transactional Aspect.
								 */
public class JPAContainerEntityManager {
	/**
	 * Returns a transaction manager appropriate for applications using a single
	 * JPA EntityManagerFactory for transactional data access
	 * 
	 * @return JpaTransactionManager
	 */
	@Bean
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtManager;
	}

	/**
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactory.setDataSource(getDataSource());
		containerEntityManagerFactory.setPersistenceUnitName("localContainerEntity");
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		containerEntityManagerFactory.setLoadTimeWeaver(loadTimeWeaver);
		return containerEntityManagerFactory;
	}

	/**
	 * @return datasource
	 */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://127.0.0.1:3306/cmpe275_lab2?autoReconnect=true&maxReconnects=99&failOverReadOnly=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(-1);
		dataSource.setMaxIdle(0);
		dataSource.setMinIdle(0);
		dataSource.setMinEvictableIdleTimeMillis(10);
		dataSource.setTimeBetweenEvictionRunsMillis(1000);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}
}
