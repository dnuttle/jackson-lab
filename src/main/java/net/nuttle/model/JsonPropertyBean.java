package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties({"prop5", "prop6"})
public class JsonPropertyBean {
  
  //Statics are ignored by Jackson
  public static String constant = "constant";
  
  /*
   * @JsonProperty does two things.
   * 1. A private variable is now a JSON property, even if there's no setter/getter
   * 2. You can rename the property from its variable name
   */
  @JsonProperty("Specific")
  private String specific = "default";
  
  private String prop;
  
  //This private variable is invisible to Jackson
  private String prop2 = "prop2";
  
  //This public variable is visible to Jackson, although
  //if there is a @JsonIgnore on a setter or getter, it will be invisible
  public String prop3 = "prop3";
  
  //This public variable is invisible to Jackson thanks to @JsonIgnore
  @JsonIgnore
  public String prop4 = "prop4";
  
  //Invisible to Jackson due to @JsonIgnoreProperties on class
  public String prop5, prop6;
  
  //Invisible because of @JsonIgnoreType on InnerBean class below
  public InnerBean innerBean = new InnerBean();

  /*
   * In the case of specific, we use @JsonProperty("Specific")
   * Without @JsonIgnore here, we would have a duplicate property,
   * specificVariable
   */
  @JsonIgnore
  public void setSpecificVariable(String value) {
    this.specific = value;
  }
  
  @JsonIgnore
  public String getSpecificVariable() {
    return specific;
  }

  /*
   * @JsonSetter lets you specify the name of the property
   * in the JSON that should be sent to the setter.
   */
  @JsonSetter("Property")
  public void setSomeProp(String value) {
    prop = value;
  }

  /*
   * @JsonGetter lets you specify the name of the property
   * to whcih the value returned from this message should be
   * sent in the JSON
   */
  @JsonGetter("Property")
  public String getSomeProp() {
    return prop;
  }
  
  //This getter will be invisible to Jackson
  @JsonIgnore
  public String getProp5() {
    return "prop5";
  }
  
  /*
   * @JsonIgnoreType means that Jackson will always ignore any
   * instances of this type of class.
   */
  @JsonIgnoreType
  public static class InnerBean {
    public String property = "innerbean";
  }
  
}
