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
@EqualsAndHashCode
public class Reservation {
    @JsonProperty
    @EqualsAndHashCode.Exclude
    public Long id;
    @JsonProperty
    public String name;
    @JsonProperty
    public String date;
    @JsonProperty
    public int guests;


}
