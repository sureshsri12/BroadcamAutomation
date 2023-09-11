package org.broadcom.constants;

public class FrameworkConstants {
	/**
	 * Private constructor to avoid external instantiation
	 */	
	private FrameworkConstants() {
	}
	/**
	 * winapplocation : is to open win-app-driver location path.
	 * URL : is to run remote driver url
	 * appPath is used to define where the application location file is placed.
	 * EXPLICIT_WAIT : is used to wait until the web element found in UI
	 */	
	private static final String winapplocation = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"; 
	private static final String URL = "http://127.0.0.1:4723/";

	public static final String location = "C:\\Users\\";
	public static final String account = "TLSPC-087\\";
	public static final String localfilepath = "AppData\\Local\\";
	public static final String productname = "product-usage-collector\\";
	public static final String buildversion = "1.1.2";
	public static final String appversion = "app-" + buildversion + "\\";
	public static final String fileext = "product-usage-collector.exe";
	private static final String appPath = location + account + localfilepath + productname + appversion + fileext;
	private static final int EXPLICIT_WAIT = 40;
	
	
	
	
	/**
	 * These values are defined for Extent report file path
	 */	
	public static final String YES = "yes";
	public static final String NO = "no";
	private static String extentReportFilePath = "";
	private static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
	public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
	private static final String Project_Name = "Automation Test Suite Report - Master Selenium Framework";

	/* ICONS - START */
	public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
	public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
	public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";

	public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
	public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
	public static final String ICON_DESKTOP = "<i class='fa fa-desktop'></i>";
	public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
	public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
	/* style="text-align:center;" */
	public static final String ICON_SOCIAL_LINKEDIN_URL = "https://www.linkedin.com/in/rajat-v-3b0685128/";
	public static final String ICON_SOCIAL_GITHUB_URL = "https://github.com/rajatt95";
	public static final String ICON_SOCIAL_LINKEDIN = "<a href='" + ICON_SOCIAL_LINKEDIN_URL
			+ "'><i class='fa fa-linkedin-square' style='font-size:24px'></i></a>";
	public static final String ICON_SOCIAL_GITHUB = "<a href='" + ICON_SOCIAL_GITHUB_URL
			+ "'><i class='fa fa-github-square' style='font-size:24px'></i></a>";

	public static final String ICON_Navigate_Right = "<i class='fa fa-arrow-circle-right' ></i>";
	public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
	public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
	public static final String BOLD_START = "<b>";
	public static final String BOLD_END = "</b>";

	public static String getExtentReportFilePath() {

		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = org.broadcom.utils.ReportPathUtils.createExtentReportPath();
		}
		return extentReportFilePath;
	}


	public static String getWinAppLocation() {
		return winapplocation;
	}

	public static String getUrl() {
		return URL;
	}

	public static String getAppPath() {
		return appPath;
	}

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static String getProjectName() {
		return Project_Name;
	}

}
