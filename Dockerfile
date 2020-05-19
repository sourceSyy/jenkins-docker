FROM openjdk:8-jre

MAINTAINER sourcesyy sourcesyy@works-display.com

RUN useradd -u 1000 -d /opt/works -s /bin/bash -r works

#准备可执行文件
COPY ./target/jenkins-docker-0.0.1-SNAPSHOT.jar /opt/works/jenkins-docker.jar
#COPY ./target/classes/application.properties /opt/works/conf/docker-default.properties
#COPY ./target/classes/application.properties /opt/works/conf/docker-deploy.properties
#COPY ./target/classes/application.properties /opt/works/conf/docker-test.properties

# environment variables
ENV UNIT=jenkins-docker
ENV PORT=9011
ENV PROFILE=default
ENV MEMORY=1G

# prepare services
EXPOSE ${PORT}

VOLUME /opt/works/conf
VOLUME /tmp

WORKDIR /opt/works

ENTRYPOINT java -Xms${MEMORY} -Xmx${MEMORY} -jar /opt/works/${UNIT}.jar --server.port=${PORT} #--spring.config.location=/opt/works/conf/ --spring.config.name=${UNIT} --spring.profiles.active=${PROFILE}
