# Collapsar server

[![Build status](https://travis-ci.org/amolkov/collapsar-server.svg?branch=master)](https://travis-ci.org/amolkov/collapsar-server)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/31ee4fef810a4383b5f5eeaafd20b949)](https://www.codacy.com/app/amolkov/collapsar-server?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=amolkov/collapsar-server&amp;utm_campaign=Badge_Grade)

A simple web service for Astronomy Picture of the Day (APOD) written in Kotlin.

## Setting up

#### Clone the repo

```
$ git clone https://github.com/amolkov/collapsar-server.git
$ cd collapsar-server
```

#### API key

The app uses [NASA Astronomy Picture of the Day (APOD) API](https://api.nasa.gov/api.html#apod) to get pictures. You must provide your own [API key](https://api.nasa.gov/index.html#apply-for-an-api-key) in order to build the app.

Just put your API key into **_src/main/resources/application.properties_** (create the file if it doesn't exist already):

```
nasaApiKey=abc123
```

#### Database configuration

Put your database credentials into **_src/main/resources/persistence.properties_** (create the file if it doesn't exist already):

```
dataSource.url=jdbc:postgresql://localhost:5432/collapsardb
dataSource.username=postgres
dataSource.password=a
```

#### Database migrating

Put your database credentials into **_gradle.properties_** (create the file if it doesn't exist already):

```
flyway.url=jdbc:postgresql://localhost:5432/collapsardb
flyway.user=postgres
flyway.password=a
```

Before build you have to update your schema to the latest version with `$ ./gradlew flywayMigrate -i` command.

#### Building

You can build the app with `$ ./gradlew build` command.

## Libraries

* [**Flyway**](https://github.com/flyway/flyway): for database migrations.
* [**Hibernate**](https://github.com/hibernate/hibernate-orm): for orm mapping. 
* [**OkHttp**](https://github.com/square/okhttp): as http client.
* [**Retrofit**](https://github.com/square/retrofit): for communicating with web services.
* [**Spring**](https://github.com/spring-projects/spring-framework): as mvc framework

## License

    Copyright 2017 Alexander Molkov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
