# thrift-demo

thrift-api-demo

#### 执行步骤

1. 创建thrift-demo文件夹和thrift-api子文件夹
2. 编写测试的thrift服务接口hello_world_service.thrift
3. 生成java-service服务的maven项目

```
mvn archetype:generate "-DgroupId=com.miaow.thrift" "-DartifactId=java-service" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

4. 将thrift服务接口生成java实现代码

```
thrift -out ./java-service/src/main/java --gen java ./thrift-api/hello_world_service.thrift
``` 

5. 在java项目中引入maven依赖

```
<!-- https://mvnrepository.com/artifact/org.apache.thrift/libthrift -->
<dependency>
    <groupId>org.apache.thrift</groupId>
    <artifactId>libthrift</artifactId>
    <version>0.16.0</version>
</dependency>
```

6. 编写Java的实现类HelloWorldServiceImpl.java
7. 创建一个也是java的客户端java-client

```
mvn archetype:generate "-DgroupId=com.miaow.thrift" "-DartifactId=java-client" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```