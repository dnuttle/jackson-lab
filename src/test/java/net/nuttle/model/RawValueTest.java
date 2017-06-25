package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RawValueTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    RawValueBean bean = new RawValueBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"property\":1}", result);
  }
}
