package net.nuttle.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawValueBean {

  /*
   * The value here would normally be written to JSON enclosed in double quotes,
   * but @JsonRawValue ensures that doesn't happen.
   * So for example a string here can be written as a numeric value.
   * It also means that a string value here could be actual JSON,
   * which would then get written into JSON result as, well, valid JSON.
   */
  @JsonRawValue
  public String property = "1";
}
