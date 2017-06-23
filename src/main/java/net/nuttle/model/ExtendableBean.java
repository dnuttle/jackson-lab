package net.nuttle.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean {

  private Map<String, String> properties;
  
  public ExtendableBean() {
    properties = new HashMap<>();
  }
  
  /**
   * JsonAnyGetter and JsonAnySetter allow for a "dynamic" bean class
   * in which an internal map stores a dynamic set of properties.
   * There can be only one JsonAnyGetter and JsonAnySetter per class.
   * @return
   */
  @JsonAnyGetter
  public Map<String, String> getProperties() {
    return properties;
  }
  
  @JsonAnySetter
  public void put(String name, String value) {
    properties.put(name, value);
  }
}
