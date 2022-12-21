package com.shopify.ledger.streams;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import java.io.File;

import com.shopify.ledger.data.LedgerData;
import com.shopify.ledger.data.LedgerEntry;
import com.shopify.ledger.data.MovementEntry;

import com.shopify.ledger.App;

public class AppTest {
  @Before
  public void deleteOutputFolders() {
    deleteDirectory(new File("./test_results"));
  }

  private void deleteDirectory(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
        for (File file : allContents) {
            deleteDirectory(file);
        }
    }
    directoryToBeDeleted.delete();
  }

  @Test
  public void executeStreams() throws Exception {
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    MovementEntry[] data = LedgerData.create();

    DataStream<MovementEntry> requestStream = LedgerDataStream.create(env, data);
    DataStream<LedgerEntry> splitStream = SplitLedgerEntriesStream.create(requestStream);

    splitStream.print();

    requestStream.writeAsText("./test_results/requestStream/");
    splitStream.writeAsText("./test_results/splitStream/");

    env.execute();
  }

  @Test
  public void executeApp() throws Exception {
    App.main(new String[0]);
  }
}
