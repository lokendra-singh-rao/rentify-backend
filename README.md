# Rentify App Using Springboot Java and ReactJs
This is the backend Java application for Rentify app. It provides GraphQL APIs for user authentication using Firebase Authentication. The application is built with Spring Boot and communicates with Firebase to manage user authentication and MongoDB to manage user data.


## Technologies Used
Java
Spring Boot
Firebase Authentication
MongoDB 


## Getting Started
To run the application locally, follow these steps:

### Clone this repository.
Set up your Firebase project and add the necessary credentials to the application in FirebaseCofig.java file.
Set up your MongoDB account and add the necessary credentials to the application.properties file.


### Build and run the application using Gradle on your preferred IDE (I used STS-4.21.1).
Build using terminal using command
```bash
./gradlew build
```
Run using
```bash
./gradlew bootRun
```
OR
Run as Spring Boot App using default configurations of IDEs 


## Usage
Ensure the backend is running.
Use the frontend application (https://github.com/lokendra-singh-rao/rentify-frontend) to interact with the authentication APIs.


## Contributors
### Lokendra Singh Rao (https://github.com/lokendra-singh-rao/)


Feel free to customize this repo with more specific details about your project, such as installation instructions, API documentation, or additional features.
