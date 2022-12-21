# ledger-flink-samples

Two separate flink jobs:

## > deltas

Create delta adjustments for quick application of balance updates across multiple dimensions of a ledger entry.

Dimensions can be URL formatted, providing sub-dimensions.

"Sku": can be multi-dimensioned into "Sku/Lot" ("sku": "123456/Lot17")
"Network": can be multidimensioned into "Network/Pool" ("network": "Shopify/ecomm")
"Location": can be multidimensioned into "Location/sublocation/..." ("location": "Warehouse0/chuck7/tote4")
"State": can be multidimensioned into "State/substate" ("state": "damaged/available")

We will then traverse each dimension and sub-dimension and build all relevant combinations and permutations of
balance adjustments and then send the balance adjustments into the balance views for application.

## > ledger

Take values matching the Inventory Inbound Protocol and break them into debit and credit entries and then send
the balance values to the ledger
