package net.nuttle.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class DeserializerBean {

  public long id;
  public String name;
  
  @JsonDeserialize(using = BooleanDeserializer.class)
  public boolean enabled;
  
  public static class BooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext ctx)
    throws IOException, JsonProcessingException {
      String text = jsonParser.getText();
      if ("1".equals(text)) return true;
      return false;
    }
    
  }
}
