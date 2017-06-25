package net.nuttle.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonCreatorTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    ImmutableBean bean = new ImmutableBean("id", "name");
    String result = mapper.writeValueAsString(bean);
    bean = mapper.readValue(result, ImmutableBean.class);
    Assert.assertEquals("id", bean.getId());
    Assert.assertEquals("name", bean.getName());
    
    bean = new ImmutableBean("abc");
    result = mapper.writeValueAsString(bean);
    bean = mapper.readValue(result, ImmutableBean.class);
    Assert.assertEquals("abc", bean.getId());
    Assert.assertEquals("default", bean.getName());
  }
}
