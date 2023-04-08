FROM tomcat:9-jdk11-openjdk-slim
VOLUME /tmp
COPY target/my-spring-boot-app.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]