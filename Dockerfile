FROM tomcat

RUN apt-get update -y

RUN apt-get install -f

RUN apt-get install git -y

RUN apt-get install nodejs -y

RUN apt-get install npm -y

RUN mkdir -p /tmp/build

ADD /Part_2/build/libs/part2-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080