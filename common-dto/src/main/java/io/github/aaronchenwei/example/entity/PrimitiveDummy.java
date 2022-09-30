package io.github.aaronchenwei.example.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aaron
 */
@Data
@NoArgsConstructor
public class PrimitiveDummy implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 1 byte
   */
  private byte byteDummy;

  /**
   * 2 bytes
   */
  private short shortDummy;

  /**
   * 4 bytes
   */
  private int intDummy;

  /**
   * 8 bytes
   */
  private long longDummy;

  /**
   * 4 bytes
   */
  private float floatDummy;

  /**
   * 8 bytes
   */
  private double doubleDummy;

  /**
   * 1 bit
   */
  private boolean booleanDummy;

  /**
   * 2 bytes
   */
  private char charDummy;

}
