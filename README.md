# OpenRouteService Java Client

Simple Java Client to parse OpenRouteService JSON responses using Jackson.

### What this Library Does

Parses JSON responses from OpenRouteService API V2 **DirectionsServiceGET** and **DirectionsServicePOST** endpoints. 

### Installation

Currently, this library is **not** available on Maven Central. To use with Gradle, build as a JAR using Intelli-J IDEA or other IDE, add the JAR to your project, and reference the location of the JAR in the dependencies section of your **build.gradle** file:

```
//Local packages
implementation files('../local_packages/ORS-J.jar')
```

### Example Usage

```java
//create connection object for routing server
HttpClient orsClient = HttpClient.newHttpClient();
        
DirectionsServicePOSTResult output = new DirectionsServicePOSTRequest(
                                "driving-car", //driver profile
                                36.37,    //latitude a
                                -94.2,    //longitude a
                                36.39,    //latitude b
                                -94.22,   //longitude b
                                0.6,      //Maximum fraction of the route that alternatives may share with the optimal route.
                                2,        //Target number of alternative routes to compute. 
                                1.4,       //Maximum factor by which route weight may diverge from the optimal route.
                                true,      //include avg speed
                                true,      //include elevation
                                max_speed, //max speed in mph
                                "mi",      //units
                                orsClient, //HttpCLient object
                                "http://localhost:8080/ors/v2/directions/", //server endpoint address
                                "api-key"
                        ).postDirections();
```


### Helpful Links

Tool to assist in generating classes mapped to JSON structures: https://github.com/joelittlejohn/jsonschema2pojo

OpenRouteService API V2 Documentation: https://openrouteservice.org/dev/#/api-docs

Method Chaining Example: https://www.javatpoint.com/method-chaining-in-java

### Contributions

Contributions are welcome! Please open an issue to start a conversation. 
