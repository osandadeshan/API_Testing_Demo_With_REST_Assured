Login Specification
===================
Date Created    : 07/13/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.

tags: login

* Given that a user invokes "Login API"

User login into the system with valid username and valid password
-----------------------------------------------------------------
tags: login-success

* When the user invokes the login API with a username as "aansar@gmail.com" and a password as "ayesha@123"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value      |
     |------|-----------|
     |status|successfull|
     |userId|1          |



User login into the system with valid username and invalid password
-------------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "aansar@gmail.com" and a password as "ayesha@12"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with valid username and empty password
-----------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "aansar@gmail.com" and a password as ""
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with valid username and null password
----------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with valid username as "aansar@gmail.com" and null password
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with invalid username and valid password
-------------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "aansar@gmail.co" and a password as "ayesha@123"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with invalid username and invalid password
---------------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "aansar@gmail.co" and a password as "ayesha@12"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with invalid username and empty password
-------------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "aansar@gmail.co" and a password as ""
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with invalid username and null password
------------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with valid username as "aansar@gmail.co" and null password
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with empty username and valid password
-----------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "" and a password as "ayesha@123"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with empty username and invalid password
-------------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "" and a password as "ayesha@12"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with empty username and empty password
-----------------------------------------------------------------
tags: login-fail

* When the user invokes the login API with a username as "" and a password as ""
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with empty username and null password
----------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with valid username as "" and null password
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with null username and valid password
----------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with null username and a password as "ayesha@123"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with null username and invalid password
------------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with null username and a password as "ayesha@12"
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with null username and empty password
----------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with null username and a password as ""
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |



User login into the system with null username and null password
---------------------------------------------------------------
tags: login-fail

* When the user trying to invoke the login API with null username and null password
* Then the status code for login request is "200"
* And the response for login request contains the following 

     |Key   |Value       |
     |------|------------|
     |status|unauthorized|
     |userId|null        |
