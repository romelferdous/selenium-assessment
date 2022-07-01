package com.build.qa.build.selenium.tests;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

public class FergTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onHomePage())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
		driver.get("https://www.ferguson.com/");
	    driver.findElement(By.name("search")).sendKeys("Moen m6702bn");
	    softly.assertThat("HomePage");

	 
		
		// TODO: Implement this test
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {

		// TODO: Implement this test
	    driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
	    driver.findElement(By.linkText("Bathroom Sinks")).click();
	    driver.findElement(By.linkText("Wall Mount")).click();
	    if(driver.getTitle().contains("Add to Cart")) { 
	    driver.findElement(By.cssSelector("#sku3624974 > .has-unit-price .button")).click(); 
	    } 
	
	    softly.assertThat("#sku3624974 > .has-unit-price .button");
	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() {
		// TODO: Implement this test
		driver.get("https://www.ferguson.com/");
	    driver.findElement(By.name("search")).sendKeys("Moen m6702bn");
	    if(driver.getTitle().contains("Add to Cart")) { 
	    driver.findElement(By.cssSelector(".fg-icon-search:nth-child(3)")).click();
	    }
	    driver.findElement(By.cssSelector(".i-cart > .js-cartitem-count")).click();
	    driver.findElement(By.cssSelector("#sku3624974 > .has-unit-price .button")).click();
	    driver.findElement(By.cssSelector(".\\35 164957")).sendKeys("1");
	    driver.findElement(By.name("updateQuantity")).click();
	    driver.findElement(By.name("updateQuantity")).sendKeys("1");
	    driver.findElement(By.cssSelector(".fg-icon-search:nth-child(3)")).click();
	    driver.findElement(By.cssSelector(".\\35 164957")).sendKeys("1");
	    driver.findElement(By.name("updateQuantity")).click();
	    driver.findElement(By.name("updateQuantity")).sendKeys("1");
	    softly.assertThat(By.name("updateQuantity"));
	
	  }
	
	


	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		
		// TODO: Implement this test
	    driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
	    driver.findElement(By.linkText("Show More")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".js-rc-fg-nav-li:nth-child(12) .fcheckbox")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".Color_Finish_Category_rfbox .js-rc-fg-nav-li:nth-child(1) .fcheckbox")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
