# What this APP does?
- User can find standings of a team playing league football match using country name, league name and team name. For Eg. country=england , league=Championship and team=swansea
- The app uses https://apifootball.com/documentation/ API to fetch country, league and standing and displays them in the response.

# Key Features of the APP
- It uses Declarative REST Client: Feign to call services.
- Uses Eureka Service Registration and Discovery which enables client-side load-balancing and decouples service providers from consumers without the need for DNS.
- Application configuration are stored and fetched from Spring Cloud Config server for externalized configuration in a distributed system.
