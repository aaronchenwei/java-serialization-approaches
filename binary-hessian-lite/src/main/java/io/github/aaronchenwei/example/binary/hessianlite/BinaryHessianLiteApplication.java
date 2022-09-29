package io.github.aaronchenwei.example.binary.hessianlite;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
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
public class BinaryHessianLiteApplication {

  private static final String FILE_PATH = "hessian-user.bin";

  public static void main(String[] args) {
    log.atInfo().log("Start to run...");
    new BinaryHessianLiteApplication().execute();
  }

  @SneakyThrows
  private void execute() {
    User user = UserUtility.createUser();

    /*
      Hessian doesn't support JSR-310 Date Types (such as LocalDateTime or etc.)
     */
    user.setTimestamp(null);

    /*
      Write out Java Object to file
     */
    try (var fileOutputStream = new FileOutputStream(FILE_PATH)) {
      Hessian2Output hessian2Output = new Hessian2Output(fileOutputStream);
      hessian2Output.startMessage();
      hessian2Output.writeObject(user);
      hessian2Output.completeMessage();
      hessian2Output.close();
    }

    /*
      Serialized Java Object size
     */
    File file = new File(FILE_PATH);
    log.atInfo().log("File size = {}", file.length());

    boolean ret = file.delete();
    if (ret) {
      log.atInfo().log("Serialized file has been deleted.");
    }
  }

}
