package io.github.aaronchenwei.example.binary.protobuf;

import io.github.aaronchenwei.example.binary.proto.Simple.SimpleMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class BinaryProtoBufferApplication {

  private static final String FILE_PATH = "java-protobuf-simple.bin";

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryProtoBufferApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    SimpleMessage.Builder builder = SimpleMessage.newBuilder();

    // simple fields
    builder.setId(42)  // set the id field
      .setIsSimple(true)  // set the is_simple field
      .setName("My Simple Message Name"); // set the name field

    // repeated field
    builder.addSampleList(1)
      .addSampleList(2)
      .addSampleList(3)
      .addAllSampleList(Arrays.asList(4, 5, 6));

    log.atInfo().log("{}", builder.toString());

    SimpleMessage message = builder.build();

    /*
     * Write out Java Object to file
     */
    try (var fileOutputStream = new FileOutputStream(FILE_PATH)) {
      message.writeTo(fileOutputStream);
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
