package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SeatDto {

    @Data
    @AllArgsConstructor
    public static class PurchaseRequest {
        private int row;
        private int column;
    }

    @Data
    @AllArgsConstructor
    public static class PurchaseResponse {
        private String token;
        private SeatResponse ticket;
    }

    @Data
    @AllArgsConstructor
    public static class SeatResponse {
        private int row;
        private int column;
        private int price;

        public SeatResponse(Seat seat) {
            this.row = seat.getRow();
            this.column = seat.getColumn();
            this.price = seat.getPrice();

        }
    }

    @Data
    @AllArgsConstructor
    public static class Token {
        private String token;
    }
}
