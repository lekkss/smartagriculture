// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SoilSensorService.proto

package com.lekkss.soilsensor.soilsensorservice;

public final class SoilSensorServiceProto {
  private SoilSensorServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lekkss_soilsensor_GetSoilDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lekkss_soilsensor_GetSoilDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lekkss_soilsensor_StreamSoilDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lekkss_soilsensor_StreamSoilDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lekkss_soilsensor_SoilData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lekkss_soilsensor_SoilData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027SoilSensorService.proto\022\025com.lekkss.so" +
      "ilsensor\"\024\n\022GetSoilDataRequest\"\027\n\025Stream" +
      "SoilDataRequest\"N\n\010SoilData\022\023\n\013temperatu" +
      "re\030\001 \001(\001\022\026\n\016soil_nutrients\030\002 \001(\001\022\025\n\rsoil" +
      "_humidity\030\003 \001(\0012\321\001\n\021SoilSensorService\022Y\n" +
      "\013GetSoilData\022).com.lekkss.soilsensor.Get" +
      "SoilDataRequest\032\037.com.lekkss.soilsensor." +
      "SoilData\022a\n\016StreamSoilData\022,.com.lekkss." +
      "soilsensor.StreamSoilDataRequest\032\037.com.l" +
      "ekkss.soilsensor.SoilData0\001BC\n\'com.lekks" +
      "s.soilsensor.soilsensorserviceB\026SoilSens" +
      "orServiceProtoP\001b\006proto3"
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
    internal_static_com_lekkss_soilsensor_GetSoilDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_lekkss_soilsensor_GetSoilDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lekkss_soilsensor_GetSoilDataRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_lekkss_soilsensor_StreamSoilDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_lekkss_soilsensor_StreamSoilDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lekkss_soilsensor_StreamSoilDataRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_lekkss_soilsensor_SoilData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_lekkss_soilsensor_SoilData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lekkss_soilsensor_SoilData_descriptor,
        new java.lang.String[] { "Temperature", "SoilNutrients", "SoilHumidity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}