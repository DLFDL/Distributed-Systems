// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: airConditionControl.proto

package airConditionControl;

public final class airConditionControlImpl {
  private airConditionControlImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_LoginResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_UpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_UpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_UpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_UpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_LogoutRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_LogoutRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_LogoutResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_LogoutResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_ErrorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_ErrorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_airConditionControl_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_airConditionControl_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031airConditionControl.proto\022\023airConditio" +
      "nControl\"2\n\014LoginRequest\022\020\n\010username\030\001 \001" +
      "(\t\022\020\n\010password\030\002 \001(\t\">\n\rLoginResponse\022\027\n" +
      "\017responseMessage\030\001 \001(\t\022\024\n\014responseCode\030\002" +
      " \001(\005\"$\n\rUpdateRequest\022\023\n\013requestCode\030\001 \001" +
      "(\005\"?\n\016UpdateResponse\022\027\n\017responseMessage\030" +
      "\001 \001(\t\022\024\n\014responseCode\030\002 \001(\005\"!\n\rLogoutReq" +
      "uest\022\020\n\010username\030\001 \001(\t\"?\n\016LogoutResponse" +
      "\022\027\n\017responseMessage\030\001 \001(\t\022\024\n\014responseCod" +
      "e\030\002 \001(\005\"J\n\rErrorResponse\022\020\n\010username\030\001 \001" +
      "(\t\022\020\n\010password\030\002 \001(\t\022\025\n\rexpectedValue\030\003 " +
      "\001(\t\"\007\n\005Empty2\225\002\n\023airConditionControl\022P\n\005" +
      "login\022!.airConditionControl.LoginRequest" +
      "\032\".airConditionControl.LoginResponse\"\000\022W" +
      "\n\006update\022\".airConditionControl.UpdateReq" +
      "uest\032#.airConditionControl.UpdateRespons" +
      "e\"\000(\0010\001\022S\n\006logout\022\".airConditionControl." +
      "LogoutRequest\032#.airConditionControl.Logo" +
      "utResponse\"\000B0\n\023airConditionControlB\027air" +
      "ConditionControlImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_airConditionControl_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_airConditionControl_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_LoginRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_airConditionControl_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_airConditionControl_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_LoginResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
    internal_static_airConditionControl_UpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_airConditionControl_UpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_UpdateRequest_descriptor,
        new java.lang.String[] { "RequestCode", });
    internal_static_airConditionControl_UpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_airConditionControl_UpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_UpdateResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
    internal_static_airConditionControl_LogoutRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_airConditionControl_LogoutRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_LogoutRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_airConditionControl_LogoutResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_airConditionControl_LogoutResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_LogoutResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
    internal_static_airConditionControl_ErrorResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_airConditionControl_ErrorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_ErrorResponse_descriptor,
        new java.lang.String[] { "Username", "Password", "ExpectedValue", });
    internal_static_airConditionControl_Empty_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_airConditionControl_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_airConditionControl_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}