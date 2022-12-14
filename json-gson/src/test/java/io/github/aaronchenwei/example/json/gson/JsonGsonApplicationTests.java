package io.github.aaronchenwei.example.json.gson;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.aaronchenwei.example.UserUtility;
import io.github.aaronchenwei.example.entity.UserV2;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class JsonGsonApplicationTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  private static final Gson gson = Converters.registerAll(new GsonBuilder()).create();

  private static final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);

  @BeforeEach
  public void beforeEach() {
    byteArrayOutputStream.reset();
  }

  @Test
  public void test() {
    UserV2 user = UserUtility.createUserV2();
    try (var printWriter = new PrintWriter(byteArrayOutputStream)) {
      printWriter.print(gson.toJson(user));
    }
    log.atInfo().log("json size = {}", byteArrayOutputStream.size());
    log.atInfo().log(byteArrayOutputStream.toString());
  }

}
