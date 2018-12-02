package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

public class DbConfig extends AbstractDBConfig {

	public void init(AppContext appContext) {
		configFile("/database.properties");
	}

}
