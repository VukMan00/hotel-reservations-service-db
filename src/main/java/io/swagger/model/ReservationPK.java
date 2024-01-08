package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationPK
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Embeddable
public class ReservationPK implements Serializable {

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("jmbg")
  @NotBlank(message = "Jmbg of guest is mandatory")
  private String jmbg = null;

  public ReservationPK(){}

  public ReservationPK(Integer id, String jmbg){
    this.id = id;
    this.jmbg = jmbg;
  }

  public ReservationPK id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get roomId
   * @return roomId
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Id of room can't be null")

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReservationPK jmbg(String jmbg) {
    this.jmbg = jmbg;
    return this;
  }

  /**
   * Get guestJMBG
   * @return guestJMBG
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Jmbg of guest can't be null")

    public String getJmbg() {
    return jmbg;
  }

  public void setJmbg(String jmbg) {
    this.jmbg = jmbg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationPK reservationPK = (ReservationPK) o;
    return Objects.equals(this.id, reservationPK.id) &&
        Objects.equals(this.jmbg, reservationPK.jmbg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, jmbg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationPK {\n");
    
    sb.append("    roomId: ").append(toIndentedString(id)).append("\n");
    sb.append("    guestJMBG: ").append(toIndentedString(jmbg)).append("\n");
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
