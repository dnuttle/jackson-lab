package net.nuttle.model.include;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NonEmptyBean {

  private String property;
  
  public void setProperty(String value) {
    this.property = value;
  }
  
  public String getProperty() {
    return property;
  }
}
