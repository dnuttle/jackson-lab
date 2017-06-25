package net.nuttle.model;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.nuttle.model.JsonPropertyBean;

public class JsonPropertyTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonPropertyBean bean = new JsonPropertyBean();
    bean.setSomeProp("someProp");
    bean.setSpecificVariable("specificVariable");
    bean.prop3 = "alternate";
    String result = mapper.writeValueAsString(bean);
    JsonNode node = mapper.readTree(result);
    Assert.assertEquals(3, node.size());
    bean = mapper.readValue(result, JsonPropertyBean.class);
    Assert.assertEquals("alternate", bean.prop3);
    Assert.assertEquals("specificVariable", bean.getSpecificVariable());
    Assert.assertEquals("someProp", bean.getSomeProp());
  }
}
