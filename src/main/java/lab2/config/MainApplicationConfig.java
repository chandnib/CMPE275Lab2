package lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * This is a java based configuration file for application It registers internal
 * resource view resolver for resolving views. Also this imports the persistence
 * configuration file and enables web MVC
 *
 * @author : Group Lab
 * @version : 19
 */
@Configuration
@EnableWebMvc
@Import(JPAEntityManagerConfig.class)
public class MainApplicationConfig {
	/**
	 * This method attempts to resolve view name
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver viewResolverInternal = new InternalResourceViewResolver();
		viewResolverInternal.setPrefix("/WEB-INF/views/"); // sets prefix which
															// gets prepended to
															// the view name
															// while building
															// url
		viewResolverInternal.setSuffix(".jsp"); // sets prefix which gets
												// prepended to the view name
												// while building url
		viewResolverInternal.setViewClass(JstlView.class); // sets the view
															// class
		return viewResolverInternal;
	}
}