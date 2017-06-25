package net.nuttle.model.include;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeTest {

  @Test
  public void testNonEmpty() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    NonEmptyBean bean = new NonEmptyBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{}", result);

    bean.setProperty("");
    result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{}", result);
    
    bean.setProperty("abc");
    result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"property\":\"abc\"}", result);
  }
  
  @Test
  public void testNonDefault() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    NonDefaultBean bean = new NonDefaultBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("default", bean.getProperty());
    Assert.assertEquals("{}", result);
    
    bean.setProperty("custom");
    result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"property\":\"custom\"}", result);
  }
  
  @Test
  public void testAlways() throws Exception {
    /*
     * Not clear why JsonInclude.Include.ALWAYS is needed.
     * This is how properties are included if there is no
     * @JsonInclude annotation at all.
     * Maybe it's because you can also do this:
     * new ObjectMaper().setSerializationInclude(JsonInclude.Include.ALWAYS)
     * and your code requires that this always be set with some instance of the Include enum
     */
    ObjectMapper mapper = new ObjectMapper();
    AlwaysBean bean = new AlwaysBean();
    String result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"property\":\"default\"}", result);
    
    bean.setProperty("abc");
    result = mapper.writeValueAsString(bean);
    Assert.assertEquals("{\"property\":\"abc\"}", result);
  }
}
