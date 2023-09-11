package org.broadcom.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {

	@Column(name = "TC", index = 0)
	private String testCase;

	@Column(name = "username", index = 1)
	private String username;

	@Column(name = "password", index = 2)
	private String password;

	@Column(name = "product count", index = 3)
	private String productcount;

	@Column(name = "icon", index = 4)
	private String icon;
	
	@Column(name = "deleteconform", index = 5)
	private String delete;
		
	@Column(name = "search", index = 6)
	private String search;

	@Column(name = "instanceurl", index = 7)
	private String instanceurl;

	@Column(name = "instance", index = 8)
	private String instance;

	@Column(name = "environment", index = 9)
	private String environment;

	@Column(name = "email", index = 10)
	private String email;

	@Column(name = "pwd", index = 11)
	private String pwd;

	@Column(name = "cmpwd", index = 12)
	private String cmpwd;

	@Column(name = "token", index = 13)
	private String token;

	@Column(name = "key", index = 14)
	private String key;

	@Column(name = "value", index = 15)
	private String value;

	@Column(name = "filename", index = 16)
	private String filename;

	@Column(name = "month", index = 17)
	private String month;



	public String getTestCase() {
		return testCase;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getProductcount() {
		return productcount;
	}

	public String getIcon() {
		return icon;
	}

	public String getSearch() {
		return search;
	}

	public String getInstanceurl() {
		return instanceurl;
	}

	public String getInstance() {
		return instance;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public String getCmpwd() {
		return cmpwd;
	}

	public String getToken() {
		return token;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public String getFilename() {
		return filename;
	}

	public String getMonth() {
		return month;
	}

	public String getDelete() {
		return delete;
	}

	@Override
	public String toString() {
		return "TestData [testCase=" + testCase + ", username=" + username + ", password=" + password
				+ ", productcount=" + productcount + ", icon=" + icon + ", delete=" + delete + ", search=" + search
				+ ", instanceurl=" + instanceurl + ", instance=" + instance + ", environment=" + environment
				+ ", email=" + email + ", pwd=" + pwd + ", cmpwd=" + cmpwd + ", token=" + token + ", key=" + key
				+ ", value=" + value + ", filename=" + filename + ", month=" + month + "]";
	}

}
