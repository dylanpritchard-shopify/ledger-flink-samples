package com.shopify.deltas.transformations;

//import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;

import org.apache.flink.util.Collector;

import com.shopify.deltas.data.BalanceRecalculationRequest;
import com.shopify.deltas.data.BalanceRecalculationResponse;
import com.shopify.deltas.data.UrlCrawler;

public class SplitBalances extends RichFlatMapFunction<BalanceRecalculationRequest, BalanceRecalculationResponse> {

  @Override
  public void flatMap(
    BalanceRecalculationRequest input,
    Collector<BalanceRecalculationResponse> collector
  ) throws Exception {
    UrlCrawler skuCrawler = new UrlCrawler(input.Sku);
    UrlCrawler networkCrawler = new UrlCrawler(input.Network).includeBlank();
    UrlCrawler locationCrawler = new UrlCrawler(input.Location).includeBlank();
    UrlCrawler stateCrawler = new UrlCrawler(input.State);

    for (String sku_item : skuCrawler.crawl()) {
      for (String network_item : networkCrawler.crawl()) {
        for (String location_item : locationCrawler.crawl()) {
          // we want to be able to have state rollups into sku, which means both network and location
          // need to be blank for that to work
          if (network_item == UrlCrawler.BLANK && location_item != UrlCrawler.BLANK)
            continue;

          for (String state_item : stateCrawler.crawl()) {
            BalanceRecalculationResponse response = new BalanceRecalculationResponse(
              input.Quantity, sku_item, network_item, location_item, state_item
            );
            collector.collect(response);
          }
        }
      }
    }
  }
}
