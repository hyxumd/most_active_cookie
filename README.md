# most_active_cookie
A Java application to get the most active cookie from a .csv log file on a given day.

## System requirements
* Java 8+
* Maven 3.1+

If you don't have Maven installed, please refer to the [Maven website](https://maven.apache.org/index.html).

## Brief introduction to the packages
* kernel - central component to manage interactions among packages
* input - parse command line options
* loader - load cookie log file and get cookie entries for the given day
* engine - analyze cookie entries and get the most active cookies
* exceptions - define exceptions thrown in this project
* test - run unit tests

## Build
Run `git clone https://github.com/hyxumd/most_active_cookie.git` to clone the repo to your local directory.

`cd most_active_cookie`

Run `mvn clean package` to build the project.

## Run
Make sure the current working directory is still in `most_active_cookie`.

Run `most_active_cookie.bat <log_path> -d <date>` to execute the Java application.