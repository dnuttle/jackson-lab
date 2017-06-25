package net.nuttle.model.include;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NonDefaultBean {

  private String property = "default";
  
  public String getProperty() {
    return property;
  }
  
  public void setProperty(String property) {
    this.property = property;
  }
}
