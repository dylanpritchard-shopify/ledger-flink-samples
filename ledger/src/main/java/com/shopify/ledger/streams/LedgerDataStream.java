package com.shopify.ledger.streams;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

import com.shopify.ledger.data.MovementEntry;

public class LedgerDataStream {
  public static DataStream<MovementEntry> create(
    StreamExecutionEnvironment env,
    MovementEntry[] requestObjects
  ) {
    DataStream<MovementEntry> source = env.fromElements(requestObjects).name("LedgerDataSource");
    return source;
  }
}
