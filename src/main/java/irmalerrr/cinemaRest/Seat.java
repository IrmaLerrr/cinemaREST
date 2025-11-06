package irmalerrr.cinemaRest;

import lombok.Data;

import java.util.UUID;

@Data
public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean booked;
    private String token;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = calculatePrice(row);
        this.booked = false;
        this.token = UUID.randomUUID().toString();
    }

    private int calculatePrice(int row) {
        return row > 4 ? 8 : 10;
    }
}
