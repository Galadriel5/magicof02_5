package com.definitions;

import org.openqa.selenium.support.PageFactory;

import com.TestBase.Hooks1;
import com.magicofo2.pages.BlogPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class POMStepDefinitions {
	public BlogPage blogPage;
	Hooks1 hook = new Hooks1();

	@Given("I navigate to the blog page")
	public void navigateToBlogPage() {
		BlogPage blog = PageFactory.initElements(Hooks1.getDriver(), BlogPage.class);
	}

	@When("I select a blog for a tree")
	public void selectBlogForTree() {
		blogPage.selectBlogForTree();
	}

	@Then("I view all blogs")
	public void viewAllBlogs() {
		blogPage.viewAll();
	}

	@Then("I check a link in the blog")
	public void checkLinkInBlog() {
		blogPage.checkLink();
	}

	@Then("I perform an incorrect search")
	public void incorrectSearch() {
		blogPage.incorrectSearch();
	}

	@Then("all assertions should pass")
	public void assertAll() {
		blogPage.assertAll();
	}

}
