package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonSerializeTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    SerializerBean bean = new SerializerBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"id\":0,\"name\":null,\"enabled\":0}", result);
    
    bean.enabled = true;
    result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"id\":0,\"name\":null,\"enabled\":1}", result);
    
  }
}
