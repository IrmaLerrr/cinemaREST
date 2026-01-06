package irmalerrr.cinemaRest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class CinemaHall {

    private int rows;
    private int columns;
    private List<Seat> seats;
    private Statistic statistic;
    private List<Reserved> reserved = new ArrayList<>();

    public CinemaHall(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.statistic = new Statistic(0, rows * columns, 0);

        this.seats = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats.add(i * columns + j, new Seat(i + 1, j + 1));
            }
        }

    }

    public String bookSeat(Seat seat) {
        Reserved temp = new Reserved(seat);
        reserved.add(temp);
        seat.setBooked(true);
        this.getStatistic().changeStatistic(1, seat.getPrice());
        return temp.getToken();
    }

    public Seat returnSeat(String token) {
        for (Reserved reserv : this.getReserved()) {
            if (Objects.equals(reserv.getToken(), token)) {
                Seat seat = reserv.getSeat();
                if (seat.isBooked()) {
                    seat.setBooked(false);
                    this.getStatistic().changeStatistic(-1, -seat.getPrice());
                    return seat;
                } else {
                    throw new BadRequestException("Wrong token!");
                }
            }
        }
        throw new BadRequestException("Wrong token!");
    }
}
