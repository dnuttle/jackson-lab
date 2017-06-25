package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonValueBean bean = new JsonValueBean();
    String result = mapper.writeValueAsString(bean);
    System.out.println(result);
    Assert.assertEquals("\"prop:default\"", result);
  }
}
