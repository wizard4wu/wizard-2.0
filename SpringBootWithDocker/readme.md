## Docker部署SpringBoot项目

### 1.准备Jar包
+ 运行mvn clean package命令生成target目录；
+ target目录中有个SpringBootWithDocker-1.0-SNAPSHOT.jar文件；
+ 如果你使用的是云服务器需要上传，我使用的是Mac本地； 
   ```shell
    scp -i {公钥文件地址} {待上传的jar包地址} {用户名}@{ip}:~/target/
   ```

### 2.制作镜像
+ 编写Dockerfile文件制作镜像 
  ```shell
   docker build -f ./Dockerfile -t app-image .
  ```
使用docker images查看该应用生成的镜像文件
### 3.运行镜像文件：
docker run -d -p 8080:8080 --name my-app app-image
