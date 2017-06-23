import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.nuttle.model.ExtendableBean;

public class JsonAnyGetterTest {

  
  @Test
  public void testJsonAnyGetter() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    ExtendableBean bean = new ExtendableBean();
    bean.put("prop1", "value1");
    bean.put("prop2", "value2");
    String result = mapper.writeValueAsString(bean);
    System.out.println(result);
    JsonNode n = mapper.readTree(result);
    Assert.assertEquals("value1", n.get("prop1").asText());
    Assert.assertEquals("value2", n.get("prop2").asText());
    Assert.assertEquals(2, n.size());
    bean = mapper.readValue(result, ExtendableBean.class);
    Assert.assertEquals("value1", bean.getProperties().get("prop1"));
    Assert.assertEquals("value2", bean.getProperties().get("prop2"));
  }
}
