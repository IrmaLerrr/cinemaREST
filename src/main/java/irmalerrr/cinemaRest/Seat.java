package irmalerrr.cinemaRest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat {

    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean booked;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row > 4 ? 8 : 10;
        this.booked = false;
    }

    // constructor from lombok
    // getters and setters from lombok

}
