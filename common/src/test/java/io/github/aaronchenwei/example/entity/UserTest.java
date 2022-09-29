package io.github.aaronchenwei.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {

  private static final String filePath = "user.bin";

  private static void deleteTestFile() {
    File file = new File(filePath);
    if (file.exists() && !file.isDirectory()) {
      boolean ret = file.delete();
      if (ret) {
        System.out.println("File " + filePath + " has been deleted.");
      }
    } else {
      System.out.println("File " + filePath + " has not been found.");
    }
  }

  @BeforeAll
  public static void beforeAll() {
    System.out.println("BeforeAll");
    deleteTestFile();
  }

  @AfterAll
  public static void afterAll() {
    System.out.println("AfterAll");
    deleteTestFile();
  }

  @Test
  public void test() {
    User user = new User();
    user.setId(1L);
    user.setNick("test");

    assertEquals(1L, user.getId());
    assertEquals("test", user.getNick());
    assertNull(user.getBornAt());
  }

  @Test
  public void testSerialization() throws IOException, ClassNotFoundException {
    User user = new User();
    user.setId(1L);
    user.setNick("johnsmith");
    user.setEmail("johnsmith@test.org");
    user.setPhone("13888886666");
    user.setBalance(10000.0);
    user.setBornAt(new Date());
    user.setFlag(0L);
    user.setVip(false);
    user.setTimestamp(LocalDateTime.now());

    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(user);
    objectOutputStream.close();
    fileOutputStream.close();

    FileInputStream fileInputStream = new FileInputStream(filePath);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    User deserializedUser = (User) objectInputStream.readObject();
    objectInputStream.close();
    fileInputStream.close();

    assertNotSame(user, deserializedUser);
    assertEquals(user.getId(), deserializedUser.getId());
    assertEquals(user.getNick(), deserializedUser.getNick());
    assertEquals(user, deserializedUser);
  }

}
