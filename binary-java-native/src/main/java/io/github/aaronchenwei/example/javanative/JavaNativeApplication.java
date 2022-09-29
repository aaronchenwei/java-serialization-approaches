package io.github.aaronchenwei.example.javanative;

import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class JavaNativeApplication {

  private static final String FILE_PATH = "java-native-user.bin";

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new JavaNativeApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    User user = UserUtility.createUser();

    /*
     * Write out Java Object to file
     */
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
      objectOutputStream.writeObject(user);
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
