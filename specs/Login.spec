Login Specification
===================
Date Created    : 07/13/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax.
                  Every heading in this file denotes a scenario. Every bulleted point denotes a step.
                  
                  
     
User login into the system
--------------------------
* When the user invokes the login API with valid username as "aansar@gmail.com" and valid password as "ayesha@123"
* Then the status code should be "200"
* And Response should contains the following
        |Key        |Value        |
        |-----------|-------------|
        |status     |successfull  |
        |userId     |1            |

* And Response should contains the following in any order
        |Key        |Value        |
        |-----------|-------------|
        |status     |successfull  |
        |userId     |1            |