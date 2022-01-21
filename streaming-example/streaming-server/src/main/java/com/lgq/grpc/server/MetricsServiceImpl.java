package com.lgq.grpc.server;

import com.lgq.server.streaming.MetricsServiceGrpc;
import com.lgq.server.streaming.StreamingExample;
import io.grpc.stub.StreamObserver;

public class MetricsServiceImpl extends MetricsServiceGrpc.MetricsServiceImplBase {
    @Override
    public StreamObserver<StreamingExample.Metric> collect(StreamObserver<StreamingExample.Average> responseObserver) {
        return new StreamObserver<StreamingExample.Metric>() {
            private long sum = 0;
            private long count = 0;

            @Override
            public void onNext(StreamingExample.Metric value) {
                System.out.println("value: " + value);
                sum += value.getMetric();
                count++;
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(StreamingExample.Average.newBuilder()
                        .setVal(sum / count)
                        .build());
            }
        };
    }
}
