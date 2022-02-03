package com.evo.apatrios;

import com.evo.apatrios.grpc.GreetingServiceGrpc;
import com.evo.apatrios.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest
                .newBuilder().setName("Mikhail").build();

        long t1 = System.currentTimeMillis();
        Iterator<GreetingServiceOuterClass.HelloResponse> response = stub.greeting(request);

        while (response.hasNext()){
            System.out.println(response.next());
        }

        channel.shutdownNow();
        System.out.println(System.currentTimeMillis() - t1+" --> 10000 Stream messages");
    }
}
