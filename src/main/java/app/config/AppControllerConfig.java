package app.config;

import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;
import org.javalite.activeweb.controller_filters.HeadersLogFilter;
import org.javalite.activeweb.controller_filters.RequestParamsLogFilter;
import org.javalite.activeweb.controller_filters.RequestPropertiesLogFilter;

import app.controllers.RegistrationController;

public class AppControllerConfig extends AbstractControllerConfig {

	public void init(AppContext appContext) {
		add(new DBConnectionFilter()).to(RegistrationController.class);
		add(new RequestPropertiesLogFilter());
		add(new RequestParamsLogFilter());
		add(new HeadersLogFilter());

	}

}
