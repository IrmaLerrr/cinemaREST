package irmalerrr.cinemaRest;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class CinemaController {

    private final CinemaHall cinemaHall = new CinemaHall(9, 9);

    @GetMapping("seats")
    public CinemaHallDto getSeats() {
        return new CinemaHallDto(cinemaHall);
    }

    @PostMapping("purchase")
    public SeatDto.PurchaseResponse purchaseSeat(@RequestBody SeatDto.PurchaseRequest seatRequest) {
        int row = seatRequest.getRow();
        int column = seatRequest.getColumn();

        if (row < 1 || row > cinemaHall.getRows() || column < 1 || column > cinemaHall.getColumns()) {
            throw new BadRequestException("The number of a row or a column is out of bounds!");
        }
        Seat seat = cinemaHall.getSeats().get((row - 1) * cinemaHall.getColumns() + (column - 1));
        if (seat.isBooked()) {
            throw new BadRequestException("The ticket has been already purchased!");
        }
        seat.setBooked(true);
        return new SeatDto.PurchaseResponse(seat.getToken(), new SeatDto.SeatResponse(seat));
    }

    @PostMapping("return")
    public SeatDto.SeatResponse returnSeat(@RequestBody SeatDto.Token token) {
        for (Seat seat : cinemaHall.getSeats()) {
            if (Objects.equals(seat.getToken(), token.getToken())) {
                seat.setBooked(false);
                return new SeatDto.SeatResponse(seat);
            }
        }
        throw new BadRequestException("Wrong token!");
    }
}
