package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class PropertyOrderTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    PropertyOrderBean bean = new PropertyOrderBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"id\":null,\"name\":null,\"source\":null}", result);
  }
}
