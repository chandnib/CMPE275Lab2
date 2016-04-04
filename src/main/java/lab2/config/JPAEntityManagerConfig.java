package lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
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
@EnableTransactionManagement
public class JPAEntityManagerConfig {

	@Bean
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtManager;
	}

	/**
	 * This method returns a factory bean which creates a JPA
	 * 
	 * @return LocalEntityManagerFactoryBean
	 */
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean localEntityManagerFactory = new LocalEntityManagerFactoryBean();
		localEntityManagerFactory.setPersistenceUnitName("localEntity");
		return localEntityManagerFactory;
	}
}