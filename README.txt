Micronauts + GraalVM test; Quarkus; Helidon (SE/MP)

Technologies:

Windows 10 x64 profesional Edition
Eclipse Java 2019-06 (V 4.12.0)
Microsoft Windows SDK 7.1 (Net 4.0)
Maven 3.9
GraalVM - CE - 19.1.1
Micronaut - 1.2.1
Quarkus - 1.0.0.CR2
Helidon (SE/MP) - 0.10.2
Unirest-Java - 3.3.00
Eclipse Rest Client Microprofile - 1.2.1

Programs:

1)Graal: Micronaut + GraalVM Example.
	   For running as a micronaut java application ==> gradlew run 
	   For running as a GraalVM standalone application ==> run.bat


Note: instructions for converting sunec.dll and sunmscapi.dll to sunec.lib; sunmscapi.lib
1.1) Run Microsoft Windows SDK 7.1 prompt system
1.2) follow next instructions (/machine:x64 instead of /machine:x86)
http://asawicki.info/news_1420_generating_lib_file_for_dll_library

2)QuarkusProject:

2.1)quarkus scaffold program construction with maven:

  mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
    -DprojectGroupId=my-groupId \
    -DprojectArtifactId=my-artifactId \
    -DprojectVersion=my-version \
    -DclassName="org.my.group.MyResource" 
  
2.2)run program: mvnw compile quarkus:dev

3)HelidonMPProject:

3.1)helidon MP scaffold program construction with maven:
  
   mvn archetype:generate -DinteractiveMode=false 
    -DarchetypeGroupId=io.helidon.archetypes
    -DarchetypeArtifactId=helidon-quickstart-mp -DarchetypeVersion=0.11.0 
    -DgroupId=io.helidon.examples -DartifactId=quickstart-mp 
    -Dpackage=io.helidon.examples.quickstart.mp	  

4)HelidonSEProject:

4.1)helidon SE scaffold program construction with maven:
   
   mvn archetype:generate -DinteractiveMode=false \
    -DarchetypeGroupId=io.helidon.archetypes \
    -DarchetypeArtifactId=helidon-quickstart-se \
    -DarchetypeVersion=0.10.2 \
    -DgroupId=[io.helidon.examples] \
    -DartifactId=[quickstart-se] \
    -Dpackage=[io.helidon.examples.quickstart.se]


https://code.quarkus.io/
https://lordofthejars.github.io/quarkus-cheat-sheet/
https://blogs.oracle.com/javamagazine/helidon-a-simple-cloud-native-framework#anchor_2
