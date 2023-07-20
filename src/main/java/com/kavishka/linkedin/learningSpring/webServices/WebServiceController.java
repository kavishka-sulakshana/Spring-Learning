package com.kavishka.linkedin.learningSpring.webServices;

import com.kavishka.linkedin.learningSpring.business.ReservationService;
import com.kavishka.linkedin.learningSpring.business.RoomReservation;
import com.kavishka.linkedin.learningSpring.data.Guest;
import com.kavishka.linkedin.learningSpring.data.GuestRepository;
import com.kavishka.linkedin.learningSpring.data.Room;
import com.kavishka.linkedin.learningSpring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests(){
        return this.reservationService.getGuests();
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String stringDate){
        Date date = this.dateUtils.createDateFromDateString(stringDate);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public String addGuest(@RequestBody Guest newGuest){
        this.reservationService.addGuest(newGuest);
        return "Success";
    }

    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room newRoom){
        return this.reservationService.addRoom(newRoom);
    }
}
