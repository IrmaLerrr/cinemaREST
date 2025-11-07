package irmalerrr.cinemaRest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistic {
    private int income;
    private int available;
    private int purchased;

    public void changeStatistic(int count, int cost){
        this.income += cost;
        this.available -= count;
        this.purchased += count;
    }
}
