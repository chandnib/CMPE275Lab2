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

@Configuration
@ComponentScan("lab2")
@EnableTransactionManagement
public class JPAContainerEntityManager {

	@Bean
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactory.setDataSource(getDataSource());
		containerEntityManagerFactory.setPersistenceUnitName("localContainerEntity");
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		containerEntityManagerFactory.setLoadTimeWeaver(loadTimeWeaver);
		return containerEntityManagerFactory;
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cmpe275_lab2");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
