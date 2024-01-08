package io.swagger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Credentials;
import io.swagger.model.PromoCode;
import io.swagger.model.Reservation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Guest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Entity
@JsonIgnoreProperties({"promoCodes","reservations"})
public class Guest implements Serializable {

  @Id
  @Column(unique = true)
  @JsonProperty("jmbg")
  @Size(min = 13, max = 13, message = "JMBG must contains 13 characters")
  private String jmbg = null;

  @JsonProperty("name")
  @NotBlank(message = "Name is mandatory")
  private String name = null;

  @JsonProperty("lastname")
  @NotBlank(message = "LastName is mandatory")
  private String lastname = null;

  @JsonProperty("dateOfBirth")
  @PastOrPresent(message = "Date of Birth must be in past")
  private Date dateOfBirth = null;

  @OneToMany(mappedBy = "guest")
  @JsonProperty("reservations")
  @Valid
  private List<Reservation> reservations = null;

  @OneToMany(mappedBy = "guest")
  @JsonProperty("promoCodes")
  @Valid
  private List<PromoCode> promoCodes = null;

  @JoinColumn(name="username",insertable = true, updatable = true)
  @ManyToOne(optional = false)
  @JsonProperty("credentials")
  private Credentials credentials = null;

  public Guest jmbg(String jmbg) {
    this.jmbg = jmbg;
    return this;
  }

  /**
   * Get jmbg
   * @return jmbg
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "JMBG can't be null")

    public String getJmbg() {
    return jmbg;
  }

  public void setJmbg(String jmbg) {
    this.jmbg = jmbg;
  }

  public Guest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Name can't be null")

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Guest lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Lastname can't be null")

    public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Guest dateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Date of birth can't be null")

    @Valid
    public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Guest reservations(List<Reservation> reservations) {
    this.reservations = reservations;
    return this;
  }

  public Guest addReservationsItem(Reservation reservationsItem) {
    if (this.reservations == null) {
      this.reservations = new ArrayList<Reservation>();
    }
    this.reservations.add(reservationsItem);
    return this;
  }

  /**
   * Get reservations
   * @return reservations
   **/
  @Schema(description = "")
      @Valid
    public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Guest promoCodes(List<PromoCode> promoCodes) {
    this.promoCodes = promoCodes;
    return this;
  }

  public Guest addPromoCodesItem(PromoCode promoCodesItem) {
    if (this.promoCodes == null) {
      this.promoCodes = new ArrayList<PromoCode>();
    }
    this.promoCodes.add(promoCodesItem);
    return this;
  }

  /**
   * Get promoCodes
   * @return promoCodes
   **/
  @Schema(description = "")
      @Valid
    public List<PromoCode> getPromoCodes() {
    return promoCodes;
  }

  public void setPromoCodes(List<PromoCode> promoCodes) {
    this.promoCodes = promoCodes;
  }

  public Guest credentials(Credentials credentials) {
    this.credentials = credentials;
    return this;
  }

  /**
   * Get credentials
   * @return credentials
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Credentials can't be null")
    @Valid
    public Credentials getCredentials() {
    return credentials;
  }

  public void setCredentials(Credentials credentials) {
    this.credentials = credentials;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Guest guest = (Guest) o;
    return Objects.equals(this.jmbg, guest.jmbg) &&
        Objects.equals(this.name, guest.name) &&
        Objects.equals(this.lastname, guest.lastname) &&
        Objects.equals(this.dateOfBirth, guest.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jmbg, name, lastname, dateOfBirth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Guest {\n");
    
    sb.append("    jmbg: ").append(toIndentedString(jmbg)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    reservations: ").append(toIndentedString(reservations)).append("\n");
    sb.append("    promoCodes: ").append(toIndentedString(promoCodes)).append("\n");
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
