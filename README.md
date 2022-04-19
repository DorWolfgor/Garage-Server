# Garage-Server
The project is divided into 4 parts:
1.) Application - the entry point for lifting the server.
2.) controller - rest controller - holds an instance of the server. Sends requests to a server that needs to be handled and returns responses according to each request.
3.) Model - Holds all the logic and classes that use the server.
A vehicle is an abstract class from which a car and motorcycle are inherited, which are also abstract classes.
From these classes inherit a gas vehicle, electric vehicle, gas motorcycle and electric motorcycle respectively.
In addition to this there is a truck class which inherits a vehicle.
Each vehicle has the appropriate fields, in addition there is a list of wheels and engine (abstract class - electric or gas engine depending on the vehicle).
4.) Service - owns a garage field, at this point the errors are captured and handled by changing the response status.

Instructions for installing and running the server:
open the cmd and run the following commands:
git clone https://github.com/DorWolfgor/Garage-Server
cd Garage-Server/out/artifacts/GarageServer_jar
java -jar "GarageServer-0.0.1-SNAPSHOT.jar"
