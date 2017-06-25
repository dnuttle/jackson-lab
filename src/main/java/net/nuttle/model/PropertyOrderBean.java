package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "source"})
public class PropertyOrderBean {

  public String id;
  public String name;
  public String source;
}
