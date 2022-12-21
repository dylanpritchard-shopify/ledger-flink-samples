package com.shopify.deltas.data;

import com.shopify.deltas.data.BalanceRecalculationRequest;

public class BalanceData {
  public static BalanceRecalculationRequest[] create() {
    BalanceRecalculationRequest[] items = {
      new BalanceRecalculationRequest(15, "Milk/Lot19", "Shopify/ecomm", "Warehouse0/Bin9", "Available"),
      new BalanceRecalculationRequest(-9, "Milk/Lot14", "Shopify/ecomm", "Warehouse0/Bin11", "Damaged/Available")
    };

    return items;
  }
}
