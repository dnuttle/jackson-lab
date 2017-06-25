package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonValue;

public class JsonValueBean {

  public String property = "default";
  
  @JsonValue
  @Override
  public String toString() {
    return "prop:" + property;
  }
}
