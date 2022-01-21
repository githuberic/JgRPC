package com.lgq.grpc.client;

import com.lgq.server.streaming.MetricsServiceGrpc;
import com.lgq.server.streaming.StreamingExample;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.stream.Stream;

/**
 * @author lgq
 */
public class MetricsClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        MetricsServiceGrpc.MetricsServiceStub stub = MetricsServiceGrpc.newStub(channel);

        StreamObserver<StreamingExample.Metric> collect = stub.collect(new StreamObserver<StreamingExample.Average>() {
            @Override
            public void onNext(StreamingExample.Average value) {
                System.out.println("Average: " + value.getVal());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
            }
        });

        Stream.of(1L, 2L, 3L, 4L).map(l -> StreamingExample.Metric.newBuilder().setMetric(l).build()).forEach(collect::onNext);

        collect.onCompleted();

        //channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
