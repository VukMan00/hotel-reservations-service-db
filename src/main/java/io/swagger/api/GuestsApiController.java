package io.swagger.api;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.GuestsService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@RestController
public class GuestsApiController implements GuestsApi {

    private static final Logger log = LoggerFactory.getLogger(GuestsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final GuestsService guestsService;

    @org.springframework.beans.factory.annotation.Autowired
    public GuestsApiController(ObjectMapper objectMapper, HttpServletRequest request, GuestsService guestsService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.guestsService = guestsService;
    }

    public ResponseEntity<Guest> getGuest(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Guest>(guestsService.getGuest(guestJMBG),HttpStatus.OK);
        }
        return new ResponseEntity<Guest>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Guest> getGuestFromUsername(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("username") String username) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            if (accept != null && accept.contains("application/json")) {
                return new ResponseEntity<Guest>(guestsService.getGuestFromUsername(username),HttpStatus.OK);
            }
        }
        return new ResponseEntity<Guest>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> deleteGuest(String guestJMBG) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")){
            guestsService.delete(guestJMBG);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PromoCode>> getPromoCodes(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(guestsService.getPromoCodes(guestJMBG),HttpStatus.OK);
        }
        return new ResponseEntity<List<PromoCode>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<PromoCode> getPromoCode(String guestJMBG, String code) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(guestsService.getPromoCode(guestJMBG,code),HttpStatus.OK);
        }
        return new ResponseEntity<PromoCode>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> registrationGuest(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Guest guest) throws HttpClientErrorException {
        String accept = request.getHeader("Accept");
        if(accept != null && accept.contains("application/json")){
            guestsService.saveGuest(guest);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> savePromoCode(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG,
                                              @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody PromoCode promoCode) throws NotFoundException,HttpClientErrorException {
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")){
            guestsService.saveGuestPromoCode(guestJMBG,promoCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
