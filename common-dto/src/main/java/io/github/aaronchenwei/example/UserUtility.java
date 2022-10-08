package io.github.aaronchenwei.example;

import io.github.aaronchenwei.example.entity.UserV1;
import io.github.aaronchenwei.example.entity.UserV2;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.experimental.UtilityClass;
import net.datafaker.Faker;

/**
 * @author aaronchenwei
 */
@UtilityClass
public class UserUtility {

  private static final Faker faker = new Faker();

  public static UserV1 createUserV1() {
    UserV1 user = new UserV1();
    user.setId(1L);
    user.setNick("johnsmith");
    user.setEmail("johnsmith@test.org");
    user.setPhone("13888886666");
    user.setBalance(10000.0);
    LocalDate localDate = LocalDate.of(2000, 1, 1);
    user.setBornAt(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    user.setFlag(0L);
    user.setVip(false);
    return user;
  }

  public static UserV2 createUserV2() {
    UserV2 user = new UserV2();
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

  public static List<UserV1> createUsersV1(int number) {
    var users = new ArrayList<UserV1>(number);
    for (int i = 1; i <= number; i++) {
      UserV1 user = new UserV1();
      user.setId(i);
      user.setNick("johnsmith" + i);
      user.setEmail("johnsmith" + i + "@test.org");
      user.setPhone(Long.toString(13888880000L + i));
      user.setBalance(10000.0 + i);
      LocalDate localDate = LocalDate.of(2000, 1, 1);
      user.setBornAt(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
      user.setFlag(0L);
      user.setVip(false);
      users.add(user);
    }
    return users;
  }

  public static List<UserV2> createUsersV2(int number) {
    var users = new ArrayList<UserV2>(number);
    for (int i = 1; i <= number; i++) {
      UserV2 user = new UserV2();
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

  public static UserV1 createFakerUserV1() {
    UserV1 user = new UserV1();
    user.setId(1L);
    user.setNick(faker.name().fullName());
    user.setEmail(faker.internet().emailAddress());
    user.setPhone(faker.phoneNumber().cellPhone());
    user.setBalance(10000.0);
    LocalDate localDate = LocalDate.of(2000, 1, 1);
    user.setBornAt(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    user.setFlag(0L);
    user.setVip(false);
    return user;
  }

}
