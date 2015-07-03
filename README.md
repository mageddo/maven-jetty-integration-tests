## introduction
This example  is a example of integration test using `jetty` as servlet container to run with the integration test, jetty runs on `8181` port but it is configurable, the example cover:

 1. A simple WEB project with a HelloWorldServlet that hava a `GET` and a `POST` method.
 2.  A integration test that run the project in jetty and test yours URLs responses

## to test
```
mvn clean install
```

## important!!
Make sure that you have not a `jetty-web.xml` in your `WEB-INF` folder or change the path in `com.mageddo.tests.core.Properties.java` to the `jetty.web.xml` path