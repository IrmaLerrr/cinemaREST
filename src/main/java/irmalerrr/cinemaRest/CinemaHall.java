package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CinemaHall {

    private int rows;
    private int columns;
    private Seat[] seats;

    public CinemaHall(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.seats = new Seat[rows * columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i * columns + j] = new Seat(i + 1, j + 1);
            }
        }
    }

    // getters and setters from lombok

}

