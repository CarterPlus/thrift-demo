package com.miaow.thrift;

import com.miaow.thrift.iface.hello_world.HelloWorldService;
import com.miaow.thrift.service.HelloWorldServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.LoggerFactory;

/**
 * 服务端启动代码
 */
public class ThriftServiceServer {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ThriftServiceServer.class);

    public static void main(String[] args) throws TTransportException {
        LOGGER.info("ThriftServiceServer start...");

        // 关联处理器
        HelloWorldService.Processor<HelloWorldService.Iface> processor =
                new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());

        // 设置服务端口为8080
        TServerSocket serverSocket = new TServerSocket(8080);

        // 简单的单线程服务模型
        TServer.Args tArgs = new TServer.Args(serverSocket);
        tArgs.processor(processor);

        // 设置协议工厂为 TBinaryProtocol.Factory
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TSimpleServer tSimpleServer = new TSimpleServer(tArgs);

        // 启动服务
        tSimpleServer.serve();

        LOGGER.info("ThriftServiceServer start success.");
    }
}
