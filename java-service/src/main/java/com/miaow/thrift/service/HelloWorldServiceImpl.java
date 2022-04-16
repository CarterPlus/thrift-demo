package com.miaow.thrift.service;

import com.miaow.thrift.iface.hello_world.HelloRequest;
import com.miaow.thrift.iface.hello_world.HelloResponse;
import com.miaow.thrift.iface.hello_world.HelloWorldService;
import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public HelloResponse sayHello(HelloRequest request) throws TException {
        System.out.println("request: " + request.getSay());
        HelloResponse response = new HelloResponse();
        response.setMsg("Hello " + request.getSay());
        return response;
    }
}
