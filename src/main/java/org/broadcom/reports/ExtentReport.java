package org.broadcom.reports;

import static org.broadcom.constants.FrameworkConstants.ICON_LAPTOP;
import static org.broadcom.constants.FrameworkConstants.ICON_SOCIAL_GITHUB;
import static org.broadcom.constants.FrameworkConstants.ICON_SOCIAL_LINKEDIN;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.broadcom.constants.FrameworkConstants;
import org.broadcom.enums.AuthorType;
import org.broadcom.enums.CategoryType;
import org.broadcom.utils.IconUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {
	}

	private static ExtentReports extent;

	public static void initReports() {
		if (Objects.isNull(extent)) {	
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle(FrameworkConstants.getProjectName() + " - ALL");
			spark.config().setReportName(FrameworkConstants.getProjectName() + " - ALL");

			extent.setSystemInfo("Organization", "Twilight IT Solutions");
			extent.setSystemInfo("Employee",
					"<b> Gobinath </b>" + " " + ICON_SOCIAL_LINKEDIN + " " + ICON_SOCIAL_GITHUB);
			extent.setSystemInfo("Domain", "Engineering (IT - Software)"+"  "+ICON_LAPTOP);
			extent.setSystemInfo("Skill", "Test Automation Engineer");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void createTest(String testCaseName) {
//		ExtentManager.setExtentTest(extent.createTest(IconUtils.getOSIcon() + " : " + testCaseName));
//	}

	synchronized public static void addAuthor(String[] authors) {
		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}
	synchronized public static void addCategories(CategoryType[] categories) {
		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}

	synchronized public static void addDevices() {
		ExtentManager.getExtentTest().assignDevice();
	}
}
