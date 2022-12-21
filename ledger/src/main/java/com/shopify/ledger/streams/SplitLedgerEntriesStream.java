package com.shopify.ledger.streams;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

import com.shopify.ledger.data.LedgerEntry;
import com.shopify.ledger.data.MovementEntry;

import com.shopify.ledger.transformations.SplitEntries;

public class SplitLedgerEntriesStream {
  public static DataStream<LedgerEntry> create(
    DataStream<MovementEntry> dataStream
  ) {
    DataStream<LedgerEntry> outStream = dataStream
      .flatMap(new SplitEntries())
      .name("LedgerEntryStream");

    return outStream;
  }
}
