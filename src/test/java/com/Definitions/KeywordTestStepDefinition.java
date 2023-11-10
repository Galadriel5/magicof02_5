package com.definitions;

import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import com.TestBase.Hooks1;
import com.TestBase.Keywords;
import com.ugaoo.constants.On;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeywordTestStepDefinition {
	private static final Logger LOG = Logger.getLogger(KeywordTestStepDefinition.class);
	Keywords keyword = new Keywords();
	Hooks1 base = new Hooks1();
	SoftAssert softly = new SoftAssert();

	@Given("application പൂർണ്ണമായും തുറക്കുക") // poornnamaayum thurakkuka
	public void launchBrowser() {
		// keyword.launchUrl("https://www.ugaoo.com");
	}

	@When("ചെക്ക് review") // chekku reviews
	public void checkReviewsForCeramicPot() {
		keyword.click("css", On.CERAMICPOT);
		keyword.click("css", On.REVIEWS);
		String expectedTitle = "Average rating is 4.80 stars";
		String actualTitle = keyword.getText("css", On.POTREVIEWS);
		softly.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
	}

	@Given("ഇനത്തിനായി തിരയുക") // enathinaayi thirayuka (search for item)
	public void searchForParticularItemsViaSearchBox() {
		keyword.enterText("css", On.SEARCH, "Netted Ficus Tree");
	}

	@Then("verify ശരിയായ ഇനങ്ങൾ") // shariyaaya enangal (correct items)
	public void checkCorrectProductDisplayed() {
		String expectedTitle = "Netted Ficus Tree";
		String actualTitle = keyword.getText("css", On.FICUS);
		softly.assertEquals(actualTitle, expectedTitle, "Incorrect item displayed");
	}

	@Given("Marjoram Seeds")
	public void searchForMarjoramSeeds() {
		keyword.enterText("css", On.SEARCH, "Marjoram Seeds");
	}

	@When("ചെക്ക് No Review")
	public void thisItemMustNotHaveASingleReviewAdded() {
		keyword.click("css", On.MARJORAMSEEDS);
		keyword.click("css", On.MARJORAMREVIEWS);
	}

	@Then("ഇല്ല Review")
	public void zeroReviewPageMustBeDisplayed() {
		String expectedTitle = "From Happy Plant Parents";
		String actualTitle = keyword.getText("css", On.ZEROREVIEW);
		softly.assertEquals(actualTitle, expectedTitle, "Incorrect page displayed");
	}

	@Given("അസാധുവാണ് Product അഥവാ Category") // asaadhuvaanu product athava Category (invalid product or category)
	public void enteringInvalidEntriesInSearchbox() {
		keyword.click("css", On.SEARCH);
		keyword.enterText("css", On.SEARCH, "1234567");
	}

	@Then("")
	public void noSearchResult() {
		String expectedTitle = "No Search Result for '1234567'";
		String actualTitle = keyword.getText("css", On.NOSEARCHRESULTPAGE);
		softly.assertEquals(actualTitle, expectedTitle, "Incorrect page displayed");
	}

	@Given("തിരഞ്ഞെടുക്കുക Sign in") // തിരഞ്ഞെടുക്കുക Select Sign in
	public void clickOnSignInToYourAccount() {
		keyword.click("css", On.SIGNIN);
	}

	@When("നൽകുക Email and Password") // nalkuka (enter)
	public void enteringCredentials() {
		keyword.enterText("css", On.ENTEREMAILID, "adi.menon.yss@gmail.com");
		keyword.enterText("css", On.ENTERPASSWORD, "1112January$");
		keyword.click("css", On.SIGNINBUTTON);
	}

	@Then("കാണിക്കുക homepage") // kaanikkuka(show homepage)
	private void displayHomePage() {
		String expectedTitle = "Shop Now";
		String actualTitle = keyword.getText("css", On.HOMEPAGE);
		softly.assertEquals(actualTitle, expectedTitle);
	}

	@Given("ചെക്ക് whatsapp") // check whatsapp
	public void integrationTestingForWhatsapp() {
		keyword.click("css", On.WHATSAPP);
	}

	@Then("Whatsapp പേജ് തുറക്കുക") // WHATSAPP peju thurakkuka (open WHATSAPP page)
	public void whatsappageShouldBeDisplayed() {
		String expectedTitle = "Send the following on WhatsApp";
		String actualTitle = keyword.getText("css", On.WHATSAPPPAGETITLE);
		softly.assertEquals(actualTitle, expectedTitle, "Incorrect page displayed");
	}

	
	@Given("Plant Care")
	public void selectPlantCare() {
		try {
			keyword.click("css", On.PLANTCARE);
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException("An unexpected error occurred in selectPlantCare method.", e);
		}
	}
}
//example

//	@Then("ശരിയായി പ്രദർശിപ്പിക്കുക")//shariyaayi pradarshippikkuka(display correct)
//public void correctMessageMustBeDisplayed() {
// String expectedTitle = "Netted Ficus Tree";
// String actualTitle = keyword.getText("css", On.FICUS);
// softly.assertEquals(actualTitle, expectedTitle, "Incorrect item displayed");
//}
