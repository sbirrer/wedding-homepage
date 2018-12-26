package app.controllers;

import java.security.InvalidParameterException;
import java.util.List;

import org.javalite.activeweb.AppController;

public abstract class ExtendedController extends AppController {
	protected int getSingleIntParam(String paramName) {
		String valueStr = getSingleStringParam(paramName);
		
		int value;
		try {
			value = Integer.parseInt(valueStr);
		}
		catch (NumberFormatException nfe) {
			String msg = "Value '" + valueStr + "' for parameter '" + paramName + "' could not be converted to an integer";
			logError(msg, nfe);
			throw new IllegalArgumentException(msg, nfe);
		}
		
		return value;
	}
	
	protected String getSingleStringParam(String paramName) {
		List<String> valuesList = params(paramName);
		if(valuesList.size() != 1) {
			String msg = "Received " + valuesList.size() + " values for parameter '" + paramName + "', but 1 was expected.";
			logError(msg);
			throw new InvalidParameterException(msg);
		}
		
		return valuesList.get(0);
	}
	
	protected String getSingleStringParam(String paramName, int maxLength) {
		String value = getSingleStringParam(paramName);
		
		if (value.length() > maxLength) {
			String msg = "Value '" + value + "' for parameter '" + paramName + "' exceeds maximum length " + maxLength;
			logError(msg);
			throw new InvalidParameterException(msg);
		}
		
		return value;
	}
}
