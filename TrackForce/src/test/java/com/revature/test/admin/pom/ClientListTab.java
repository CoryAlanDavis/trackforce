package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.test.utils.WaitToLoad;

public class ClientListTab
{
	public WebDriver wd = null;
	static WebElement e = null;
	
	public static WebElement getClientTab(WebDriver d)
	{
		e = WaitToLoad.findDynamicElement(d, By.xpath("/html/body/app/div/app-root/div/app-navbar/nav/div/ul[1]/li[2]"), 10);
		return e;
	}

	public static WebElement getClientTabHeader(WebDriver d)
	{
		return e = WaitToLoad.findDynamicElement(d, By.xpath("/html/body/app/div/app-client-list/div/div/div[1]/h3"), 10);
	}
	
	public static WebElement getClientSearchBox(WebDriver d)
	{
		e = WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"clientSearch\"]"), 10);
		return e;
	}
	
	public static WebElement getViewDataForAllClientsButton(WebDriver d)
	{
		e = WaitToLoad.findDynamicElement(d, By.xpath("/html/body/app/div/app-client-list/div/div/div[1]/button"), 10);
		return e;
	}
	
	public static WebElement getClientNameFromList(WebDriver d, int index)
	{
		int i = index;
		e = WaitToLoad.findDynamicElement(d, By.xpath("//*[@id=\"clients-list\"]/li[" + i + "]/span"), 10);
		return e;
	}
	
	public static WebElement getBarChartHeader(WebDriver d)
	{
		e = WaitToLoad.findDynamicElement(d, By.xpath("/html/body/app/div/app-client-list/div/div/div[2]/h1"), 10);
		return e;
	}
	
	
}
