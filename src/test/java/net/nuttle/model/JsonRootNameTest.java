package net.nuttle.model;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonRootNameTest {

  @Test
  public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    String file = System.getProperty("user.dir") + "/src/test/resources/wrapper.json";
    WrapperBean bean = mapper.readValue(new File(file), WrapperBean.class);
    Assert.assertEquals(1, bean.getId());
    Assert.assertEquals("name", bean.getName());

    bean = new WrapperBean(2, "test");
    mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"user\":{\"id\":2,\"name\":\"test\"}}", result);
  }
}
