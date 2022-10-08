package io.github.aaronchenwei.example.json.gson;

import com.google.gson.Gson;
import io.github.aaronchenwei.example.PrimitiveDummyUtility;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class PrimitiveDummyGsonTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  private static final Gson gson = new Gson();

  private static final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);

  @BeforeEach
  public void beforeEach() {
    byteArrayOutputStream.reset();
  }

  @Test
  public void testDummy1() {
    var dummy = PrimitiveDummyUtility.createMaxDummy();
    try (var printWriter = new PrintWriter(byteArrayOutputStream)) {
      printWriter.print(gson.toJson(dummy));
    }
    log.atInfo().log("json size = {}", byteArrayOutputStream.size());
    log.atInfo().log(byteArrayOutputStream.toString());
  }

  @Test
  public void testDummy2() {
    var dummy = PrimitiveDummyUtility.createMinDummy();
    try (var printWriter = new PrintWriter(byteArrayOutputStream)) {
      printWriter.print(gson.toJson(dummy));
    }
    log.atInfo().log("json size = {}", byteArrayOutputStream.size());
    log.atInfo().log(byteArrayOutputStream.toString());
  }

}
