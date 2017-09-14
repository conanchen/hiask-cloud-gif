package org.ditto.emoji.grpc;

import io.grpc.stub.StreamObserver;
import org.ditto.emoji.model.Gif;
import org.ditto.emoji.repository.GifRepository;
import org.ditto.grpc.emoji.GifGrpc;
import org.ditto.grpc.emoji.GifOuterClass;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

@GRpcService(interceptors = {LogInterceptor.class})
public class GifGrpcService extends GifGrpc.GifImplBase {
    @Autowired
    private GifRepository gifRepository;

    @Override
    public void listGifs(GifOuterClass.GifRequest request, StreamObserver<GifOuterClass.GifResponse> responseObserver) {

        Iterable<Gif> emojiIterable = gifRepository.findAll();
        Iterator<Gif> emojiIterator = emojiIterable.iterator();
        int count = 0;
        while (emojiIterator.hasNext() && count < request.getPageSize()) {
            Gif gif = emojiIterator.next();
            GifOuterClass.GifResponse.Builder replyBuilder = GifOuterClass.GifResponse
                    .newBuilder()
                    .setCodepoint(gif.codepoint)
                    .setCodepointu16(gif.codepointu16)
                    .setGroupId(gif.groupId)
                    .setSubgroupId(gif.subgroupId)
                    .setName(gif.name)
                    .setSequence(gif.sequence)
                    .setLastUpdated(gif.lastUpdated)
                    .setActive(gif.active);
            responseObserver.onNext(replyBuilder.build());
            count++;
        }
        responseObserver.onCompleted();
    }
}
