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
    Assert.assertEquals("{\"privateProp\":\"private\",\"privateProp2\":\"private\"}", result);
    bean = mapper.readValue(result, JsonAutoDetectBean.class);
    Assert.assertEquals("private", bean.getSomeProp());
  }
}
