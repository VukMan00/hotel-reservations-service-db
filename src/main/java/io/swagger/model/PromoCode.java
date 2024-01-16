package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PromoCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Entity
public class PromoCode implements Serializable {

  @EmbeddedId
  @JsonProperty("promoCodePK")
  private PromoCodePK promoCodePK = null;

  @JsonProperty("code")
  @Column(unique = true)
  private String code;

  @JsonProperty("discount")
  @Min(value = 0,message = "Discount can't be less than 0%")
  @Max(value = 100, message = "Discount can't be more than 100%")
  private Integer discount = null;

  @JsonProperty("used")
  private Boolean used = null;

  @JoinColumn(name="jmbg",insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @JsonProperty("guest")
  private Guest guest = null;

  public PromoCode promoCodePK(PromoCodePK promoCodePK) {
    this.promoCodePK = promoCodePK;
    return this;
  }

  /**
   * Get promoCodePK
   * @return promoCodePK
   **/
  @Schema(description = "")
  @NotNull
    @Valid
    public PromoCodePK getPromoCodePK() {
    return promoCodePK;
  }

  public void setPromoCodePK(PromoCodePK promoCodePK) {
    this.promoCodePK = promoCodePK;
  }

  public PromoCode code(String code){
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(required = true, description = "")
  @NotNull(message = "Code can't be null")

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public PromoCode discount(Integer discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Discount can't be null")

    public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public PromoCode used(Boolean used) {
    this.used = used;
    return this;
  }

  /**
   * Get used
   * @return used
   **/
  @Schema(required = true, description = "")
      @NotNull(message = "Availability of promo code must be specified")

    public Boolean isUsed() {
    return used;
  }

  public void setUsed(Boolean used) {
    this.used = used;
  }

  public PromoCode guest(Guest guest) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromoCode promoCode = (PromoCode) o;
    return  Objects.equals(this.promoCodePK, promoCode.promoCodePK) &&
            Objects.equals(this.code,promoCode.code) &&
            Objects.equals(this.discount, promoCode.discount) &&
            Objects.equals(this.used, promoCode.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(promoCodePK, discount, used, guest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromoCode {\n");
    
    sb.append("    promoCodePK: ").append(toIndentedString(promoCodePK)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    used: ").append(toIndentedString(used)).append("\n");
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
