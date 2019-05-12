# Meteorites Android App 
This app is made as a portfolio app mainly for job interviews purposes.

## Task
Create simple app which shows list and total count of meteorites which fall onto Earth surface since the year 2011. Meteorites will be ordered from the biggest to the smallest. After click on a meteorite in the list - map will appear with the pin where meteorite fell. List of meteorites should be visible also in offline state. Database should be synced once a day, even if user does not run the app. Use NASA endpoint to get the meteorites: https://data.nasa.gov/resource/y77d-th95.json

## Frameworks and technology used
### Android Architecture components
* Data Binding 
* Live Data
* Paging 
* ViewModel
* Navigation
* Room
* WorkManager

### Other
* Android framework
* Android material components
* Google maps (play service)
* Kotlin
* Kotlin coroutines as async and background task library
* Dagger for dependency injection
* Moshi for parsing JSON and mapping it to Kotlin objects
* OkHttp as HTTP client
* Retrofit as REST client

## Building requirements
App will only behaves properly, if API keys for both [Google Maps](https://cloud.google.com/maps-platform/?_ga=2.92866905.558884746.1543852761-682767570.1541490318#get-started) and [NASA endpoint](https://data.nasa.gov/login) are provided. 
