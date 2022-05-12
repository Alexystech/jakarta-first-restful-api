# jakarta-first-restful-api

This RESTful API was developed with **Payara Micro Maven Archetype**

mvn archetype:generate "-DarchetypeGroupId=fish.payara.maven.archetypes" "-DarchetypeArtifactId=payara-micro-maven-archetype" "-DarchetypeVersion=1.4.0" "-DgroupId=com.slasher" "-DartifactId=jakarta-project" "-Dversion=1.0-SNAPSHOT" "-Dpackage=com.slasher" "-Darchetype.interactive=false"

## Run project
- mvn clean package
- mvn clean package payara-micro:start
