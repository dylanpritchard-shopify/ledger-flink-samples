package com.shopify.deltas;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import com.shopify.deltas.data.BalanceData;
import com.shopify.deltas.data.BalanceRecalculationRequest;
import com.shopify.deltas.data.BalanceRecalculationResponse;

public class App {
  public static void main( String[] args ) {
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    BalanceRecalculationRequest[] data = BalanceData.create();

    DataStream<BalanceRecalculationRequest> requestStream = BalanceDataStream.create(env, data);
    DataStream<BalanceRecalculationResponse> splitStream = SplitLineItemsStream.create(requestStream);

    splitStream.print();

    env.execute();
  }
}
