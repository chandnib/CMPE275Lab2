package lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration 
@EnableWebMvc   
@Import(JPAContainerEntityManager.class)
public class MainApplicationConfig {  
	
    @Bean  
    public InternalResourceViewResolver setupViewResolver() {  
    	InternalResourceViewResolver viewResolverInternal = new InternalResourceViewResolver();  
        viewResolverInternal.setPrefix("/WEB-INF/views/");  
        viewResolverInternal.setSuffix(".jsp");  
        viewResolverInternal.setViewClass(JstlView.class);  
        return viewResolverInternal;  
    }
}  