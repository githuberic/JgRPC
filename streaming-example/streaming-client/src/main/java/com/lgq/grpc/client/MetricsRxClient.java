package com.lgq.grpc.client;

import com.lgq.server.streaming.MetricsServiceGrpc;
import com.lgq.server.streaming.StreamingExample;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rx.Observable;

import java.util.concurrent.ExecutionException;

/**
 * @author lgq
 */
public class MetricsRxClient {
    private final Channel channel;
    private final MetricsServiceGrpc.MetricsServiceStub stub;

    MetricsRxClient(Channel channel) {
        this.channel = channel;
        this.stub = MetricsServiceGrpc.newStub(channel);
    }

    public Observable<StreamingExample.Average> collect(Observable<StreamingExample.Metric> metrics) {
        return Observable.create(new AverageOnSubscribe(metrics, stub));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext().build();

        rx.Observable<Long> metrics = rx.Observable.from(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L});

        MetricsRxClient client = new MetricsRxClient(channel);

        client.collect(metrics.map(l -> StreamingExample.Metric.newBuilder().setMetric(l).build()))
                .subscribe(System.out::println);
    }
}
