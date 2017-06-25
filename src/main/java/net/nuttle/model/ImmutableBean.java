package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImmutableBean {

  private String prop1;
  private String prop2;
  
  /*
   * This class is immutable, so @JsonCreator is used on a constructor instead.
   */
  
  @JsonCreator
  public ImmutableBean(@JsonProperty("id") String prop1, @JsonProperty("name") String prop2) {
    this.prop1 = prop1;
    this.prop2 = prop2;
  }
  
  /*
   * The following works, but seems like it shouldn't. I think I found a corner
   * case in Jackson.
   */
  @JsonCreator
  public ImmutableBean(String tmp) {
    this.prop1 = tmp;
    this.prop2 = "default";
  }
  
  public String getId() {
    return prop1;
  }
  
  public String getName() {
    return prop2;
  }
}
