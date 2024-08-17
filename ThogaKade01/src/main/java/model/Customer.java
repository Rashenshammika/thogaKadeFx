package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String id;
    private String title;
    private String name;
    private  String address;
    private LocalDate dob;
    private String number;


}
