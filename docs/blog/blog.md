# Blog: Passport Application System Blog


## Blog #1 03/12/2018:  Functional Spec/ Frontend work

My Functional Spec was completed last week. I have started creating the frontend of my application using Angular6 & bootstrap. I have also researched & did some work with Docker, unfortunatey ran into problems creating my image so will need to find out what im doing wrong.

## Blog #2 30/12/2018: All Inputs Required To Be Filled In

I have added some input validation for the name, date of birth etc. Next step is to add in hashing class for PPS numbers, which will be then stored in backend DB with all other user input. At the moment it is just "REQUIRED" that all input fields must be filled in. Main class was added just to help me test methods. I also need to add in unit tests for these methods. 

## Blog #3 02/01/2019:  First Unit Tests Created
Unit Tests have been added. Planning to have these tests running after every commit in pipeline. Will continuously update these tests throughout the development cycle.

## Blog #4 06/02/2019 Springboot & Angular Connected
Spring backend has been set up and successfully connected to my angular frontend. Angular frontend and spring backend are being served up seperately. Connected using a proxy. Set up admin section and have restrcited access to it to normal users. Currently working on spring security with Auth0.  Met with supervisor yesterday (05/02/2019), happy with progress but need to complete eethics & GDPR form. Draft version of that form has been committed.

## Blog #5 12/02/2019: Problems With Spring Security
Had to revert changes. Continuously getting 401 not authorized error when trying to access admin section. This will need to be started again.

## Blog #6 19/2/2019: Trello Update
![](docs/blog/images/TrelloBoardBlog6.PNG)
Above image shows the current state of my backlog, what I'm currently working on and what has been completed so far. Im using trello to keep track of my work. I am still working on securing API endpoints within my application. This will need to be finished up soon as I would like to start working on facial detection research using OpenCV

## Blog #7 09/03/2019: Started Work With OpenCV
Decided to leave securing API endpoints to move onto researching and implementing facial detection. For this I am using OpenCv which from research seems to be the best implementation method. I am using cascade classifier to detect faces, this could be used to detect many different objects. I currently have the choice between using Haarcascades or lbpcascades. From inital testing lbpcascades seems to work better for me, but I will need to do more work on this. I would also like to many some UI changes soon as I feel this could look better

## Blog #8 13/03/2019: Sentry Added To Frontent To Improve Debugging
![](docs/blog/images/SentryBlog8.PNG)
I have been finding it difficult to debug my Angular frontend. As it is not possible to write to log files for the frontend, I am using Sentry to help with my error handling. I believe this will help a lot with some of the problems I'm having. Have also added a nav bar to the frontend in order to allow the user to go to different sections within the application. I'm still working on facial detection. It has gotten more accurate. I will start trying to implement what I have done into my application.

## Blog #9 09/03/2019: U.I Tests Shown To Supervisor- Changes needed
After meeting witb Alistair last week, he suggested formally writing up about user testing. I conducted a questionnaire and asked users their opinion on the User Interface. After receieving this feedback, I made some changes to the frontend. These tests were not designed to be about functionality but rather the design of the frontend of my application

## Blog #10 29/03/2019: Chat-bot Integrated Into Angular Frontend
![](docs/blog/images/Blog10Passport-bot.PNG)
Have successfully integrated chatbot into Angular frontend. I am using dialogflow(api.ai) for the NLP side of this. This allows me to train the chatbot to answer questions based on a passport application system. I will need to conduct User tests to help me find areas I may have missed with the training. I have included a screenshot of what the chatbot looks like in the frontend. I plan to change this by my next blog update as it doesnt look very appealing to the user now. The next step is to create my own chatbot service.

## Blog #11 01/04/2019: Unit Tests Added for REST API
I have been looking into unit testing my Rest Api. I have  been following some tutorials on how to test the springboot backend and have added the tests I have completed so far. In the future I would like to add these to a pipeline to run on a commit. I believe this would gain some extra marks under the "testing & validation" section.

## Blog #12 02/04/2019: Trello Update & Old UI shown 
![](docs/blog/images/TrelloBoardBlog12.PNG)
![](docs/blog/images/OldUserInterface.PNG)
I have provided an image of my trello board to show the progress of my project. I have also provided an image of the "old UI" before i made changes after the user feedback. I have added another unit Test for API GET request of single application. Meeting with Alistair today.

## Blog #13 06/04/2019: Email Confirmation For Users Working
![](docs/blog/images/PipelineTest.PNG)
I am currently working on getting email confirmation set up for when the user is finished their application. Due to ethics & GDPR, I cant store users actual email addresses, I will need to only allow for an email address of my choice to receieve this confirmation. This is a limiting factor and I will discuss this with supervisor. After meeting with Alistair this week, he made some suggestions about improving my UI/UX testing, I am currently working on this and will do a 2nd round of user testing in the following week. I have also been looking into setting up a pipeline to run my build and tests. I have successfully done this on a dummy project(see picture). I need to make some major adjustments to my file structure in this repository before being able to set up pipeline. This is of high priority.

## Blog #14 08/04/2019: Discussion About Email Confirmation With Supervisor
Met with supervisor to discuss if I should be using user email address for sending email confirmation to. I was told to not to this and stick with the approach I have taken which is using an email address of my choice to demonstrate this functionality. 

## Blog #15 11/04/2019: Fixed Incorrect URL Bug
![](docs/blog/images/SentryUncaughtError.PNG)
An error I came across was that if an incorrect URL was entered, this was not handled correctly and Sentry was able to detect this. I have fixed this problem and all incorrect URL calls will be redirected to the Home component. Over the past few days I have been trying to receieve the correct response from my facial-detection endpoint. I have successfully done this and can make some changes to my facial detection service now. I also had to do some major file structure changes, this is because I wanted to set up a YML file to build and test my project. I have successfully completed this.

