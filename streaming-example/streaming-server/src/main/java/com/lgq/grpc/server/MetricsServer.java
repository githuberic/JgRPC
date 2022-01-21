package com.lgq.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author lgq
 */
public class MetricsServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8080).addService(new MetricsServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
