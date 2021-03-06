# practicematerial

The code in this project is a simple price calculator for shipments. The code is incomplete.

## Price formula ##

The price of a shipment consists of a base price, a price per kilogram and a price per zone.

Zones are decided by the distance the shipment is being sent. The further the shipment is being sent, the higher the number of zones will be.

If a transport has 0 zones, it is considered a "local transport". To ensure fair pricing, local transports have the same zone surcharge as 1 zone.

## Running the application ##

To view the UI, you can run this command in a terminal:

$ mvn clean install jetty:run -Dmaven.test.skip=true

Then visit http://localhost:8080/calculate in your browser.

###########
## TASKS ##
###########

The purpose of the tasks below are to acquaint yourself with test-driven development and the technology stack used in Posten & Bring.

You will not need to present the code or send it to anyone. At the first interview we will discuss some of the tasks you have performed.

The following tasks are meant to solved using test-driven development. This means always writing/refactoring the test before making changes to the code.

Use this philosophy when performing the tasks below.

Maintain the highest quality code you can when solving the tasks.

Remember: make small changes so that the tests are representative.

- There is an incomplete test in CalculatorServiceTest. The name of the test-method hints at what it should be testing. Fill in the contents so that it verifies the code its supposed to test.

- CalculatorService has 2 methods that are very similar. Refactor the code so that it has less duplication. Can you do this without changing the tests?

- Using double (and float) to represent currency is a bad idea. Why? (Hint: According to Java, what is 1.03 - .42?)
  - Starting with Product.java, refactor the code (and init.sql) to use more appropriate data types. See http://www.h2database.com/html/datatypes.html for information on H2 data types.
  - This type of refactoring can be difficult to do in a test-first fashion. Consider what mechanisms ensure that the refactoring does not introduce bugs.

- Each product has a maximum allowed weight.
  - Using ShipmentValidator, validate that the user-specified weight is within allowed limits (between 0 and the max for the selected product), and display an error message if not. Hint: remove the @Ignore annotations from the tests in ShipmentValidatorTest.java. Implement the tests based on the names. Write some further tests of your own.

- Implement the missing method bodies (getProducts() and deleteProduct()) in ProductDao. Remember to write tests first.

- There is a security bug in in the getProduct() method in ProductDao.java. Consider how an attacker can exploit this bug. Can you write a failing test that exposes the bug? Fix the bug!

- calculate.jsp is the main view of the application. The product-selection dropdown is a static list. Make it dynamic by fetching product ids and names from the database.
  - Make sure the list from the previous task retains the selected product between price checks.

- Extra task (large task, remember to break it down into smaller pieces): Create a simple admin UI that can list, add and delete products from the database. See AdminController and admin.jsp. You don't need to use a lot of time validating input.
