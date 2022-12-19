package com.shopify.deltas.streams;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.shopify.deltas.data.BalanceData;
import com.shopify.deltas.data.BalanceRecalculationRequest;
import com.shopify.deltas.data.BalanceRecalculationResponse;

public class AppTest {
  @Test
  public void shouldAnswerWithTrue() throws Exception {
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    BalanceRecalculationRequest[] data = BalanceData.create();

    DataStream<BalanceRecalculationRequest> requestStream = BalanceDataStream.create(env, data);
    DataStream<BalanceRecalculationResponse> splitStream = SplitLineItemsStream.create(requestStream);

    requestStream.writeAsText("./test_results/requestStream/");
    splitStream.writeAsText("./test_results/splitStream/");

    env.execute();
  }
}
