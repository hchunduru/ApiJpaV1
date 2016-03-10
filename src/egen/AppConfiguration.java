package egen;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class AppConfiguration extends WebMvcConfigurerAdapter{
	// The body is empty because we wont return HTML or JSp else this is a rest api
	// and will return raw JSON
	// there is no view resolver which is done in normal MVC frameworks
	
}
