package com.shopify.ledger.streams;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.shopify.ledger.data.LedgerData;
import com.shopify.ledger.data.LedgerEntry;
import com.shopify.ledger.data.MovementEntry;

public class AppTest {
  @Test
  public void shouldAnswerWithTrue() throws Exception {
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    MovementEntry[] data = LedgerData.create();

    DataStream<MovementEntry> requestStream = LedgerDataStream.create(env, data);
    DataStream<LedgerEntry> splitStream = SplitLedgerEntriesStream.create(requestStream);

    splitStream.print();

    requestStream.writeAsText("./test_results/requestStream/");
    splitStream.writeAsText("./test_results/splitStream/");

    env.execute();
  }
}
