package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j{
	private Logger log;
	public Log4j(){
		log=Logger.getLogger(this.getClass());
		String log4JPropertyFile = System.getProperty("user.dir")+"//src//test//resources//log4j.properties";
        Properties p = new Properties();
        try{
            p.load(new FileInputStream(log4JPropertyFile));
        } catch (IOException e){log.debug("IOException", e);}
        PropertyConfigurator.configure(p);
        }
	
	public Logger getLogger() {
		return log;
	}
}