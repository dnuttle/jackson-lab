package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializeTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    String json = "{\"id\":1, \"name\":\"name\", \"enabled\":1}";
    DeserializerBean bean = mapper.readValue(json, DeserializerBean.class);
    Assert.assertEquals(1, bean.id);
    Assert.assertEquals("name", bean.name);
    Assert.assertTrue(bean.enabled);
  }
}
