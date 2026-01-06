package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SeatDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PurchaseRequest {
        private int row;
        private int column;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PurchaseResponse {
        private String token;
        private SeatResponse ticket;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReturnResponse {
        private SeatResponse ticket;

        public ReturnResponse(Seat seat) {
            this.ticket = new SeatResponse(seat);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
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
}
