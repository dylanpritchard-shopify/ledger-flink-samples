package com.shopify.deltas.data;

import org.junit.Test;
import static org.junit.Assert.*;
import com.shopify.deltas.data.UrlCrawler;

public class TestUrlCrawler {

  @Test
  public void testUrlCrawler() {
    UrlCrawler crawler = new UrlCrawler("Shopify/shopify").includeBlank();

    String[] expected = { "", "Shopify", "Shopify/shopify" };

    String[] myList = crawler.crawl();
    for (int i = 0; i < myList.length; i++) {
      assertEquals(expected[i], myList[i]);
    }
  }
}
