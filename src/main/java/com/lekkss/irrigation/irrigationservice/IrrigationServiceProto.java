// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IrrigationService.proto

package com.lekkss.irrigation.irrigationservice;

public final class IrrigationServiceProto {
  private IrrigationServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lekkss_irrigation_IrrigationResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lekkss_irrigation_IrrigationResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lekkss_irrigation_IrrigationSoilData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lekkss_irrigation_IrrigationSoilData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027IrrigationService.proto\022\025com.lekkss.ir" +
      "rigation\"-\n\020IrrigationResult\022\031\n\021irrigati" +
      "on_needed\030\001 \001(\010\"X\n\022IrrigationSoilData\022\023\n" +
      "\013temperature\030\001 \001(\001\022\026\n\016soil_nutrients\030\002 \001" +
      "(\001\022\025\n\rsoil_humidity\030\003 \001(\0012\206\001\n\021Irrigation" +
      "Service\022q\n\025CheckIrrigationNeeded\022).com.l" +
      "ekkss.irrigation.IrrigationSoilData\032\'.co" +
      "m.lekkss.irrigation.IrrigationResult\"\000(\001" +
      "0\001BC\n\'com.lekkss.irrigation.irrigationse" +
      "rviceB\026IrrigationServiceProtoP\001b\006proto3"
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
    internal_static_com_lekkss_irrigation_IrrigationResult_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_lekkss_irrigation_IrrigationResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lekkss_irrigation_IrrigationResult_descriptor,
        new java.lang.String[] { "IrrigationNeeded", });
    internal_static_com_lekkss_irrigation_IrrigationSoilData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_lekkss_irrigation_IrrigationSoilData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lekkss_irrigation_IrrigationSoilData_descriptor,
        new java.lang.String[] { "Temperature", "SoilNutrients", "SoilHumidity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}