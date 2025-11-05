package irmalerrr.cinemaRest;

import org.springframework.web.bind.annotation.*;


@RestController
public class CinemaController {

    @GetMapping("seats")
    public CinemaHall getSeats() {
        return new CinemaHall(3, 4);
    }

}
