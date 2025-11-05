package irmalerrr.cinemaRest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorMessage {
    @JsonProperty("error")
    private String message;
}
