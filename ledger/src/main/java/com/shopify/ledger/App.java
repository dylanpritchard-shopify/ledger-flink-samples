package com.shopify.ledger;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import com.shopify.ledger.data.LedgerData;
import com.shopify.ledger.data.LedgerEntry;
import com.shopify.ledger.data.MovementEntry;

public class App {
  public static void main( String[] args ) {
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    MovementEntry[] data = LedgerData.create();

    DataStream<MovementEntry> requestStream = LedgerDataStream.create(env, data);
    DataStream<LedgerEntry> splitStream = SplitLedgerEntriesStream.create(requestStream);

    splitStream.print();

    env.execute();
  }
}
