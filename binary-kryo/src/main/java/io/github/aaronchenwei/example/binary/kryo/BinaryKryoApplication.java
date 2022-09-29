package io.github.aaronchenwei.example.binary.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.User;
import java.io.File;
import java.io.FileOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class BinaryKryoApplication {

  private static final String FILE_PATH = "kryo-user.bin";

  private final Kryo kryo;

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryKryoApplication().execute();
  }

  private BinaryKryoApplication() {
    kryo = new Kryo();
    kryo.setRegistrationRequired(false);
  }

  @SneakyThrows
  private void execute() {
    User user = UserUtility.createUser();

    /*
     * Write out Java Object to file
     */
    try (var output = new Output(new FileOutputStream(FILE_PATH))) {
      kryo.writeObject(output, user);
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
