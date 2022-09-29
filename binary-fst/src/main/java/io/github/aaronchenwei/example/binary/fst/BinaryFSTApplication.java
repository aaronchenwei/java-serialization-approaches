package io.github.aaronchenwei.example.binary.fst;

import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.User;
import java.io.File;
import java.io.FileOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectOutput;

/**
 * @author aaronchenwei
 */
@Slf4j
public class BinaryFSTApplication {

  private static final String FILE_PATH = "fst-user.bin";

  private static FSTConfiguration fstConfiguration = FSTConfiguration.createDefaultConfiguration();

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryFSTApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    User user = UserUtility.createUser();

    /*
     * Write out Java Object to file
     */
    try (var fileOutputStream = new FileOutputStream(FILE_PATH)) {
      FSTObjectOutput out = fstConfiguration.getObjectOutput(fileOutputStream);
      out.writeObject(user);
      out.flush();
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
