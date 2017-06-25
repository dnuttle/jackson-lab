package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//This makes all members, including private ones with no getters/setters,
//visible to Jackson
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//Following is needed so that someProp is not seen as a JSON property
//Either that or add @JsonIgnore on getSomeProp
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonAutoDetectBean {

  private String privateProp = "private";
  
  //@JsonIgnore
  public String getSomeProp() {
    return privateProp;
  }
}
