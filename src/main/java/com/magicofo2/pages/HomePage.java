package com.magicofo2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(css = "a[href='/pages/about-us']")
	WebElement aboutUs; // cannot call any method on class level?, hence annotation FindBy
	
	@FindBy(css = ".search_form.desktop-search.st-search-box-desktop")
	WebElement searchingForItems;
	
	@FindBy(css = ".card-information__text.h4[href='/products/frosted-ceramic-pot']")
	WebElement ceramicPot;
	
	@FindBy(css = "div[class='jdgm-widget jdgm-preview-badge jdgm-preview-badge--with-link jdgm--done-setup'] span[class='jdgm-prev-badge__text']")
	WebElement reviews;
	
	public void clickOnAboutUs() {
		aboutUs.click();

	}
	public void searchItemsToShop() {
		searchingForItems.sendKeys("Hanging Plants");
		searchingForItems.sendKeys(Keys.RETURN);
	}
	
	public void checkingReviewsForCeramicPot() {
		ceramicPot.click();
		reviews.click();
	}
	
}
