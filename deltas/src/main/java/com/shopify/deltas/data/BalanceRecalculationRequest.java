package com.shopify.deltas.data;

import com.google.gson.Gson;

public class BalanceRecalculationRequest {
  public int Quantity;
  public String Sku;
  public String Network;
  public String Location;
  public String State;

  public BalanceRecalculationRequest(
    int quantity,
    String sku,
    String network,
    String location,
    String state
  ) {
    Quantity = quantity;
    Sku = sku;
    Network = network;
    Location = location;
    State = state;
  }

  @Override
  public String toString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
