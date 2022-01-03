package org.acme.hibernate.orm.panache;

public class FruitError {
  private String error_number;
  private String error_message;

  public FruitError(String error_number, String error_message) {
    this.error_number = error_number;
    this.error_message = error_message;
  }

  public String getError_number() {
    return this.error_number;
  }

  public void setError_number(String error_number) {
    this.error_number = error_number;
  }

  public String getError_message() {
    return this.error_message;
  }

  public void setError_message(String error_message) {
    this.error_message = error_message;
  }
}
