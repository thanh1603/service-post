package com.example.servicePost.rpc;

import com.example.servicePost.*;
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

    @Override
    public void updatePost(updatePostRequest request, StreamObserver<updatePostResponse> responseStreamObserver) {
        responseStreamObserver.onNext(postService.updatePost(request));
        responseStreamObserver.onCompleted();
    }

}
