package io.github.aaronchenwei.example.json.gson;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class JsonGsonApplication {

  private static final String FILE_PATH = "gson-user.json";

  private final Gson gson = Converters.registerAll(new GsonBuilder()).create();

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new JsonGsonApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    User user = UserUtility.createUser();

    /*
     * Write out Java Object to file
     */
    try (var printWriter = new PrintWriter(new FileOutputStream(FILE_PATH))) {
      printWriter.print(gson.toJson(user));
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
