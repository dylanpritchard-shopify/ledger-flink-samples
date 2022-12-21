package com.shopify.ledger.data;

import com.shopify.ledger.data.MovementItem;

import com.google.gson.Gson;

public class MovementEntry {
  public String MerchantId;
  public String Sku;
  public int Quantity;
  public MovementItem Source;
  public MovementItem Destination;

  @Override
  public String toString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
