1) Framework used:
    - followed Page objects model framework, where tests are separated from page objects and reusable actions
    		- "com.selenium.pages" package having classes for each page we interact
    		- "com.selenium.actions" package having classes with reusable methods covering the functional flows on each page
    		- "com.selenium.tests" package having the tests
    - BasePage class : where we have the browser initialization happens and some reusable methods like application 
                       launch, dynamic wait and pageload related
    - Utility package : For some of the external libraries like Excel, property files and loggers, created classes 
                       with methods to read the data
    - since this is Maven project, all the dependencies are maintained in pom.xml
    - Test data is maintained in Excel sheet under "TestData" folder
    - Some configurable information is maintained in "Resouces/config.properties"
    - latest drivers for chrome and firefox placed under "BrowserDrivers" folder
    - For output, implemented log4j logs, which will be loaded to folder 'log'. For this configuration is maintained 
      under Resources/log4j.properties"
    
2) Execution:
     User can check and the project and simple go ahead and run , rest everything in place
         		- the test class under src/test/java > com.selenium.test > SauceDemoTest.java
   				- the xmls (Suite4ParallelRun / Suite4SeqRun) at the root folder level
   				- the Maven goal "mvn clean install"
   				
      
    
                 
    