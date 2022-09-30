package io.github.aaronchenwei.example.binary.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import io.github.aaronchenwei.example.PrimitiveDummyUtility;
import io.github.aaronchenwei.example.entity.PrimitiveDummy;
import java.io.ByteArrayOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class BinaryKryoApplicationTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  private static final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);

  private static final Kryo kryo = new Kryo();

  @BeforeAll
  public static void beforeAll() {
    kryo.setRegistrationRequired(false);
  }

  @BeforeEach
  public void beforeEach() {
    byteArrayOutputStream.reset();
  }

  @Test
  public void testMax() {
    PrimitiveDummy maxDummy = PrimitiveDummyUtility.createMaxDummy();
    execute(maxDummy);
  }

  @Test
  public void testMin() {
    PrimitiveDummy minDummy = PrimitiveDummyUtility.createMinDummy();
    execute(minDummy);
  }

  @SneakyThrows
  private void execute(PrimitiveDummy dummy) {
    try (var output = new Output(byteArrayOutputStream)) {
      kryo.writeObject(output, dummy);
    }

    log.atInfo().log("Serialized Object size = {}", byteArrayOutputStream.size());
  }

}
