package com.magicofo2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.TestBase.Hooks1;
import com.TestBase.Keywords;
import com.ugaoo.constants.On;

import org.apache.log4j.Logger;

public class BlogPage {
	private static final Logger LOG = Logger.getLogger(BlogPage.class);
	SoftAssert softly = new SoftAssert();
	@FindBy(css = "body > div:nth-child(36) > div:nth-child(2) > sticky-header:nth-child(16) > header:nth-child(1) > nav:nth-child(3) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1) > span:nth-child(1)")
	WebElement bloglink;
	@FindBy(css = "input[placeholder='search our blogs']")
	WebElement searchBlog;
	@FindBy(css = "body > div:nth-child(32) > div:nth-child(3) > main:nth-child(1) > section:nth-child(1) > div:nth-child(10) > div:nth-child(2) > div:nth-child(4) > div:nth-child(4) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
	WebElement cassiaFistula;
	@FindBy(css = ".article-template__title.h0")
	WebElement cassiaFistulaTitle;

	@FindBy(css = "a[href='/blogs/gardening-basics']")
	WebElement viewAll;
	@FindBy(css = ".title--primary")
	WebElement gardeningBasics;

	@FindBy(css = ".title.title--primary")
	WebElement noresultPage;

	@FindBy(css = "#Article-557609975940")
	WebElement gardernersGuide;
	@FindBy(css = "a[href='https://www.ugaoo.com/products/cactus-succulent-potting-mix-5-kg']")
	WebElement pottingMix;
	@FindBy(css = "h1[class='h2']")
	WebElement cactusMix;

	public void selectBlogForTree() {
		bloglink.click();
		searchBlog.sendKeys("Cassia Fistula");
	}
	public void verifyTree() {
		cassiaFistula.click();
		String expectedTitle = "Tree saga: Cassia fistula, The Golden Shower Tree (Amaltas)";
		String actualTitle = cassiaFistulaTitle.getText();
		softly.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
	}
		

	public void viewAll() {
		viewAll.click();
		String actualTitle = gardeningBasics.getText();
		String expectedTitle = "Garden Maintenance";
		softly.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
	}

	public void checkLink() {
		gardernersGuide.click();
		pottingMix.click();
	}
	
	public void verifyLink() {
		String expectedTitle = "Cactus & Succulent Potting Mix - 5 kg";
		String actualTitle = cactusMix.getText();
		softly.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
	}

	public void incorrectSearch() {
		searchBlog.sendKeys("1234567");
	}
	public void verifySearch() {
		String expectedTitle = "No results found for “1234567” Check the spelling or use a different word or phrase";
		String actualTitle = noresultPage.getText();
		softly.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
	}

	public void assertAll() {
		softly.assertAll();
	}
}
