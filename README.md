# ingest-core
Core ingest service components, including minimal metadata representation and caching

# Dependencies for Ubuntu 16.04

* Update Ubuntu first
  * `sudo apt-get update`
* Install Java JDK and Gradle
  * `sudo apt-get install openjdk-8-jdk`
  * `sudo apt-get install gradle`
* Install RabbitMQ
  * `wget https://github.com/rabbitmq/rabbitmq-server/releases/download/rabbitmq_v3_6_12/rabbitmq-server_3.6.12-1_all.deb`
  * `sudo dpkg -i rabbitmq-server_3.6.12-1_all.deb`
  * `sudo apt-get install -f`
  * `sudo service rabbitmq-server start`
* Install MongoDB
  * `sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 0C49F3730359A14518585931BC711F9BA15703C6`
  * `echo "deb [ arch=amd64,arm64 ] http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.4.list`
  * `sudo apt-get update`
  * `sudo apt-get install -y mongodb-org`
  * `sudo service mongod start`
* If Mongo connection is refused
  * `sudo rm /var/lib/mongodb/mongod.lcok`
  * `sudo mongod --repair`
  * `sudo service mongod start`

# How to Build and Run

* `./gradlew build`
* `java -jar ./build/libs/ingest-core-0.0.1-SNAPSHOT.jar`

# How to Test

* You can follow many of the examples listed in docs/ingest-api-walkthrough.md,
  but substitute http://api.ingest.dev.data.humancellatlas.org/ with
  127.0.0.1:8080
  * For instance, with step one in that document, you can run the following
    command: `curl -X GET 127.0.0.1:8080`
  * Or for example two: `curl -X POST -H "Content-Type: application/json"
    127.0.0.1:8080/submissionEnvelopes -d {}`
