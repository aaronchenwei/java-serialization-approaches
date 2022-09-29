package io.github.aaronchenwei.example;

import io.github.aaronchenwei.example.entity.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.experimental.UtilityClass;

/**
 * @author aaronchenwei
 */
@UtilityClass
public class UserUtility {

  public static User createUser() {
    User user = new User();
    user.setId(1L);
    user.setNick("johnsmith");
    user.setEmail("johnsmith@test.org");
    user.setPhone("13888886666");
    user.setBalance(10000.0);
    LocalDate localDate = LocalDate.of(2000, 1, 1);
    user.setBornAt(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    user.setFlag(0L);
    user.setVip(false);
    user.setTimestamp(LocalDateTime.of(2022, 10, 1, 0, 0));
    return user;
  }

  public static List<User> createUsers(int number) {
    var users = new ArrayList<User>(number);
    for (int i = 1; i <= number; i++) {
      User user = new User();
      user.setId(i);
      user.setNick("johnsmith" + i);
      user.setEmail("johnsmith" + i + "@test.org");
      user.setPhone(Long.toString(13888880000L + i));
      user.setBalance(10000.0 + i);
      LocalDate localDate = LocalDate.of(2000, 1, 1);
      user.setBornAt(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
      user.setFlag(0L);
      user.setVip(false);
      user.setTimestamp(LocalDateTime.of(2022, 10, 1, 0, 0));
      users.add(user);
    }
    return users;
  }

}
