package io.github.aaronchenwei.example.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aaronchenwei
 */
@Data
@NoArgsConstructor
public class UserV1 implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private long id;
  private String nick;
  private String email;
  private String phone;
  private double balance;
  private Date bornAt;
  private long flag;
  private boolean vip;

}
