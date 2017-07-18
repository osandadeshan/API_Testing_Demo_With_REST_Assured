Create Hospital Specification
=============================
Date Created    : 07/13/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
                  
                  
     
Create Hospital in the system
-----------------------------
* Given that the user invokes "Create Hospital"
* When the user invokes the Hospital Create API with valid details "3" and "Hospital2"
* Then the status code for creating hospital is "200"
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