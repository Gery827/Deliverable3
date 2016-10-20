/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineShopTest;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.*;

import org.junit.Test;

/**
 *
 * @author AsphaltPanthers
 */
public class OnlineShopTest extends BaseTest {

    /**
     * User Story 1 As a user, I would like to see what on the main page So that
     * I can know what is happening in this e-commerce website
     *
     * @author Gery_xun
     *
     */
    	// Scenario 1:
    // Given that I am on the main page
    // When I view the header
    // Then I see that it contains "Home", "Product Category", and "All product" links
    @Test
    public void testHasCorrectHeaderLinks() {
        driver.get("http://store.demoqa.com/");
		// Check for Home, Product Category, and All product links 
        // if any of these is not found, fail the test

        try {
            driver.findElement(By.linkText("Home"));
            driver.findElement(By.linkText("Product Category"));
            driver.findElement(By.linkText("All Product"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    	// Scenario 2:
    // Given I am on the main page
    // Then I should be able to see the "My Account" button.
    @Test
    public void testAccountButton() {
        driver.get("http://store.demoqa.com/");
        try {
            driver.findElement(By.id("account"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    	// Scenario 3:
    // Given I am on the main page
    // Then I should see that there is a search text area to type the keyword
    @Test
    public void testSearchBox() {
        driver.get("http://store.demoqa.com/");
        try {
            List<WebElement> web = driver.findElements(By.tagName("input"));
            boolean result = false;
            for (int i = 0; i < web.size(); i++) {
                String line = web.get(i).getAttribute("value");
                if (line.contains("Search Products")) {
                    result = true;
                    break;
                }
            }
            assertTrue(result);
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    /**
     * User Story 2 As a user, I would like to register and login successfully
     * So that I can well use this e-commerce website and shop in it
     *
     * @author Gery_xun
     *
     */
    // Scenario 4:
    // Given that I am on the main page
    // And not log in
    // When I click "My Account" button.
    // Then the page should appear "Register"
    @Test
    public void testRegister() {
        driver.get("http://store.demoqa.com/");
        driver.findElement(By.id("account"));
        WebElement gotoaccount = driver.findElement(By.id("account"));
        driver.findElement(By.id("account")).click();
        
        
        By title = By.className("entry-title");
        waitUntil(d -> d.findElement(title).isDisplayed());
        
        
        try {
            driver.findElement(By.linkText("Register"));
            WebElement result = driver.findElement(By.xpath("//h3[@id=’widget-title’]"));
            assertTrue(result.getText().contains("Register"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

	// Scenario 5:    
    // Given that I am on the main page
    // And I am not logged in 
    // When I try to login with a valid username and valid password
    // Then I will be dircted to new page while the top bar shows"Howdy, Xun"
    @Test
    public void loginSuccessfully() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("Xun" + Keys.RETURN);
        driver.findElement(By.id("pwd")).sendKeys("tZRO7dFmGE$t2rVR" + Keys.RETURN);
        driver.findElement(By.id("login")).click();

        By topToolBar = By.id("wp-admin-bar-my-account");
        waitUntil(d -> d.findElement(topToolBar).isDisplayed());
        System.out.print(driver.findElement(topToolBar).getText());
        assertEquals("Howdy, Xun", driver.findElement(topToolBar).getText());

    }

    // Scenario 6:
    // Given that I am on the main page
    // And I already logged in 
    // When I try to cilck the top tool bar the W icon,
    // Then the new page should appear the link of "Credits"
    @Test
    public void testWordPress() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("Xun" + Keys.RETURN);
        driver.findElement(By.id("pwd")).sendKeys("tZRO7dFmGE$t2rVR" + Keys.RETURN);
        driver.findElement(By.id("login")).click();

        By topToolBar = By.id("wp-admin-bar-my-account");
        waitUntil(d -> d.findElement(topToolBar).isDisplayed());

        driver.findElement(By.className("ab-icon")).click();
        By wrap = By.id("wrap about-wrap");
        waitUntil(d -> d.findElement(wrap).isDisplayed());
        try {
            driver.findElement(By.linkText("Credits"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();

    }

    /**
     * User Story 3 As a user, I already have an account And login successfully
     * So that I can check my profile Further to do some search, add products to
     * my cart, and further place order.
     *
     * @author Gery_xun
     *
     */
    // Scenario 7:
    // Given that I am already logged in 
    // When I try to click Purchase History
    // Since I never place any orders
    // Then it should show "No transactions for this month."
    @Test
    public void testHistory() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("Xun" + Keys.RETURN);
        driver.findElement(By.id("pwd")).sendKeys("tZRO7dFmGE$t2rVR" + Keys.RETURN);
        driver.findElement(By.id("login")).click();

        By topToolBar = By.id("wp-admin-bar-my-account");
        waitUntil(d -> d.findElement(topToolBar).isDisplayed());

        try {
            driver.findElement(By.linkText("Purchase History")).click();
            WebElement result = driver.findElement(By.className("logdisplay"));
            assertTrue(result.getText().contains("No transactions for this month."));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

	// Scenario 8:
    // Given that I am on the product category page
    // And I am already logged in 
    // When I try to search iPhone
    // Then the search result will contain iPhone 5
    @Test
    public void testSearch() {
        driver.get("http://store.demoqa.com/");
        driver.findElement(By.className("search")).clear();
//                driver.findElement(By.className("searchform")).clear();
        driver.findElement(By.className("search")).sendKeys("iPhone" + Keys.RETURN);
//		driver.findElement(By.className("searchform")).click();

        By title = By.className("prodtitle");
        waitUntil(d -> d.findElement(title).isDisplayed());

//          String title = driver.getTitle();
//          assertTrue(title.contains("iPhone 5"));
        try {

            driver.findElement(By.linkText("iPhone 5"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    // Scenario 9:
    // Given that I am already logged in 
    // When I search iPhone 5
    // And I try to add it to my car
    // Then it should pop "You just added "iPhone 5" to your cart."
    @Test
    public void testAdd() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("Xun" + Keys.RETURN);
        driver.findElement(By.id("pwd")).sendKeys("tZRO7dFmGE$t2rVR" + Keys.RETURN);
        driver.findElement(By.id("login")).click();

        By topToolBar = By.id("wp-admin-bar-my-account");
        waitUntil(d -> d.findElement(topToolBar).isDisplayed());
        driver.findElement(By.className("search")).clear();
//                driver.findElement(By.className("searchform")).clear();
        driver.findElement(By.className("search")).sendKeys("iPhone 5" + Keys.RETURN);
//		driver.findElement(By.className("searchform")).click();

        By title = By.className("prodtitle");
        waitUntil(d -> d.findElement(title).isDisplayed());

//          String title = driver.getTitle();
//          assertTrue(title.contains("iPhone 5"));
        try {
            List<WebElement> web = driver.findElements(By.tagName("input"));
            web.get(5).click();
            WebElement result = driver.findElement(By.id("fancy_notification_content"));
            assertTrue(result.getText().contains("You just added \"iPhone 5\" to your cart"));

        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }
}
