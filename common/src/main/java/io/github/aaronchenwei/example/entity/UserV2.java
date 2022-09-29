package io.github.aaronchenwei.example.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aaronchenwei
 */
@Data
@NoArgsConstructor
public class UserV2 implements Serializable {

  @Serial
  private static final long serialVersionUID = 2L;

  private long id;
  private String nick;
  private String email;
  private String phone;
  private double balance;
  private Date bornAt;
  private long flag;
  private boolean vip;

  /**
   * JSR-310 Date Types
   */
  private LocalDateTime timestamp;

}
