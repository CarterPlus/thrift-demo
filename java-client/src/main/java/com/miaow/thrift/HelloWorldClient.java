package com.miaow.thrift;

import com.miaow.thrift.iface.hello_world.HelloRequest;
import com.miaow.thrift.iface.hello_world.HelloResponse;
import com.miaow.thrift.iface.hello_world.HelloWorldService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.LoggerFactory;

public class HelloWorldClient {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HelloWorldClient.class);

    public static void main(String[] args) {

        LOGGER.info("HelloWorldClient start");

        TTransport transport = null;
        try {
            // 设置调用的服务地址为本地，端口为8080,超时设置为30秒
            transport = new TSocket("localhost", 8080, 30000);

            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();

            // 调用接口方法
            HelloRequest helloRequest = new HelloRequest();
            helloRequest.setSay("Thrift");
            HelloResponse helloResponse = client.sayHello(helloRequest);
            LOGGER.info("response: {}", helloResponse.getMsg());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
            LOGGER.info("HelloWorldClient end");
        }
    }
}
