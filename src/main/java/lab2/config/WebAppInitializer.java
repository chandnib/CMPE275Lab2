package lab2.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This class is loading context and initializing the webapp by configuring
 * Dispatcher Servlet for each mapping Also registering the hidden field filter
 * to support HTTP Delete and HTTP put calls
 * 
 * @author : Group Lab
 * @version : 19
 */
public class WebAppInitializer implements WebApplicationInitializer {

	/**
	 * @throws servletexception
	 * @param servletcontext
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MainApplicationConfig.class);
		ctx.setServletContext(servletContext);
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		registerHiddenFieldFilter(servletContext);
	}

	/**
	 * This method registers filter instance with the servlet context
	 * 
	 * @param aContext
	 */
	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true,
				"/*");
	}
}
