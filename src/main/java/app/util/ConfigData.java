package app.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:src\\main\\resources\\application.properties")
public class ConfigData {
	
	@Autowired
	private Environment env;
	
	public String getUserPicturesDir() {
		return env.getProperty("user_pictures");
	}
	
	public String getArticlePicturesDir() {
		return env.getProperty("article_pictures");
	}

}
