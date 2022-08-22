# scoreboard-lib [www.phlib.com](http://www.phlib.com)
scoreboard-lib is a Scoreboard library built for Java

## Requirement
Java 1.8 and above

## Use maven bulid to build this library.
use this command to install all the dependencies: mvn clean install

## Jar
Once maven build is done, you'll get the jar in target folder : scoreboard-lib-0.0.1.jar
Then you can use this jar in any java application

## How to use this lib
### 1st step 
Instantiate Scoreboard
    
##### Scoreboard scoreboard = Scoreboard.getInstance();
Then create a game with scoreboard method createGame
#####	Game game1 = new GameBuilder("Mexico", "Canada").build();
#####   scoreboard.createGame(game1);

Scoreboard has following methods : create, update, finish and summary

#### Please notify me if you are facing any challenges :)

##### Happy Coding
