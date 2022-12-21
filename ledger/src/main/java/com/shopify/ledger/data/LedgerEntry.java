package com.shopify.ledger.data;

import com.google.gson.Gson;

public class LedgerEntry {
  public String MerchantId;
  public String Sku;
  public int Quantity;
  public String Network;
  public String Location;
  public String State;
  public String Reference;

  public LedgerEntry (
    String merchantId,
    String sku,
    int quantity,
    String network,
    String location,
    String state,
    String reference
  ) {
    MerchantId = merchantId;
    Sku = sku;
    Quantity = quantity;
    Network = network;
    Location = location;
    State = state;
    Reference = reference;
  }

  @Override
  public String toString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
