# Deliverable3
IS 2545 - DELIVERABLE 3: 
An e-commerce website testing with the BDD
Nanxun Xie 
Nax4 
I write all my test codes in OnlineShopTest.java and BaseTest.java, and push all the related stuffs to my GitHub. 

For this deliverable, I programmed 9 tests in total corresponding to 9 different scenarios and all of these evenly belong to different 3 user stories. Each description can be seen in the code. And I also attach them at the end of this README.md file.

I think the first difficult problem I faced was there are I need to provide some wait time for the system to operate some action. For example, the “Login scenario”, at first, I just only write the account and password and directly click the login. I have tried to locate different elements to check the logged page, but all failed. Eventually, when I went back to see your example in lecture 14, I found that no wait time provided was my key mistake. So I add the same method in your example case and also add a BaseTest.java.  

Besides, I also designed some other scenarios excluded in my testing code, since targeting these elements is difficult for me. For example, firstly I want to locate the product showing on the main page, but the codes of these part are always fail. Eventually I found because the attributes of these displaying products are sliding, their id are always changing. So I think locating these elements are one of the most difficult problems for me. Also I found them there are many hover-on action, like when I put the mouse on the “Howdy, Xun” at the top right of the main page, it will provide me three options. I do not have any ideas of how to realize this hover-on action, and do not know how to locate it by particular elements. In my designed scenarios, I think “add product to cart” is the most complicated one. Here I combine multiple actions together, from login to add. Here I use a list to target all input tag. Since I am searching for iPhone 5, thus I count that the information of iPhone 5 is located in the 5th input tag. This list largely helps me to find the add-to-cart button of the targeted product and realize this testing scenario. Actually this add0to-cart testing successfully execute in my Firefox browser, but the result in Netbeans still shows failed. Until now I still have no idea about it.

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
    // Scenario 2:
    // Given I am on the main page
    // Then I should be able to see the "My Account" button.
    // Scenario 3:
    // Given I am on the main page
    // Then I should see that there is a search text area to type the keyword




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
    // Scenario 5:    
    // Given that I am on the main page
    // And I am not logged in 
    // When I try to login with a valid username and valid password
    // Then I will be directed to new page while the top bar shows "Howdy, Xun"
    // Scenario 6:
    // Given that I am on the main page
    // And I already logged in 
    // When I try to click the top tool bar the W icon,
    // Then the new page should appear the link of "Credits"


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
    // Scenario 8:
    // Given that I am on the product category page
    // And I am already logged in 
    // When I try to search iPhone
    // Then the search result will contain iPhone 5
    // Scenario 9:
    // Given that I am already logged in 
    // When I search iPhone 5
    // And I try to add it to my car
    // Then it should pop "You just added "iPhone 5" to your cart."


