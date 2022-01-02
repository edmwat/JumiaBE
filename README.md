# JumiaBE
### The project is built in springboot framework.
### The project is consumed by an SPA build in *angular framework*.
# How to boot up the BE?
### Clone the project **git clone https://github.com/edmwat/JumiaBE.git**
### Open the project in eclipse.
#### You can **Run As -> Java Application** to run the application on localhost port 8080.
## To build a docker image...
#### Right click on the project and **Run As -> Maven Install**
#### This will build a jar file in the target/*.jar directory.
#### Then Use **docker build ...** to create an image.
#### *there's a Dockerfile file already included*
---
## This project is live on google Serverless Cloudrun.
### The BE is live on https://jumiabeservice-7euq3awlba-uc.a.run.app
### The image is built using jib-maven-plugin.
