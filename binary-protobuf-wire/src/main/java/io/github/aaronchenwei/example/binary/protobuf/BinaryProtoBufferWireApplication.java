package io.github.aaronchenwei.example.binary.protobuf;

import io.github.aaronchenwei.example.binary.proto.SimpleMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class BinaryProtoBufferWireApplication {

  private static final String FILE_PATH = "java-protobuf-wire-simple.bin";

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryProtoBufferWireApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    SimpleMessage message = new SimpleMessage.Builder()
      .id(42)  // set the id field
      .is_simple(true)  // set the is_simple field
      .name("My Simple Message Name") // set the name field
      .sample_list(Arrays.asList(1, 2, 3, 4, 5, 6)) // repeated field
      .build();

    log.atInfo().log("{}", message);


    /*
     * Write out Java Object to file
     */
    try (var fileOutputStream = new FileOutputStream(FILE_PATH)) {
      fileOutputStream.write(SimpleMessage.ADAPTER.encode(message));
    }

    /*
     * Serialized Java Object size
     */
    File file = new File(FILE_PATH);
    log.atInfo().log("File size = {}", file.length());

    boolean ret = file.delete();
    if (ret) {
      log.atInfo().log("Serialized file has been deleted.");
    }
  }

}
