package com.seleniumtesting;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("DobiDemo Test Suite")
@ExcludePackages("com.seleniumtesting.dobiDemo.basicOperration")
@SelectPackages("com.seleniumtesting.dobiDemo")

public class dobiDemoTestSuite {


}
