# What this APP does?
- User can find standings of a team playing league football match using country name, league name and team name. For Eg. country=england , league=Championship and team=swansea
- The app uses https://apifootball.com/documentation/ API to fetch country, league and standing and displays them in the response.

# Key Features of the APP
- It uses Declarative REST Client: Feign to call services.
- Uses Eureka Service Registration and Discovery which enables client-side load-balancing and decouples service providers from consumers without the need for DNS.
- Application configuration are stored and fetched from Spring Cloud Config server for externalized configuration in a distributed system.

#### Input
- Country : 'France'
- League  : 'Ligue 2'
- Team    : 'Grenoble'

#### Output
```
	{
	    "Country ID & Name: ":"46 - France",
      "League ID & Name: ":"177 - Ligue 2",
      "Team ID & Name: ":"3078 - Grenoble",
      "Overall League Position: ":"4"
	} 
```

###### 
The app has been dockerized. Docker images for individual microservices can be found at https://hub.docker.com/repositories/subhash06582

How to Run App on LOCAL using DOKCER
```
1) git clone https://github.com/subhash06582/standing-api
2) cd standing-api
3) Go to indivudual folders (i.e. /config-server /country-service, /league-service, /naming-server /position-service /standing-service) and RUN './mvn clean install' to build *.jar' file
3) Return back to main folder (/standing-api)
4) Run 'docker-compose up' cmd. This will build docker images in a correct order from the docker-compose.yml file present at root.
```

## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Country Service | 8801, ...  |
| League Service | 8802, ... |
| Standing Service | 8803, ... |
| Netflix Eureka Naming Server | 8761 |
| Spring cloud config Server | 8888 |
| Position Service API | 8080 |

