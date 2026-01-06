package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserved {
    private Seat seat;
    private String token;

    public Reserved(Seat seat) {
        this.seat = seat;
        this.token = UUID.randomUUID().toString();
    }
}

