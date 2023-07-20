package com.kavishka.linkedin.learningSpring.web;

import com.kavishka.linkedin.learningSpring.business.ReservationService;
import com.kavishka.linkedin.learningSpring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class guestsController {
    private final ReservationService reservationService;

    public guestsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        List<Guest> guests = this.reservationService.getGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
