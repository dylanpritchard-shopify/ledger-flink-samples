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

## Running tests

* The tests will build a folder called /test_results/ and put the results of the streams in there

* Go to either the ledger or deltas subfolders (where pom.xml files exist)
* $ mvn test

## Running Flink locally

* Build the .jar file
* Go to either the ledger or deltas subfolders (where pom.xml files exist)
* $ mvn package

* Download and install Flink (mine is in /Library/Flink/)

* Open a terminal window
* $ cd Library/Flink/deps/bin

* Start the service locally
* $ ./start-cluster.sh
* Validate it's working:
* Localhost:8081
* $ ps -ef | grep flink

* Stop the service
* $ ./stop-cluster.sh

* get the path to your .jar file (usually under /target/ beneath the pom.xml file)
* $ ./flink run --detached /{path_to_jar}/{your_jar_file_name}.jar

eg:
$ ./flink run --detached /Users/dylanpritchard/src/github.com/dylan/ledger-flink-samples/deltas/target/deltas-1.0-SNAPSHOT.jar
