# wffweb demo app with wffweb-12.0.1 and GraalVM Java 23
##### Note: your system should have ~8GB free RAM to build native image and it may vary based on the project size.
#### It contains sample code for url rewriting/routing, JWT token based authentication/authorization and configuration for multi node support for scaling.


##### To run this project in IDE, open this project with IntelliJ IDEA as a maven project and run `com.webfirmframework.web.launcher.Main.main` method.

___

##### First Run the agent to generate/update needful config json files
execute command `mvn -Pnative -Dagent exec:exec@java-agent` and test all features to generate/update needful config files
under _graalvm_resources/META-INF/com.webfirmframework/wffwebappdemo/native-image_ directory.

___

##### To build native executable
execute command `mvn package -Pnative -Dagent package`

___

##### To run native executable on your machine
Go to target directory of the project, execute file as `./minimalproductionsample`

___

##### To run the application with Maven and as a native executable
execute command `mvn -Pnative exec:exec@native`

___



### How to scale app with multiple nodes?
The only thing you have to do is to deploy this app in multiple server nodes and connect it with a load balancer. 
**No need to configure sticky sessions to the load balancer**.

_(use your own domain names)_

**Eg**: _deploy this wffweb demo app in multiple domain nodes like node1.webfirmframework.com, node2.webfirmframework.com, node3.webfirmframework.com etc... 
Now create a load balancer in the main domain webfirmframework.com and point it to those subdomain nodes. That's all!_

**NB**: _The websocket connection should be publicly accessible in the subdomain nodes. 
The access to http connection in the subdomain nodes may be limited to the load balancer, 
to do that, the load balancer should route request to the nodes along with an app key,
this app key may be checked in the demo app._
