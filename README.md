# selenium-ui-test
- Uploaded maven project. Run test using from command line using mvn test
- Testing framework is TestNg
- Assignment question answer below

1. What page element selectors do you know?
- By.id(<locator>)
- By.name(<locator>)
- By.xpath(<locator>)
- By.cssSelector(<locator>)
- By.className(<locator>)
- By.tag(<locator>)
- By.linkText(<locator>)
- By.partialLinkText(<locator>)

2. Rate your JS knowledge from 0 to 10 (or another language, just indicate)- Java->7
4. Rate your Cypress/Selenium knowledge from 0 to 10- Selenium->7
5. Use selectors to get a list of all admins  <ul class="users_list"> 
    		<li class="admin">one</li>
     		<li class="user">two</li>
     		<li class="admin">three</li>
     		<li class="user">four</li>
   	</ul>
	-> Css selector=> driver.findElements(By.cssSelector(“li.admin”)) ;

5.  Use selectors to list all users by data attribute name="user" <ul class="users_list"> 
    		<li class="admin">one</li>
     		<li name="user"">two</li>
     		<li class="admin">three</li>
     		<li name="user">four</li>
   	</ul>
  -> Css selector=> driver.findElements(By.cssSelector(“li[name=‘user’]”));
  -> Xpath selector=> driver.findElements(By.xpath(“//li[@name=‘user’]”));

6. Filter the list by color attribute. The condition is that you first get the complete list of elements and then filter on the attribute. You need to get a list of items with a red marker. <ul class="users_list"> 
    		<li class="user" color=”red”>test1</li>
     		<li class="user" color=”green”>test2</li>
     		<li class="user" color=”red”>test3</li>
     		<li class="user" color=”green”>test4</li>
     		<li class="user" color=”red”>test5</li>
     		<li class="user" color=”green”>test6</li>
     		<li class="user" color=”green”>test7</li>
    		<li class="user" color=”red”>test8</li>
     		<li class="user" color=”green”>test9</li>
     		<li class="user" color=”red”>test10</li>
     		<li class="user" color=”green”>test11</li>
   	</ul>

  - Filter by colour attirbute Css Selector=> driver.findElements(By.cssSelector(“li[color]”));
  - Filter by red marker Css Selector=> driver.findElements(By.cssSelector(“li[color=‘red’]”));

7. What actions for elements do you know?
   - Not sure I get it correct, if u mean Actions class in selenium then
    - Actions class is used to handle complex interaction. like keyboard Down/Up, Mouse interaction like click, double-click, dragAndDrop, clickAndHold, contextClick
8. How to get an element using Selenium? 
    - ID, Name, ClassName, TagName, Css Selector, Xpath Selector, Link text/Partial Link text 
9. How to work with select in Selenium?
    - To perform certain operations on the dropdown. It can be done by Select class. The method used are selectByIndex, selectByValue, selectByVisibleText. 
10. Does Selenium support drag and drop?
    - Yes, it using Actions class
11. Does Selenium support file uploads? How?
    - Yes, we can upload file using Selenium using sendKeys() method. Where in sendKeys() we are going to pass the path of the file. Otherwise we have to use Java Robot class for file upload.
