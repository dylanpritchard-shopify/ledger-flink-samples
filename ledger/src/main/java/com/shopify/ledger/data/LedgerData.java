package com.shopify.ledger.data;

import com.shopify.ledger.data.*;

public class LedgerData {
  public static MovementEntry[] create() {
    MovementEntry[] x = {
      buildEntry("123", "Sku7", 19,
        buildMovement("Shopify", "W0/staging", "toputaway", "912"),
        buildMovement("Shopify", "W0/bin19", "available", "912")),
      buildEntry("123", "Sku7", 22,
        buildMovement("Shopify", "W0", "staging", "123"),
        buildMovement("Shopify", "W0", "bin4", "123"))
    };

    return x;
  }

  private static MovementEntry buildEntry(String m, String s, int q, MovementItem src, MovementItem dst) {
    MovementEntry x = new MovementEntry();
    x.MerchantId = m;
    x.Sku = s;
    x.Quantity = q;
    x.Source = src;
    x.Destination = dst;

    return x;
  }

  private static MovementItem buildMovement(String n, String l, String s, String r) {
    MovementItem x = new MovementItem();
    x.Network = n;
    x.Location = l;
    x.State = s;
    x.Reference = r;

    return x;
  }
}
