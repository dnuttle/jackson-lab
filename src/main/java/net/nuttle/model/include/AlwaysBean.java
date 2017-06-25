package net.nuttle.model.include;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * ALWAYS means even private members are seen as JSON attributes
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class AlwaysBean {

  private String property = "default";
  
  public void setProperty(String value) {
    this.property = value;
  }
  
  public String getProperty() {
    return property;
  }
}
