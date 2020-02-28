package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass {

	@Test
	public void inetBankingLoginTest() {

		logger.info("URL inetBanking website Opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickSubmit();

		logger1 = report.createTest("Login To inetBankingV1");
		String actualurl = "GTPL Bank Manager HomePage";
		String expectedurl = driver.getTitle();

		if (actualurl.equalsIgnoreCase(expectedurl)) {
			logger1.info("Sucessful login");
		} else {
			logger1.info("Failed Login");
		}

		/*
		 * if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
		 * Assert.assertTrue(true); logger1.info("Login Test Passed, Title Match"); }
		 * else { Assert.assertTrue(false);
		 * logger1.info("Login Test Failed, Title didn't match"); }
		 */
	}

}
