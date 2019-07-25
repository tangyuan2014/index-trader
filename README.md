# Application calculating best stock profit interval

## How to run
Application is built based on Java, Springboot and maven, to run it on 
your machine you need to have Java and Maven installed. Then run the 
following command
````
mvn spring-boot:run
````

## How to get the result
You simple hit your browser with 
````
localhost:8080/answertopuzzle
````

## How it works
When you hit the url, the application will fetch the live data from:

```https://modularfinance.se/static/files/puzzles/index-trader.json```

Then parse the "data" from the response to calculate the result and 
return as json.

## Algorithm
The basic idea of the algorithm is we always want to remember what was 
the lowest point the past, then we could get the best profit for the 
current day(data), and use that profit to check if it is the best ever. 
Then remember it if it is the best so far.