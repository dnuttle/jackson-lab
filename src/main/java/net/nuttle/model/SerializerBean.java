package net.nuttle.model;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonPropertyOrder({"id","name","enabled"})
public class SerializerBean {

  public long id;
  public String name;
  
  @JsonSerialize(using = BooleanSerializer.class)
  public boolean enabled = false;
  
  public static class BooleanSerializer extends JsonSerializer<Boolean> {
    
    @Override
    public void serialize(Boolean val, JsonGenerator generator, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
      if (val) {
        generator.writeNumber(1);
      } else {
        generator.writeNumber(0);
      }
    }
  }
}
