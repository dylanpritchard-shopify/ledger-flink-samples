package com.shopify.deltas.data;

import java.util.ArrayList;

public class UrlCrawler {
  private String _url;
  private Boolean _blank = false;

  public static String BLANK = "";

  public UrlCrawler(String url) {
    _url = url;
  }

  public UrlCrawler includeBlank() {
    _blank = true;
    return this;
  }

  public String[] crawl() {
    String[] arrOfStr = _url.split("/", 0);

    ArrayList<String> items = new ArrayList<String>();

    if (_blank)
      items.add(BLANK);

    String current = "";
    for (String var : arrOfStr) {
      if (current == "") {
        current += var;
      } else {
        current += "/" + var;
      }

      items.add(current);
    }

    String[] y = new String[items.size()];
    return items.toArray(y);
  }
}
