package com.xyz.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE)
public class Reservation {
    @JsonProperty
    public Long id;
    @JsonProperty
    public String name;
    @JsonProperty
    public String date;
    @JsonProperty
    public int guests;


}