## Blog #16 16/04/2019: Auto-Check Of User Image Added
![](docs/blog/images/PreviousImageUpload.PNG)
I made some changes to how the user inputs their image for the facial detection service. Previously the user would need to click a button that would submit their image for facial detection. I was able to change this so the image is uploaded to the service automatically. The user will then be given notice if their image was accepted. Currently this is done by some simple text but this may change in the future.

## Blog #17 20/04/2019: Some OpenCV/ Facial Detection Issues
![](docs/blog/images/ImagePostRequest.PNG)
I have spent the last few days working on post requests of an image to the springboot backend. There was a new errors I had to deal with as it is a 'multipart file'. I needed to pass more than just the file as a parameter in postman. That is now fixed. I then had an issue with showing the user the response from the backend. The response I was getting was the correct one, but because there was a slight delay, when I was doing checks I was getting undefined error. This has also been fixed by creating a asynchronous method. Made some changes to how the user is told if their upload was successful. This is done through a 'tick' or 'x' image. Fixed a bug where the application could never be completed. This was due to me naming one of the form controls differently when all are required to complete application

## Blog #18 22/04/2019: Facial Detection Working & Trello Update
![](docs/blog/images/TrelloBoardBlog18.PNG)

Above you will see how my trello board is looking. After completing the facial detection service yesterday, I will begin to look at validating user input. Based on articles I read [here][1] & [here][2] gave me an insight to the importance of this. I plan to do my input validation on my frontend, which will mean it should be a quicker and easier experience for the user.

[1]: https://www.sitepoint.com/validate-your-input/
[2]: https://searchsoftwarequality.techtarget.com/tip/The-importance-of-input-validation


## Blog #19 23/04/2019: User Input Validation & Springboot logging
I have been working on some user validation for my frontend. I have successfully implemented some built in validators but would like to create some of my own custom validators too. I have also implemented better logging for my springboot end. This would be better than having everything logged to the console. So now I have Sentry logging for my Angular frontend & Log files implemented for my backend.


## Blog #20 24/04/2019: About Section Complete & Custom Input Validation

![](docs/blog/images/dobBefore.PNG)
![](docs/blog/images/dobAfter.PNG)

Today I completed my 'About' section. This was done using Bootstrap cards to display the text. I had done some research about how to display text in a more appealing way and this was my favourite. I also have been working on creating better validation for my user input. As you can see in the images I have one created for date of birth. As these inputs are being passed to the database they need to be a correct format. I have also created validators for the other inputs in my application.


## Blog #21 25/04/2019: Unit Testing, Integration Testing & Deployment to Tomcat

![](docs/blog/images/TomCatError.PNG)

Today I was working on Testing a lot . I have added some new Unit tests as I am trying to improve my coverage within my application. I have also added the first of my integration Tests. I have also started looking into deploying my application onto a Tomcat server. I have successfully done this with my Springboot backend, but have the following error when trying to access my database through the tomcat server. I will look into this more, but will be focusing more on testing & Documention.

## Blog #22 28/04/2019:  UI Testing, Stress Testing & Acceptance Testing 

I have been spending the majority of my time testing my Web App. I have added a testing doc which can be found under the 'docs' sub directory. This document explains in detail the tests I have done. For Ui testing I am using protractor to mock how a user would interact with my web app and check the results are as exected. I looked into stress testing Using JMeter, this seems to be a very useful tool for this, Results from this are found in the document. Finally I did some Acceptance testing on my Frontend. This is done to make sure your system is useable for people with disabilities. I used to different tools for this 'Axe' & 'WCAG Accessibility Audit'. Results from that can also be found in the documentation. Based on some of the user testing results, my chatbot isnt as well trained as I expected. I will now spend some time training it to answer questions it was unable to answer during the user tests

## Blog #23 30/04/2019:  User Tests, System Tests & Code Tidy Up
![](docs/blog/images/TomcatDashboard.PNG)


I have completed 5 user tests as of now. Ideally I would like to complete some more before the deadline. System tests have been completed and everything passed as expected. As of now I will begin studying for my final exams and working on the Technical & User docs. I have also completed a code tidy up on the backend. The same will need to be done for my frontend code. I also tried to finish off my deployment to tomcat of my Angular side of my application. Unfortunately, I couldnt get this working. If I had more time I believe this would be working and could be worth marks. 

Steps Involved in Deployment to tomcat:

pre requisits:
	Download & tomcat 9.0
	I am using Port 8083 for tomcat

Springboot Deployment
	Needed to change some dependancies 
	Extend main class with SpringbootServlesInitializer
	Run maven Package(Should then get the WAR file)

Angular Deployment
	ng build --prod (ideal for deployment to production environment
	under tomcat 'Webapps' folder, create UI folder and copy build output into this
	Change the base url to new tomcat base url

## Blog #24 16/05/2019:  Database Problem. Fixed Pipeline. Working on Docs

A few days ago, I had a failed job on my pipeline. I had not made any changes to the backend code so I wasnt exactly sure why this happened. One of my tests failed due to ID's in the SQLite database not being unique. I havent figured out why this happened but I have fixed the problem. I am currently working on finishing off my documentation and video walkthrough. After this I can officially submit my project.


## Blog #25 18/05/2019:  Docs Complete, Video Walkthrough uploaded
Today is my last day working on the project. I have made the final changes to my documentation and completed my video walkthrough. I have also completed a code cleanup where it was necessary. All deliverables are in the appropriate locations. The testing doc is located under Testing as I felt this deserved its own documentation. I will send out an email now to my supervisor and appropriate examiners that my project has been finalised
