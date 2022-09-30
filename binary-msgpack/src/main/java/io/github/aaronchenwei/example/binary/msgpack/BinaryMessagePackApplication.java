package io.github.aaronchenwei.example.binary.msgpack;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.UserV1;
import java.io.File;
import java.io.FileOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.jackson.dataformat.MessagePackMapper;

/**
 * @author aaronchenwei
 */
@Slf4j
public class BinaryMessagePackApplication {

  private static final String FILE_PATH = "msgpack-user.bin";

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryMessagePackApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    ObjectMapper messagePackMapper = new MessagePackMapper();

    UserV1 user = UserUtility.createUserV1();

    /*
     * Write out Java Object to file
     */
    try (var fileOutputStream = new FileOutputStream(FILE_PATH)) {
      fileOutputStream.write(messagePackMapper.writeValueAsBytes(user));
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
