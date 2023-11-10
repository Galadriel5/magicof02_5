
public class Configuration{
	public String getAppUrl() {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/configuration/Config.properties", "app.url");
	}

	public String getBrowserName() {
		FileUtil file = new FileUtil();
		return file.getConfiguration("browserName");
	}
}
