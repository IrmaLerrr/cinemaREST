package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CinemaHallDto {
    private int rows;
    private int columns;
    private List<SeatDto.SeatResponse> seats;

    public CinemaHallDto(CinemaHall cinemaHall) {
        this.rows = cinemaHall.getRows();
        this.columns = cinemaHall.getColumns();
        this.seats = cinemaHall.getSeats().stream()
                .map(SeatDto.SeatResponse::new)
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Token {
        private String token;
    }
}
