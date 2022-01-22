package com.lgq.grpc.hello.server;

import com.lgq.grpc.hello.GreeterGrpc;
import com.lgq.grpc.hello.HelloReply;
import com.lgq.grpc.hello.HelloRequest;
import io.grpc.stub.StreamObserver;

/**
 * @author lgq
 * 实现 定义一个实现服务接口的类
 */
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply helloResponse = HelloReply
                .newBuilder()
                .setMessage("Hello " + req.getName() + ", I'm Java grpc Server")
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
        System.out.println("Message from gRPC-Client:" + req.getName());
    }
}
