
public class Configuration{
	public void getAppUrl() {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "app.url");
	}

	public void getBrowserName() {
		FileUtil file = new FileUtil();
		return file.getConfiguration("browserName");
	}
}
