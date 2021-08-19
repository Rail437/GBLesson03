package com.example.lesson3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author antonkuznetsov
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private Integer temperature;
}
