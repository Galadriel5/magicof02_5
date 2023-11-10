import java.io.FileInputStream;

public class FileUtil {


		public String getProperty(String filepath, String key) {
		String baseDir = System.getProperty("user.dir");
		FileInputStream fis = null;
		fis = new FileInputStream(baseDir+filepath);
		}
		Properties prop = new Properties();
		String value = "";
		prop.load(fis);
		value = prop.getproperty(key);
		return value;
		}

		public String getConfiguration(String key) {
		String baseDir = System.getProperty("user.dir");
		return.getProperty(baseDir+"/src/main/resources/configuration/Config.properties", key);
		
}
}
