package net.nuttle.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class InjectBean {

  public long id = 0;
  public String name = null;
  
  /*
   * If BeanInject is used with ObjectMapper to create source JSON, then @JsonIgnore annotation 
   * is necessary, otherwise the source will have "source":null, and trying to inject a new value
   * will be ignored.
   */
  @JacksonInject
  @JsonIgnore
  public String source = null;
}
