// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IrrigationService.proto

package com.lekkss.irrigation.irrigationservice;

/**
 * Protobuf type {@code com.lekkss.irrigation.ToggleIrrigationRequest}
 */
public  final class ToggleIrrigationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lekkss.irrigation.ToggleIrrigationRequest)
    ToggleIrrigationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ToggleIrrigationRequest.newBuilder() to construct.
  private ToggleIrrigationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ToggleIrrigationRequest() {
    enableIrrigation_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ToggleIrrigationRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            enableIrrigation_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.internal_static_com_lekkss_irrigation_ToggleIrrigationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.internal_static_com_lekkss_irrigation_ToggleIrrigationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.class, com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.Builder.class);
  }

  public static final int ENABLE_IRRIGATION_FIELD_NUMBER = 1;
  private boolean enableIrrigation_;
  /**
   * <code>bool enable_irrigation = 1;</code>
   */
  public boolean getEnableIrrigation() {
    return enableIrrigation_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (enableIrrigation_ != false) {
      output.writeBool(1, enableIrrigation_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (enableIrrigation_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, enableIrrigation_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest)) {
      return super.equals(obj);
    }
    com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest other = (com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest) obj;

    boolean result = true;
    result = result && (getEnableIrrigation()
        == other.getEnableIrrigation());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ENABLE_IRRIGATION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getEnableIrrigation());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.lekkss.irrigation.ToggleIrrigationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lekkss.irrigation.ToggleIrrigationRequest)
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.internal_static_com_lekkss_irrigation_ToggleIrrigationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.internal_static_com_lekkss_irrigation_ToggleIrrigationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.class, com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.Builder.class);
    }

    // Construct using com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      enableIrrigation_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.internal_static_com_lekkss_irrigation_ToggleIrrigationRequest_descriptor;
    }

    @java.lang.Override
    public com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest getDefaultInstanceForType() {
      return com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest build() {
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest buildPartial() {
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest result = new com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest(this);
      result.enableIrrigation_ = enableIrrigation_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest) {
        return mergeFrom((com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest other) {
      if (other == com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.getDefaultInstance()) return this;
      if (other.getEnableIrrigation() != false) {
        setEnableIrrigation(other.getEnableIrrigation());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean enableIrrigation_ ;
    /**
     * <code>bool enable_irrigation = 1;</code>
     */
    public boolean getEnableIrrigation() {
      return enableIrrigation_;
    }
    /**
     * <code>bool enable_irrigation = 1;</code>
     */
    public Builder setEnableIrrigation(boolean value) {
      
      enableIrrigation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool enable_irrigation = 1;</code>
     */
    public Builder clearEnableIrrigation() {
      
      enableIrrigation_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.lekkss.irrigation.ToggleIrrigationRequest)
  }

  // @@protoc_insertion_point(class_scope:com.lekkss.irrigation.ToggleIrrigationRequest)
  private static final com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest();
  }

  public static com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ToggleIrrigationRequest>
      PARSER = new com.google.protobuf.AbstractParser<ToggleIrrigationRequest>() {
    @java.lang.Override
    public ToggleIrrigationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ToggleIrrigationRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ToggleIrrigationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ToggleIrrigationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

