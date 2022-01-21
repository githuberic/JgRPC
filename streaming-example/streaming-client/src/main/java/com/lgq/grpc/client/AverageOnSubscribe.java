package com.lgq.grpc.client;

import com.lgq.server.streaming.MetricsServiceGrpc;
import com.lgq.server.streaming.StreamingExample;
import io.grpc.stub.StreamObserver;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lgq
 */
public class AverageOnSubscribe  implements Observable.OnSubscribe<StreamingExample.Average>{
    private final MetricsServiceGrpc.MetricsServiceStub stub;
    private final Observable<StreamingExample.Metric> metrics;

    public AverageOnSubscribe(Observable<StreamingExample.Metric> metrics, MetricsServiceGrpc.MetricsServiceStub stub) {
        this.stub = stub;
        this.metrics = metrics;
    }


    @Override
    public void call(Subscriber<? super StreamingExample.Average> subscriber) {
        final AtomicBoolean started = new AtomicBoolean(false);

        StreamObserver<StreamingExample.Metric> toServer = stub.collect(new StreamObserver<StreamingExample.Average>() {
            @Override
            public void onNext(StreamingExample.Average average) {
                if (started.compareAndSet(false, true)) {
                    subscriber.onStart();
                }
                subscriber.onNext(average);
            }

            @Override
            public void onError(Throwable throwable) {
                subscriber.onError(throwable);
            }

            @Override
            public void onCompleted() {
                try {
                    subscriber.onCompleted();
                } catch (Exception e) {
                    // catch this
                }
            }
        });

        metrics.forEach(toServer::onNext);

        toServer.onCompleted();
    }
}
