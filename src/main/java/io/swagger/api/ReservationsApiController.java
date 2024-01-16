package io.swagger.api;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.ReservationService;
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
import java.util.Date;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@RestController
public class ReservationsApiController implements ReservationsApi {

    private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ReservationService reservationService;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationsApiController(ObjectMapper objectMapper, HttpServletRequest request, ReservationService reservationService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.reservationService = reservationService;
    }

    @Override
    public ResponseEntity<Void> deleteReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("email") String email,
                                                  @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("token") String token) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")) {
            reservationService.deleteReservation(email,token);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Reservation> getReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("email") String email,
                                                      @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("token") String token) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Reservation>(reservationService.getReservation(email,token),HttpStatus.OK);
        }
        return new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Reservation>> getRoomReservations(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(reservationService.getRoomReservations(roomId),HttpStatus.OK);
        }
        return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> saveReservation(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Reservation reservation) throws NotFoundException, HttpClientErrorException {
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")) {
            reservationService.saveRoomReservation(reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Reservation>> getRoomReservationsOfDate(Integer roomId, Date dateFrom, Date dateTo){
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(reservationService.getRoomReservationsOfDate(roomId,dateFrom,dateTo),HttpStatus.OK);
        }
        return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> updatePriceOfReservation(String email, String token, Reservation reservation) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")) {
            reservationService.updatePriceOfReservation(email,token,reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
}
