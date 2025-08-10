#这是基础镜像
#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
##复制jar包到镜像中，并且将名字改成app.jar
#ADD ./target/SpringBootWithDocker-1.0-SNAPSHOT.jar DemoApp.jar
##在容器启动的时候运行命令，来启动我们的项目（这其实就是一段Linux命令,该命令可以在服务启动时加一些参数）
#ENTRYPOINT ["sh", "-c", "java -jar DemoApp.jar"]


# 使用官方 OpenJDK 镜像
FROM openjdk:17-jdk-slim

# 创建目录
WORKDIR /app

# 复制 jar 文件到容器中
COPY ./*.jar app.jar

# 暴露端口（根据你的项目设定）
EXPOSE 8090

# 启动 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]