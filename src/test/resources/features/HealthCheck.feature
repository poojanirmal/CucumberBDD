@ui @healthcheck
Feature: E-Commerce Project Website Health Checkup

@prodsearch1
Scenario: User is able to open the browser,navigate to the URL and search for products
#Given user opened browser
Given user navigate to the Home Application URl
When user search for product "Laptop"
Then search result page is displayed with page title keywored contains "Laptop"

@prodsearch
Scenario: User is able to open the browser,navigate to the URL and search for products
#Given user opened browser
Given user navigate to the Home Application URl
When user search for product "Headphone"
Then search result page is displayed with page title keywored contains "Headphone"

@prodsearch
Scenario: User is able to open the browser,navigate to the URL and search for products
#Given user opened browser
Given user navigate to the Home Application URl
When user search for product "Power Bank"
Then search result page is displayed with page title keywored contains "Power Bank"

@prodsearch
Scenario: User is able to open the browser,navigate to the URL and search for products
#Given user opened browser
Given user navigate to the Home Application URl
When user search for product "Mobile"
Then search result page is displayed with page title keywored contains "Mobile"

#cntr+/ for commenting

 









