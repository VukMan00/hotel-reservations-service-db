package io.swagger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

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

  @JsonProperty("dateFrom")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateFrom = null;

  @JsonProperty("dateTo")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateTo = null;

  public ReservationPK(){}

  public ReservationPK(Integer id, String jmbg, Date dateFrom, Date dateTo){
    this.id = id;
    this.jmbg = jmbg;
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
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

  public ReservationPK dateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;
  }

  /**
   * Get dateFrom
   * @return dateFrom
   **/
  @Schema(required = true, description = "")
  @NotNull(message = "Date from can't be null")

  @Valid
  public Date getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
  }

  public ReservationPK dateTo(Date dateTo) {
    this.dateTo = dateTo;
    return this;
  }

  /**
   * Get dateTo
   * @return dateTo
   **/
  @Schema(required = true, description = "")
  @NotNull(message = "Date to can't be null")

  @Valid
  public Date getDateTo() {
    return dateTo;
  }

  public void setDateTo(Date dateTo) {
    this.dateTo = dateTo;
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
    return  Objects.equals(this.id, reservationPK.id) &&
            Objects.equals(this.jmbg, reservationPK.jmbg) &&
            Objects.equals(this.dateFrom,reservationPK.dateFrom) &&
            Objects.equals(this.dateTo, reservationPK.dateTo);
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
    sb.append("    dateFrom: ").append(toIndentedString(dateFrom)).append("\n");
    sb.append("    dateTo: ").append(toIndentedString(dateTo)).append("\n");
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
