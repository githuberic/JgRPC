// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package com.lgq.grpc.armeria;

public final class HelloProto {
  private HelloProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hello_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hello_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hello_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hello_HelloReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013hello.proto\022\005hello\"\034\n\014HelloRequest\022\014\n\004" +
      "name\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(" +
      "\t2\352\002\n\014HelloService\0221\n\005Hello\022\023.hello.Hell" +
      "oRequest\032\021.hello.HelloReply\"\000\0225\n\tLazyHel" +
      "lo\022\023.hello.HelloRequest\032\021.hello.HelloRep" +
      "ly\"\000\0229\n\rBlockingHello\022\023.hello.HelloReque" +
      "st\032\021.hello.HelloReply\"\000\022;\n\rLotsOfReplies" +
      "\022\023.hello.HelloRequest\032\021.hello.HelloReply" +
      "\"\0000\001\022=\n\017LotsOfGreetings\022\023.hello.HelloReq" +
      "uest\032\021.hello.HelloReply\"\000(\001\0229\n\tBidiHello" +
      "\022\023.hello.HelloRequest\032\021.hello.HelloReply" +
      "\"\000(\0010\001B*\n\024com.lgq.grpc.armeriaB\nHelloPro" +
      "toP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_hello_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_hello_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hello_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_hello_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_hello_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hello_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
