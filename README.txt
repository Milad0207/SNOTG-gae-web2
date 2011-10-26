Updated 10/14/11

Steps to pull down, compile and run this project

1.  Install the Google App Engine plug-in for eclipse.  This plugin adds the necessary libraries and project config.
2.  Pull down the gae-web project.
3.  Build it.  It should build without errors.  With the eclipse plugin, it should have all the necessary libs.  
I added 4 libs to the lib dir to enable to JUnit testing
4.  Run the Junit tests in the 'test/guestbook' dir.
5.  Then you can start the GAE.  Do this by selecting the project name and right-click; Run-as > Web Application (NOTE:
choose the one with the 'g' icon).
6.  This will start a Jetty container.
7.  Try the url:  http://localhost:8888/guestbook.jsp.  This is the demo app using the Google HRD db.
  7a.  Try url:  http://localhost:8888/guestbook.jsp?guestbookName=mike to create a different guestbook
  7b.  Try url:   http://localhost:8888 and click the 'guestbook' link.  This will execute the login process.  NOTE:
        once deployed to cloud GAE will the actual Google auth service be excecuted.
