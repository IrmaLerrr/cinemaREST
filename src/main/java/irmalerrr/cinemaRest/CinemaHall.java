package irmalerrr.cinemaRest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CinemaHall {

    private int rows;
    private int columns;
    private List<Seat> seats;

    public CinemaHall(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.seats = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats.add(i * columns + j, new Seat(i + 1, j + 1));
            }
        }
    }
}

