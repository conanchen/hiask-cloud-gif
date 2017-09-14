package org.ditto.emoji;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.stub.StreamObserver;
import org.ditto.grpc.emoji.GifGrpc;
import org.ditto.grpc.emoji.GifOuterClass;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationSpringBoot.class, TestConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GifGrpcServiceTests {


    private ManagedChannel channel;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    @Qualifier("globalInterceptor")
    private ServerInterceptor globalInterceptor;


    @Before
    public void setup() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext(true)
                .build();
    }

    @After
    public void tearDown() {
        channel.shutdown();
    }

    @Test
    public void interceptorsTest() throws ExecutionException, InterruptedException {

        GifGrpc.newStub(channel)
                .listGifs(GifOuterClass.GifRequest.newBuilder().setPageSize(10).build(),
                        new StreamObserver<GifOuterClass.GifResponse>() {
                            @Override
                            public void onNext(GifOuterClass.GifResponse value) {

                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onCompleted() {

                            }
                        });

        GifGrpc.newBlockingStub(channel)
                .listGifs(GifOuterClass.GifRequest.newBuilder().setPageSize(10).build())
                .forEachRemaining(new Consumer<GifOuterClass.GifResponse>() {
                    @Override
                    public void accept(GifOuterClass.GifResponse emojiResponse) {

                    }
                });


        // global interceptor should be invoked once on each service
        Mockito.verify(globalInterceptor, Mockito.times(2))
                .interceptCall(Mockito.any(), Mockito.any(), Mockito.any());


        // log interceptor should be invoked only on GreeterService and not CalculatorService
        outputCapture.expect(CoreMatchers.containsString(GifGrpc.METHOD_LIST_EMOJIS.getFullMethodName()));

    }

}
