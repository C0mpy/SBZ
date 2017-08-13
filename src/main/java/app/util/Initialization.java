package app.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements ApplicationRunner {
	
	@Autowired
	private ConfigData configData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
    	File userPictureDir = new File(configData.getUserPicturesDir());
    	if(!userPictureDir.exists())
    		userPictureDir.mkdirs();
    	
    	File articlePictureDir = new File(configData.getArticlePicturesDir());
    	if(!articlePictureDir.exists())
    		articlePictureDir.mkdirs();

    }


}
