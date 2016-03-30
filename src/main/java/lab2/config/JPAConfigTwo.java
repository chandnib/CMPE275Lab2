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
public class JPAConfigTwo {  
	
	@Bean
	public JpaTransactionManager jpaTransMan(){
		JpaTransactionManager jtManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return jtManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(getDataSource());
		lcemfb.setPersistenceUnitName("localContainerEntity");
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		lcemfb.setLoadTimeWeaver(loadTimeWeaver);
		return lcemfb;
	}
	
	@Bean
	public DataSource getDataSource() {
	       BasicDataSource dataSource = new BasicDataSource();
	       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	       dataSource.setUrl("jdbc:mysql://localhost:3306/concretepage");
	       dataSource.setUsername("root");
	       dataSource.setPassword("r66t");
	       return dataSource;
	}
} 
