package io.swagger.api;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.RoomService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-04T12:42:16.224399976Z[GMT]")
@RestController
public class RoomsApiController implements RoomsApi {

    private static final Logger log = LoggerFactory.getLogger(RoomsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final RoomService roomService;

    @org.springframework.beans.factory.annotation.Autowired
    public RoomsApiController(ObjectMapper objectMapper, HttpServletRequest request, RoomService roomService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.roomService = roomService;
    }

    public ResponseEntity<Room> getRoom(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId) throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(roomService.getRoom(roomId),HttpStatus.OK);
        }
        return new ResponseEntity<Room>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Room>> getRooms() throws NotFoundException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(roomService.getRooms(),HttpStatus.OK);
        }
        return new ResponseEntity<List<Room>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
