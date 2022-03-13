package com.org.grpc.grpcjavaservice.service;

import com.org.grpc.grpcjavaservice.MessageServiceGrpc;
import com.org.grpc.grpcjavaservice.Request;
import com.org.grpc.grpcjavaservice.Response;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/*
   This class is the implementation class for the message service that we defined in the .proto file.
   We need to add the @Grpcservice annotation to the class to easily classify that this impl class is an service impl class.
 */
@GrpcService
public class MessageServiceImplementation extends MessageServiceGrpc.MessageServiceImplBase {

    @Override
    public void sayHello(Request request, StreamObserver<Response> responseObserver) {
        String name = request.getName();

        Response response = Response.newBuilder()
                .setGreeting(String.format("Hello %s welcome!!!", name)).build();
        responseObserver.onNext(response); // to send the response to user // we can send multiple responses also
        responseObserver.onCompleted();// to close the connection
    }
}
