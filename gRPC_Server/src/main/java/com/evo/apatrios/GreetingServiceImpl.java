package com.evo.apatrios;

import com.evo.apatrios.grpc.GreetingServiceGrpc;
import com.evo.apatrios.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver){

        System.out.println(request);

        for (int i = 0; i < 10000; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass
                    .HelloResponse.newBuilder().setGreeting("Hello from server, "+request.getName())
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

}
