package io.github.aaronchenwei.example;

import io.github.aaronchenwei.example.entity.PrimitiveDummy;
import lombok.experimental.UtilityClass;

/**
 * @author Aaron
 */
@UtilityClass
public class PrimitiveDummyUtility {

  public static PrimitiveDummy createMaxDummy() {
    PrimitiveDummy dummy = new PrimitiveDummy();
    dummy.setByteDummy(Byte.MAX_VALUE);
    dummy.setShortDummy(Short.MAX_VALUE);
    dummy.setIntDummy(Integer.MAX_VALUE);
    dummy.setLongDummy(Long.MAX_VALUE);
    dummy.setFloatDummy(Float.MAX_VALUE);
    dummy.setDoubleDummy(Double.MAX_VALUE);
    dummy.setBooleanDummy(Boolean.TRUE);
    dummy.setCharDummy(Character.MAX_VALUE);
    return dummy;
  }

  public static PrimitiveDummy createMinDummy() {
    PrimitiveDummy dummy = new PrimitiveDummy();
    dummy.setByteDummy(Byte.MIN_VALUE);
    dummy.setShortDummy(Short.MIN_VALUE);
    dummy.setIntDummy(Integer.MIN_VALUE);
    dummy.setLongDummy(Long.MIN_VALUE);
    dummy.setFloatDummy(Float.MIN_VALUE);
    dummy.setDoubleDummy(Double.MIN_VALUE);
    dummy.setBooleanDummy(Boolean.FALSE);
    dummy.setCharDummy(Character.MIN_VALUE);
    return dummy;
  }

}
