package com.grpc.concept.s.service;
import com.grpc.Grpc.*;
import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;
@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);


        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received your " + message + ". Hello From Server. ")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
