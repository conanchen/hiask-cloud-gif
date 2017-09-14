package org.ditto.grpc.gif;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The gif service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.5.0)",
    comments = "Source: gif.proto")
public final class GifGrpc {

  private GifGrpc() {}

  public static final String SERVICE_NAME = "Gif";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.ditto.grpc.gif.GifOuterClass.GifRequest,
      org.ditto.grpc.gif.GifOuterClass.GifResponse> METHOD_LIST_GIFS =
      io.grpc.MethodDescriptor.<org.ditto.grpc.gif.GifOuterClass.GifRequest, org.ditto.grpc.gif.GifOuterClass.GifResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "Gif", "ListGifs"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.gif.GifOuterClass.GifRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.gif.GifOuterClass.GifResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GifStub newStub(io.grpc.Channel channel) {
    return new GifStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GifBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GifBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GifFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GifFutureStub(channel);
  }

  /**
   * <pre>
   * The gif service definition.
   * </pre>
   */
  public static abstract class GifImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifs whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifs.
     * </pre>
     */
    public void listGifs(org.ditto.grpc.gif.GifOuterClass.GifRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.gif.GifOuterClass.GifResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_GIFS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIST_GIFS,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.ditto.grpc.gif.GifOuterClass.GifRequest,
                org.ditto.grpc.gif.GifOuterClass.GifResponse>(
                  this, METHODID_LIST_GIFS)))
          .build();
    }
  }

  /**
   * <pre>
   * The gif service definition.
   * </pre>
   */
  public static final class GifStub extends io.grpc.stub.AbstractStub<GifStub> {
    private GifStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GifStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GifStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GifStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifs whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifs.
     * </pre>
     */
    public void listGifs(org.ditto.grpc.gif.GifOuterClass.GifRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.gif.GifOuterClass.GifResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_GIFS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The gif service definition.
   * </pre>
   */
  public static final class GifBlockingStub extends io.grpc.stub.AbstractStub<GifBlockingStub> {
    private GifBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GifBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GifBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GifBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Gifs whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of gifs.
     * </pre>
     */
    public java.util.Iterator<org.ditto.grpc.gif.GifOuterClass.GifResponse> listGifs(
        org.ditto.grpc.gif.GifOuterClass.GifRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_GIFS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The gif service definition.
   * </pre>
   */
  public static final class GifFutureStub extends io.grpc.stub.AbstractStub<GifFutureStub> {
    private GifFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GifFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GifFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GifFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIST_GIFS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GifImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GifImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GIFS:
          serviceImpl.listGifs((org.ditto.grpc.gif.GifOuterClass.GifRequest) request,
              (io.grpc.stub.StreamObserver<org.ditto.grpc.gif.GifOuterClass.GifResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class GifDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.ditto.grpc.gif.GifOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GifGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GifDescriptorSupplier())
              .addMethod(METHOD_LIST_GIFS)
              .build();
        }
      }
    }
    return result;
  }
}
