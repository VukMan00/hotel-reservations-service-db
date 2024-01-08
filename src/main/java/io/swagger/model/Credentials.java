package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Guest;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Credentials
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Entity
public class Credentials implements Serializable{

  @Id
  @Column(unique = true)
  @JsonProperty("username")
  @NotBlank(message = "Username is mandatory")
  private String username = null;

  @JsonProperty("password")
  @NotBlank(message = "Password is mandatory")
  private String password = null;

  /**
   * Gets or Sets typeGuest
   */
  public enum TypeGuestEnum {
    USER("User"),
    
    ADMIN("Admin");

    private String value;

    TypeGuestEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeGuestEnum fromValue(String text) {
      for (TypeGuestEnum b : TypeGuestEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("typeGuest")
  private TypeGuestEnum typeGuest = null;

  public Credentials username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Username can't be null")

    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Credentials password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Password can't be null")

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Credentials typeGuest(TypeGuestEnum typeGuest) {
    this.typeGuest = typeGuest;
    return this;
  }

  /**
   * Get typeGuest
   * @return typeGuest
   **/
  @Schema(description = "")
  
    public TypeGuestEnum getTypeGuest() {
    return typeGuest;
  }

  public void setTypeGuest(TypeGuestEnum typeGuest) {
    this.typeGuest = typeGuest;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credentials credentials = (Credentials) o;
    return Objects.equals(this.username, credentials.username) &&
        Objects.equals(this.password, credentials.password) &&
        Objects.equals(this.typeGuest, credentials.typeGuest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, typeGuest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Credentials {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    typeGuest: ").append(toIndentedString(typeGuest)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
