package org.broadcom.utils;

import java.util.Properties;

import org.broadcom.enums.EnvType;

public final class ConfigLoader {

	private Properties properties;
	private static ConfigLoader configLoader;
	private static final String OVERRIDE_REPORTS = "override_reports";
	private static final String PASSED_STEPS_SCREENSHOT = "passed_steps_screenshot";
	private static final String SKIPPED_STEPS_SCREENSHOT = "skipped_steps_screenshot";
	private static final String FAILED_STEPS_SCREENSHOT = "failed_steps_screenshot";
	private static final String RETRY_FAILED_TESTS = "retry_failed_tests";

	private static final String ENV = "env";
	private static final String CONFIG_PROPERTIES = "_config.properties";

	/* Default config file is stg_config.properties */
	private static final String STG_CONFIG_PROPERTIES = "stg" + CONFIG_PROPERTIES;
	private static final String QA_CONFIG_PROPERTIES = "qa" + CONFIG_PROPERTIES;
	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String REQUEST_DETAILS_IN_REPORTS = "request_details_in_reports";

	private ConfigLoader() {

		/* Setting EnvType.STAGE as default environment */
		/*
		 * This will check for the env value from Jenkins/Maven first. If it does not
		 * get any input from Jenkins/mvn cmd line, then, will take
		 * stg_config.properties file as default
		 */
		String env = System.getProperty(ENV, EnvType.STAGE.toString());

		switch (EnvType.valueOf(env)) {
		/* Only STAGE is working, Rest are taken for example */

		case STAGE: {
			properties = getConfigPropertyFile(STG_CONFIG_PROPERTIES);
			break;
		}
		case QA: {
			properties = getConfigPropertyFile(QA_CONFIG_PROPERTIES);
			break;
		}
		default: {
			throw new IllegalStateException("Invalid EnvType: " + env);
		}
		}
	}

	private Properties getConfigPropertyFile(String configFile) {
		return PropertyUtils.propertyLoader(RESOURCES_PATH + configFile);
	}

	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getFailedStepsScreenshot() {
		return FAILED_STEPS_SCREENSHOT;
	}

	public String getPassedStepsScreenshot() {
		return PASSED_STEPS_SCREENSHOT;
	}

	public String getSkippedStepsScreenshot() {
		return SKIPPED_STEPS_SCREENSHOT;
	}

	public String getRetryFailedTests() {
		return RETRY_FAILED_TESTS;
	}

	public static String getOverrideReports() {
		return OVERRIDE_REPORTS;
	}

	public String getRequestDetailsInReports() {
		return getPropertyValue(REQUEST_DETAILS_IN_REPORTS);
	}

}
