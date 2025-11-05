package irmalerrr.cinemaRest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    private final CinemaHall cinemaHall = new CinemaHall(9, 9);

    @GetMapping("seats")
    public CinemaHall getSeats() {
        return cinemaHall;
    }

    @PostMapping("purchase")
    public Seat purchaseSeat(@RequestBody SeatRequest seatRequest) {
        int row = seatRequest.getRow();
        int column = seatRequest.getColumn();

        if (row < 1 || row > cinemaHall.getRows() || column < 1 || column > cinemaHall.getColumns()) {
            throw new BadRequestException("The number of a row or a column is out of bounds!");
        }
        Seat seat = cinemaHall.getSeats()[(row - 1) * cinemaHall.getColumns() + (column - 1)];
        if (seat.isBooked()) {
            throw new BadRequestException("The ticket has been already purchased!");
        }
        seat.setBooked(true);
        return seat;
    }
}
