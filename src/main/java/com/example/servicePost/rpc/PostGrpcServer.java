package com.example.servicePost.rpc;

import com.example.servicePost.PostServiceGrpc;
import com.example.servicePost.createPostRequest;
import com.example.servicePost.createPostResponse;
import com.example.servicePost.service.PostService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PostGrpcServer  extends PostServiceGrpc.PostServiceImplBase {
    @Autowired
    private PostService postService;

    @Override
    public void createPost(createPostRequest request, StreamObserver<createPostResponse> responseObserver) {
        responseObserver.onNext(postService.createPost(request));
        responseObserver.onCompleted();
    }

}
