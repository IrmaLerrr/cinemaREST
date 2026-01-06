package irmalerrr.cinemaRest.controller;

import irmalerrr.cinemaRest.model.*;
import irmalerrr.cinemaRest.dto.CinemaHallDto;
import irmalerrr.cinemaRest.dto.SeatDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class CinemaController {

    private final CinemaHall cinemaHall = new CinemaHall(9, 9);

    @GetMapping("stats")
    public Statistic getStats(@RequestParam(value = "password", required = false) String password) {
        System.out.println("stats request " + password);
        if (Objects.equals(password, "super_secret")) {
            return cinemaHall.getStatistic();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is wrong!");
        }
    }


    @GetMapping("seats")
    public CinemaHallDto getStatistic() {
        System.out.println("purchase request get seats");
        return new CinemaHallDto(cinemaHall);
    }

    @PostMapping("purchase")
    public SeatDto.PurchaseResponse purchaseSeat(@RequestBody SeatDto.PurchaseRequest seatRequest) {
        System.out.println("purchase request " + seatRequest);
        int row = seatRequest.getRow();
        int column = seatRequest.getColumn();

        if (row < 1 || row > cinemaHall.getRows() || column < 1 || column > cinemaHall.getColumns()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        }
        Seat seat = cinemaHall.getSeats().get((row - 1) * cinemaHall.getColumns() + (column - 1));
        if (seat.isBooked()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }
        String token = cinemaHall.bookSeat(seat);
        System.out.println("returned " + token);
        return new SeatDto.PurchaseResponse(token, new SeatDto.SeatResponse(seat));
    }

    @PostMapping("return")
    public SeatDto.ReturnResponse returnSeat(@RequestBody CinemaHallDto.Token token) {
        System.out.println("return request " + token.getToken());
        Seat seat = cinemaHall.returnSeat(token.getToken());
        return new SeatDto.ReturnResponse(seat);
    }
}
