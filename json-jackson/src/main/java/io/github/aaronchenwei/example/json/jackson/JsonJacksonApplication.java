package io.github.aaronchenwei.example.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.UserV1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aaronchenwei
 */
@Slf4j
public class JsonJacksonApplication {

  private static final String FILE_PATH = "jackson-user.json";

  private final ObjectMapper mapper = JsonMapper
    .builder()
    .addModule(new JavaTimeModule())
    .build();

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new JsonJacksonApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    UserV1 user = UserUtility.createUserV1();

    /*
     * Write out Java Object to file
     */
    try (var printWriter = new PrintWriter(new FileOutputStream(FILE_PATH))) {
      printWriter.print(mapper.writeValueAsString(user));
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
