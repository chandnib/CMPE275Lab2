package lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("lab2")
@EnableTransactionManagement
public class JPAEntityManagerConfig {

	@Bean
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtManager;
	}

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean localEntityManagerFactory = new LocalEntityManagerFactoryBean();
		localEntityManagerFactory.setPersistenceUnitName("localEntity");
		return localEntityManagerFactory;
	}
}