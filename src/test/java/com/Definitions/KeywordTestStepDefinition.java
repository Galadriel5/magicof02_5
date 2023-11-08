package com.Definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.TestBase.Hooks1;
import com.TestBase.Keywords;
import com.aventstack.extentreports.util.Assert;
import com.ugaoo.constants.On;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeywordTestStepDefinition {
	Keywords keyword = new Keywords();
	Hooks1 base = new Hooks1();

	@Given("application പൂർണ്ണമായും തുറക്കുക") // poornnamaayum thurakkuka
	public void launchBrowser() {
		// keyword.launchUrl("https://www.ugaoo.com");
	}

	@When("ചെക്ക് review") // chekku reviews
	public void checkReviewsForCeramicPot() {
		keyword.click("css", On.CERAMICPOT);
		keyword.click("css", On.REVIEWS);
	}

	// @Given("നഗര തിരഞ്ഞെടുപ്പ്") // nagara thiranjeduppu (city selection)
	// public void cityVerify() throws InterruptedException {
	// Hooks1.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	// keyword.click("css", On.CITY);
	// String title = keyword.getText("css", On.CITYTITLE);
	// assertEquals(true, title);

	@Given("ഇനത്തിനായി തിരയുക") // enathinaayi thirayuka (search for item)
	public void searchForParticularItemsViaSearchBox() {
		keyword.enterText("css", On.SEARCH, "Netted Ficus Tree");
		// assertion
	}

	@Given("Marjoram Seeds")
	public void searchForMarjoramSeeds() {
		keyword.enterText("css", On.SEARCH, "Marjoram Seeds");
	}

	@When("ചെക്ക് No Review")
	public void thisItemMustNotHaveASingleReviewAdded() {
		keyword.click("css", On.MARJORAMSEEDS);
		keyword.click("css", On.MARJORAMREVIEWS);
		// assertion:keyword.getText("css", On.BETHEFIRSTONETOWRITEAREVIEW);
	}

	// @Then("ശരിയായ സന്ദേശം പ്രദർശിപ്പിച്ചിട്ടുണ്ടോയെന്ന് പരിശോധിക്കുക") //
	// shariyaaya sandesham
	// public void correctMessageMustBeDisplayedUponNoReview()
	// assertion:keyword.getText("css", On.BETHEFIRSTONETOWRITEAREVIEW); //
	// pradarshippichittundoyennu parisodhikkuka

	// @Given("അസാധുവായ എൻട്രികൾ നൽകുക") // asaadhuvaaya entrikal nalkuka (enter
	// invalid entries)
	// public void enteringInValidEntriesForReview(){
	// keyword.click("css", On.ANTHURIUMLIVIUMPLANT);
	// keyword.click("css", On.FORANTHURIUM );
	// keyword.click("css", On.WRITEAREVIEW);
	// keyword.enterText("css", On.ENTERRWNAME, "Kabir");;
	// keyword.enterText("css", On.ENTERRWEMAIL, "123456");

	// Then assert for message

	@Given("അസാധുവാണ് Product അഥവാ Category") // asaadhuvaanu product athava Category (invalid product or category)
	public void enteringInvalidEntriesInSearchbox() {
		keyword.click("css", On.SEARCH);
		keyword.enterText("css", On.SEARCH, "1234567");
	}

	@Given("തിരഞ്ഞെടുക്കുക Sign in") // തിരഞ്ഞെടുക്കുക Select Sign in
	public void clickOnSignInToYourAccount() {
		keyword.click("css", On.SIGNIN);
	}

	@When("നൽകുക Email and Password") // nalkuka (enter)
	public void enteringCredentials() {
		keyword.enterText("css", On.ENTEREMAILID, "adi.menon.yss@gmail.com");
		keyword.enterText("css", On.ENTERPASSWORD, "1112January$");
	}

	@Then("Sign in")
	public void signInToYourAccount() {
		keyword.click("css", On.SIGNINBUTTON);
	}

	@Given("ചെക്ക് whatsapp") // check whatsapp
	public void integrationTestingForWhatsapp() {
		keyword.click("css", On.WHATSAPP);
	}
}
