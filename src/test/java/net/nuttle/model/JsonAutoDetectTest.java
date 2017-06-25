package net.nuttle.model;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.nuttle.model.JsonAutoDetectBean;

public class JsonAutoDetectTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonAutoDetectBean bean = new JsonAutoDetectBean();
    String result = mapper.writeValueAsString(bean);
    bean = mapper.readValue(result, JsonAutoDetectBean.class);
    Assert.assertEquals("private", bean.getSomeProp());
  }
}
