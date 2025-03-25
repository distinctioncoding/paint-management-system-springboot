# 使用 OpenJDK 21 作为基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 Spring Boot JAR 文件
COPY target/paint-management-system-0.0.1-SNAPSHOT.jar app.jar

# 等待 MySQL 启动后再运行 Spring Boot 应用
ENTRYPOINT ["sh", "-c", "sleep 15 && java -jar app.jar"]