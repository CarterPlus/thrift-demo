namespace java com.miaow.thrift

// 定义请求参数
struct HelloRequest {
    1: optional string say;
}

// 定义响应参数
struct HelloResponse {
    1: optional string msg;
}

// 定义异常
exception OutOfLengthException {
    1: optional string reason;
}

// 定义服务接口
service HelloWorldService {
    /**
    * 问候接口（可能抛出异常）
    */
    HelloResponse sayHello(1: HelloRequest request);
}