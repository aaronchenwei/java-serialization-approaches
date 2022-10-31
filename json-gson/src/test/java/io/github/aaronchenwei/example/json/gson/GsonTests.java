package io.github.aaronchenwei.example.json.gson;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;
import java.util.HashMap;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class GsonTests {

  @Data
  static class VersionedClass {

    @Since(1.1)
    private final String newerField;

    @Since(1.0)
    private final String newField;

    private final String field;

  }

  @Data
  static class CustomPOJOComposition {

    private HashMap<String, String> map = new HashMap<>();

    private String field;

  }

  @EqualsAndHashCode(callSuper = true)
  @Data
  static class CustomPOJOInheritance extends HashMap<String, String> {

    private String field;

  }

  @Test
  public void test() {
    VersionedClass versionedObject = new VersionedClass("newer", "new", "old");
    // version 1.0
    Gson gson = new GsonBuilder().setVersion(1.0).create();
    String jsonOutput = gson.toJson(versionedObject);
    log.atInfo().log(jsonOutput);

    // version latest
    gson = new Gson();
    jsonOutput = gson.toJson(versionedObject);
    log.atInfo().log(jsonOutput);
  }

  @Test
  public void test2() {
    String json = "{\"newerField\":\"newer\",\"newField\":\"new\",\"field\":\"old\"}";

    Gson gson1 = new GsonBuilder().setVersion(1.0).create();
    VersionedClass object1 = gson1.fromJson(json, VersionedClass.class);
    assertNull(object1.newerField);
    log.atInfo().log("{}", object1);

    Gson gson2 = new Gson();
    VersionedClass object2 = gson2.fromJson(json, VersionedClass.class);
    assertNotNull(object2.newerField);
    log.atInfo().log("{}", object2);
  }

  @Test
  public void test3() {
    var pojo = new CustomPOJOComposition();
    pojo.setField("field");
    pojo.getMap().put("aKey", "aValue");

    log.atInfo().log("{}", pojo.getField());
    var gson = new GsonBuilder().setPrettyPrinting().create();
    var jsonOutput = gson.toJson(pojo, CustomPOJOComposition.class);
    log.atInfo().log(jsonOutput);
  }

  @Test
  public void test4() {
    var pojo = new CustomPOJOInheritance();
    pojo.setField("field");
    pojo.put("aKey", "aValue");

    log.atInfo().log("{}", pojo.getField());
    // TODO - extra fields are ignored by default, need a customized type adaptor
    var gson = new GsonBuilder().setPrettyPrinting().create();
    var jsonOutput = gson.toJson(pojo, CustomPOJOInheritance.class);
    log.atInfo().log(jsonOutput);
  }
}
