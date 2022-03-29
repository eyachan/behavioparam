package com.eya.behaviorparam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chocolate implements Candy {
    private String type;
    private Integer weight;
}
