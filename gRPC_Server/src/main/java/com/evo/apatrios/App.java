package com.evo.apatrios;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println("Starting");
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();
        server.start();

        System.out.println("Server started");

        server.awaitTermination();
    }
}
