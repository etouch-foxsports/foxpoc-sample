package test.etouch.foxpoc.shakenbake;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.foxpoc.shakenbake.pages.ShakeAndBakeBlog;
import com.etouch.taf.core.BaseTest;
import com.etouch.taf.core.WebPage;

public class TestShakeAndBakeBlog extends BaseTest {

	private ShakeAndBakeBlog sbBlogPage;
	private String sbPageUrl;
	private static String h2HeaderCss="a.story-link span";
	private static String pageTitle="Shake and Bake - The Official NASCAR on FOX Blog | FOX Sports on MSN";
	
	@BeforeClass(alwaysRun=true)
	public void prepareBeforeClass() throws Exception{
		loadUrl();
		WebPage webPage = new WebPage(getDriver(), getTestBedManager());
		sbBlogPage = new ShakeAndBakeBlog(sbPageUrl, webPage);
	}
	
	private void loadUrl() throws Exception {		
		// FIXME: This needs to come from excel or property file based on environment - QA/Pre-Prod/Prod, hard coding just for demo purpose
//		sbPageUrl = "http://msn.foxsports.com/content/fsdigital/fscom/nascar/shakeandbake.html.html";
		sbPageUrl = "http://msn.foxsports.com/nascar/shakeandbake";
	}
	
//	@Test(dataProvider="tafDataProvider")
	public void testValidateHeader(){
		System.out.println("Page Title:"+sbBlogPage.getTitleOfPage());
		Assert.assertEquals(sbBlogPage.getTitleOfPage(), pageTitle, "Title not matched.");
	}

//	@Test(dataProvider="tafDataProvider")
	public void testValidateHeader1(String text, String xPath){
		System.out.println("Text:"+",Xpath:"+xPath);
		WebElement element = sbBlogPage.fetchElementByXPath(xPath);
		Assert.assertNotNull(element, "Element " + " is not found at xpath : " + xPath);
		System.out.println("A:"+element.getText());
		System.out.println("E:"+text);
		Assert.assertEquals(element.getText(), text, "Text is not matched.");
	}
	
	@Test(dataProvider="tafDataProvider")
	public void testValidateHeader2(String text, String xPath){
		System.out.println("Text:"+",Xpath:"+xPath);
		WebElement element = sbBlogPage.fetchElementBycssSelector("div.article-content:nth-child(1) p");
		Assert.assertNotNull(element, "Element " + " is not found at xpath : " + xPath);
		System.out.println("A:"+element.getText());
		System.out.println("E:"+text);
//		Assert.assertEquals(element.getText(), text, "Text is not matched.");
	}
	
}