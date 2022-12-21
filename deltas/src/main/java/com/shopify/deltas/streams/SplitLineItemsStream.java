package com.shopify.deltas.streams;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

import com.shopify.deltas.data.BalanceRecalculationRequest;
import com.shopify.deltas.data.BalanceRecalculationResponse;

import com.shopify.deltas.transformations.SplitBalances;

public class SplitLineItemsStream {
  public static DataStream<BalanceRecalculationResponse> create(
    DataStream<BalanceRecalculationRequest> dataStream
  ) {
    DataStream<BalanceRecalculationResponse> outStream = dataStream
      .flatMap(new SplitBalances())
      .name("DeltaEntryStream");

    return outStream;
  }
}
