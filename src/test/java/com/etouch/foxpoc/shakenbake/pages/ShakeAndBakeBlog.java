package com.etouch.foxpoc.shakenbake.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.WebPage;

public class ShakeAndBakeBlog {
	
	private WebPage webPage;
	private String pageUrl;
	private String storyLinkXpath ="(//span[@itemprop='headline'])["; 
	public ShakeAndBakeBlog(String pageUrl, WebPage webPage) {
		super();
		this.pageUrl = pageUrl;
		this.webPage = webPage;
		loadPage();
	}
	
	private void loadPage(){
		webPage.getDriver().get(pageUrl);
		webPage.getDriver().manage().window().maximize();
	}
	
	/**
	 * 
	 * @param className
	 * @return
	 */
	public WebElement getPartnerWrapper(String className){
		WebElement element =  webPage.waitOnElement(By.className(className), 5);
		return element;
	}
	
	/**
	 * 
	 * @param headerContainerClassName
	 * @return
	 */
	public WebElement getSbHeader(String headerContainerClassName){
		WebElement element = webPage.waitOnElement(By.className(headerContainerClassName), 5);
		return element;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getMsnBarUsingId(String id){
		WebElement element = webPage.waitOnId(id);
		return element;
	}
	
	
	/**
	 * 
	 * @param msnBarId
	 * @param className
	 * @return
	 */
	public WebElement isMSNLogoPresent(String msnBarId, String className){
		WebElement element = webPage.waitOnId(msnBarId);
		WebElement logo = element.findElement(By.className(className));
		return logo;
	}
	
	/**
	 * 
	 * @param idOfLogo
	 * @return
	 */
	public String getMSNLogoLinkUrl(String idOfLogo){
		String url = null;
		WebElement element = webPage.waitOnId(idOfLogo, 2);
		if(element!=null){
			url = element.getAttribute("href"); // // TODO: Fix hardcode
		}
		return url;
	}
	
	/**
	 * 
	 * @param msnBarId
	 * @return
	 */
	public List<String> getAllMSNBarLinkTextsByClassName(String msnBarId, String menuClassName){
		List<String> msnBarLinkTextMap = new ArrayList<String>();
		WebElement element = webPage.waitOnId(msnBarId);
		if(element!=null){
			List<WebElement> menuElements = element.findElements(By.className(menuClassName)); 
			for(WebElement menuElement:menuElements){
				msnBarLinkTextMap.add(menuElement.getText());
			}
		}
		
		return msnBarLinkTextMap;
	}
	
	/**
	 * 
	 * @param id
	 * @param linkTexts
	 * @return
	 */
	public Map<String, String> getAllMSNBarLinkUrls(List<String> linkTexts){
		Map<String, String> msnBarLinkMap = new HashMap<String, String>();
		for(String linkText:linkTexts){
			WebElement element = webPage.waitOnText(linkText);
			msnBarLinkMap.put(linkText, element.getAttribute("href")); // TODO: Fix hardcode
		}
		return msnBarLinkMap;
	}
	
	/**
	 * 
	 * @param msnBarId
	 * @param siteSearchClassName
	 * @return
	 */
	public WebElement getSiteSearchElement(String siteSearchClassName){
		WebElement siteSearchElement = webPage.waitOnElement(By.className(siteSearchClassName), TestBed.MaxWaitSeconds);
		return siteSearchElement;
	}
	
	/**
	 * 
	 * @param menuItemText
	 * @return
	 */
	public String getHrefOfMenuText(String menuItemText){
		System.out.println("Getting HREF for menu item > " + menuItemText);
		WebElement element = webPage.waitOnText(menuItemText);
		String href = "";
		if(null != element){
			href = element.getAttribute("href");
		}
		return href;
	}
	
	public WebElement fetchElementByXPath(String xPathToElement){
		System.out.println("Locating xpath " + xPathToElement);
		return webPage.waitOnXPath(xPathToElement, TestBed.MaxWaitSeconds);
	}
	
	public WebElement fetchElementBycssSelector(String cssSelectorToElement){
		System.out.println("Locating xpath " + cssSelectorToElement);
		return webPage.waitOnCSS(cssSelectorToElement, TestBed.MaxWaitSeconds);
	}
	
	public String getTitleOfPage(){
		return webPage.getDriver().getTitle();
	}
	
}
