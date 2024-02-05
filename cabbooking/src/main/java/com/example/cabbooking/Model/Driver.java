package com.example.cabbooking.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    String name;
    String gender;
    int age;
    String vehicleDetails;
    Location currentLocation;
    boolean available;
}