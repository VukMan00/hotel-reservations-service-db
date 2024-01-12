package io.swagger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Guest;
import io.swagger.model.ReservationPK;
import io.swagger.model.Room;
import io.swagger.v3.oas.annotations.media.Schema;
import org.aspectj.lang.annotation.Before;
import org.springframework.format.annotation.DateTimeFormat;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reservation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Entity
public class Reservation implements Serializable {

  @EmbeddedId
  @JsonProperty("reservationPK")
  private ReservationPK reservationPK = null;

  @JoinColumn(name="id",insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @JsonProperty("room")
  private Room room = null;

  @JoinColumn(name="jmbg",insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @JsonProperty("guest")
  private Guest guest = null;

  @JsonProperty("dateFrom")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateFrom = null;

  @JsonProperty("dateTo")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateTo = null;

  @JsonProperty("email")
  @Email(message = "Email must be in valid format")
  private String email = null;

  @JsonProperty("token")
  @Size(min = 5, max = 15, message = "Number of characters for token must be in range of 5-15 characters")
  private String token = null;

  @JsonProperty("price")
  private Integer price = null;

  public Reservation reservationPK(ReservationPK reservationPK) {
    this.reservationPK = reservationPK;
    return this;
  }

  /**
   * Get reservationPK
   * @return reservationPK
   **/
  @Schema(required = true, description = "")
    @NotNull(message = "Primary Key of reservation can't be null")
    @Valid
    public ReservationPK getReservationPK() {
    return reservationPK;
  }

  public void setReservationPK(ReservationPK reservationPK) {
    this.reservationPK = reservationPK;
  }

  public Reservation room(Room room) {
    this.room = room;
    return this;
  }

  /**
   * Get room
   * @return room
   **/
  @Schema(required = true, description = "")

    @Valid
    public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Reservation guest(Guest guest) {
    this.guest = guest;
    return this;
  }

  /**
   * Get guest
   * @return guest
   **/
  @Schema(required = true, description = "")

    @Valid
    public Guest getGuest() {
    return guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
  }

  public Reservation dateFrom(Date dateFrom) {
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

  public Reservation dateTo(Date dateTo) {
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

  public Reservation email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Email can't be null")

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Reservation token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Token can't be null")

    public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Reservation price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Price can't be null")

    public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.reservationPK, reservation.reservationPK) &&
        Objects.equals(this.dateFrom, reservation.dateFrom) &&
        Objects.equals(this.dateTo, reservation.dateTo) &&
        Objects.equals(this.email, reservation.email) &&
        Objects.equals(this.token, reservation.token) &&
        Objects.equals(this.price, reservation.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationPK, dateFrom, dateTo, email, token, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    
    sb.append("    reservationPK: ").append(toIndentedString(reservationPK)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
    sb.append("    guest: ").append(toIndentedString(guest)).append("\n");
    sb.append("    dateFrom: ").append(toIndentedString(dateFrom)).append("\n");
    sb.append("    dateTo: ").append(toIndentedString(dateTo)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
