package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//This makes all members, including private ones with no getters/setters,
//visible to Jackson
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//Following is needed so that someProp is not seen as a JSON property in source JSON
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"privateProp", "privateProp2"})
public class JsonAutoDetectBean {

  private String privateProp = "private";
  private String privateProp2 = "private";
  
  @JsonIgnore
  public String getSomeProp() {
    return privateProp;
  }
}
