// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WeatherSensorService.proto

package com.lekkss.weathersensor.weathersensorservice;

public interface WeatherDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lekkss.weathersensor.WeatherData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>double temperature = 1;</code>
   */
  double getTemperature();

  /**
   * <code>double humidity = 2;</code>
   */
  double getHumidity();

  /**
   * <code>double wind_speed = 3;</code>
   */
  double getWindSpeed();

  /**
   * <code>double precipitation = 4;</code>
   */
  double getPrecipitation();
}
