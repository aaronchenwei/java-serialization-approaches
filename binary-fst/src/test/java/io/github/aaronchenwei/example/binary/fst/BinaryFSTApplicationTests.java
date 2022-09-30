package io.github.aaronchenwei.example.binary.fst;

import io.github.aaronchenwei.example.PrimitiveDummyUtility;
import io.github.aaronchenwei.example.entity.PrimitiveDummy;
import java.io.ByteArrayOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectOutput;

@Slf4j
public class BinaryFSTApplicationTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  private static final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);

  private static final FSTConfiguration fstConfiguration = FSTConfiguration.createDefaultConfiguration();


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
    FSTObjectOutput out = fstConfiguration.getObjectOutput(byteArrayOutputStream);
    out.writeObject(dummy);
    out.flush();
    out.close();

    log.atInfo().log("Serialized Object size = {}", byteArrayOutputStream.size());
  }
}
