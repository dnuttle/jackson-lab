package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonInjectTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    InjectBean bean = new InjectBean();
    bean.id = 1;
    bean.name = "name";
    String result = mapper.writeValueAsString(bean);
    
    InjectableValues inject = new InjectableValues.Std().addValue(String.class, "nuttle.net");
    InjectBean bean2 = new ObjectMapper()
      .reader(inject)
      .forType(InjectBean.class)
      .readValue(result);
    Assert.assertEquals(1, bean2.id);
    Assert.assertEquals("name", bean2.name);
    Assert.assertEquals("nuttle.net", bean2.source);
  }
}
