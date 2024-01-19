/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.52).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;


import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@Validated
public interface GuestsApi {

    @Operation(summary = "Return Guest details", description = "Return the Guest details", security = {
        @SecurityRequirement(name = "BasicAuth")    }, tags={ "Guest" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Fetch Guest details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Guest.class))),
        
        @ApiResponse(responseCode = "404", description = "One of the objects not found, Hotel or Guest"),
        
        @ApiResponse(responseCode = "500", description = "An error occured while processing the request. ") })
    @RequestMapping(value = "/guests/{guestJMBG}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Guest> getGuest(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) throws NotFoundException;


    @Operation(summary = "Return Promo Codes", description = "Return Promo Codes of Guest", security = {
        @SecurityRequirement(name = "BasicAuth")    }, tags={ "Guest" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Fetch Promo Codes", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PromoCode.class)))),
        
        @ApiResponse(responseCode = "404", description = "Guest not found"),
        
        @ApiResponse(responseCode = "500", description = "An error occured while processing the request. ") })
    @RequestMapping(value = "/guests/{guestJMBG}/promoCodes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PromoCode>> getPromoCodes(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) throws NotFoundException;

    @Operation(summary = "Return Promo Code", description = "Returns Promo Code of Guest with specific code", security = {
            @SecurityRequirement(name = "BasicAuth")    }, tags={ "Guest" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch Promo Code", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PromoCode.class)))),

            @ApiResponse(responseCode = "404", description = "Promo Code not found"),

            @ApiResponse(responseCode = "500", description = "An error occured while processing the request. ") })
    @RequestMapping(value = "/guests/{guestJMBG}/promoCodes/{code}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<PromoCode> getPromoCode(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG,
                                                 @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code) throws NotFoundException;

    @Operation(summary = "Register guest", description = "Registration of a guest for specific hotel", tags={ "Guest" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Registration is successfully made"),
        
        @ApiResponse(responseCode = "500", description = "An error occured while processing the request. ") })
    @RequestMapping(value = "/guests",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> registrationGuest(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Guest body) throws HttpClientErrorException;


    @Operation(summary = "Creates Promo Code", description = "Creates Promo Code for Guest to use for other reservations", security = {
        @SecurityRequirement(name = "BasicAuth")    }, tags={ "Guest" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "PromoCode is successfully made"),
        
        @ApiResponse(responseCode = "404", description = "Guest not found"),
        
        @ApiResponse(responseCode = "500", description = "An error occured while processing the request. ") })
    @RequestMapping(value = "/guests/{guestJMBG}/promoCodes",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> savePromoCode(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG,
                                       @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody PromoCode body) throws NotFoundException, HttpClientErrorException;

}

