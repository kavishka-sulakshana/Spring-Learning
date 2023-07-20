package com.kavishka.linkedin.learningSpring.web;
import org.springframework.ui.Model;
import com.kavishka.linkedin.learningSpring.business.ReservationService;
import com.kavishka.linkedin.learningSpring.business.RoomReservation;
import com.kavishka.linkedin.learningSpring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservation(@RequestParam(value = "date",required = false) String dateString, Model model){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", reservations);
        return "roomres";
    }
}
