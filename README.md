# RemindAlerter
CMSC 495 - Group6 Project remindAlerter

To run this project you will need to set up following prerequisites

<h4>* Install java </h4>
make sure you install java on you local machine. 
run the following command in your command line </br>
      <code>java -version</code>
<h4>* Install maven </h4>
Download maven from https://maven.apache.org/download.cgi
unzip the file to a destination of your choice. Then add the location in to you "enviroment variable".
 eg. <code>C:\Java\apache-maven-3.6.0\bin</code>
<h4>* Install sts (spring tool suite), eclipse of IDE of your choice </h4>
  - sts - https://spring.io/tools
  - eclipse - https://www.eclipse.org/downloads/
<h4>* Open the project from your IDE </h4>
After you clone this project form github please follow the following steps to run the application locally

To clone the project please run the following command using your command prompt
<code> git clone https://github.com/gezealebe/remindAlerter.git </code>
then check out develop branch
<code> git checkout develop</code>

if you have not install git follow this link to downloadand install https://git-scm.com/download/win
In eclipse or sts click File > Import > Existing Maven Projects > then open the project you check out form github.
Right click on the project click Run As > Maven build.. 
on the Edit configuration popup write <code> clean install </code> on the Goal input filed then click Run
one the build successfully executed

Click Run As > Spring Boot App once complete

then access the application using http://localhost:8080/remindalerter/ url




