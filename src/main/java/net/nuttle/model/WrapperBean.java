package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
@JsonPropertyOrder({"id", "name"})
public class WrapperBean {

  private long id;
  private String name;

  @JsonCreator
  public WrapperBean(@JsonProperty("id") long id, @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }
  
  public long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
}
