package io.github.aaronchenwei.example.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aaronchenwei.example.PrimitiveDummyUtility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PrimitiveDummyTests {

  private static final int MAX_ARRAY_SIZE = 1 << 20;

  @Test
  @Order(1)
  public void testMax() {
    System.out.println("testMax");
    PrimitiveDummy dummy = PrimitiveDummyUtility.createMaxDummy();
    assertEquals(Integer.MAX_VALUE, dummy.getIntDummy());
  }

  @Test
  @Order(2)
  public void testMin() {
    System.out.println("testMin");
    PrimitiveDummy dummy = PrimitiveDummyUtility.createMinDummy();
    assertEquals(Integer.MIN_VALUE, dummy.getIntDummy());
  }

  @SneakyThrows
  @Test
  @Order(3)
  public void testSerializationMax() {
    System.out.println("testSerializationMax");
    PrimitiveDummy dummy = PrimitiveDummyUtility.createMaxDummy();
    var byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);
    try (var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
      objectOutputStream.writeObject(dummy);
    }
    System.out.println(byteArrayOutputStream.size());

    var byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    try (var objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
      var dummy2 = (PrimitiveDummy) objectInputStream.readObject();
      assertEquals(dummy, dummy2);
    }
  }

  @SneakyThrows
  @Test
  @Order(4)
  public void testSerializationMin() {
    System.out.println("testSerializationMin");
    PrimitiveDummy dummy = PrimitiveDummyUtility.createMinDummy();
    var byteArrayOutputStream = new ByteArrayOutputStream(MAX_ARRAY_SIZE);
    try (var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
      objectOutputStream.writeObject(dummy);
    }
    System.out.println(byteArrayOutputStream.size());

    var byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    try (var objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
      var dummy2 = (PrimitiveDummy) objectInputStream.readObject();
      assertEquals(dummy, dummy2);
    }
  }

}
