package com.shopify.deltas.streams;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

import com.shopify.deltas.data.BalanceRecalculationRequest;

public class BalanceDataStream {
  public static DataStream<BalanceRecalculationRequest> create(
    StreamExecutionEnvironment env,
    BalanceRecalculationRequest[] requestObjects
  ) {
    DataStream<BalanceRecalculationRequest> source = env.fromElements(requestObjects).name("BalanceDataSource");
    return source;
  }
}
