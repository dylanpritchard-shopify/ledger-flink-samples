package com.shopify.ledger.transformations;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.util.Collector;

import com.shopify.ledger.data.LedgerEntry;
import com.shopify.ledger.data.MovementEntry;

public class SplitEntries extends RichFlatMapFunction<MovementEntry, LedgerEntry> {

  @Override
  public void flatMap(MovementEntry input, Collector<LedgerEntry> collector) throws Exception
  {
    LedgerEntry debit = new LedgerEntry(
      input.MerchantId,
      input.Sku,
      input.Quantity * (-1),
      input.Source.Network,
      input.Source.Location,
      input.Source.State,
      input.Source.Reference);

    LedgerEntry credit = new LedgerEntry(
      input.MerchantId,
      input.Sku,
      input.Quantity,
      input.Destination.Network,
      input.Destination.Location,
      input.Destination.State,
      input.Destination.Reference);

    collector.collect(debit);
    collector.collect(credit);
  }
}
