#这是基础镜像
FROM java:8
VOLUME /tmp
#复制jar包到镜像中，并且将名字改成app.jar
ADD ./target/SpringBootResearch-1.0-SNAPSHOT.jar DemoApp.jar
#在容器启动的时候运行命令，来启动我们的项目（这其实就是一段Linux命令）
#ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8"
#ENV LANG en_US.UTF-8 ENV LANGUAGE en_US:en ENV LC_ALL en_US.UTF-8
ENTRYPOINT java -jar -Dspring.profiles.active=local DemoApp.jar

#["sh", "-c", "java -jar DemoApp.jar"]


