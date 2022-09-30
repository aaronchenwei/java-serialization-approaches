package io.github.aaronchenwei.example.binary.hessianlite;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import io.github.aaronchenwei.example.PrimitiveDummyUtility;
import io.github.aaronchenwei.example.entity.PrimitiveDummy;
import java.io.ByteArrayOutputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class BinaryHessianLiteApplicationTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  private static final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);

  @BeforeAll
  public static void beforeAll() {

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
    Hessian2Output hessian2Output = new Hessian2Output(byteArrayOutputStream);
    hessian2Output.startMessage();
    hessian2Output.writeObject(dummy);
    hessian2Output.completeMessage();
    hessian2Output.close();

    log.atInfo().log("Serialized Object size = {}", byteArrayOutputStream.size());
  }

}
