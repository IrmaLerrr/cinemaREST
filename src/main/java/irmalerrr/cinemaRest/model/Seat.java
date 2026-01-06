package irmalerrr.cinemaRest.model;

import lombok.Data;

@Data
public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean booked;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = calculatePrice(row);
        this.booked = false;
    }

    private int calculatePrice(int row) {
        return row > 4 ? 8 : 10;
    }
}
