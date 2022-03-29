package com.eya.behaviorparam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cake implements Candy {
    private String flavor;
    private Integer weight;
}
