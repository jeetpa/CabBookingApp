package com.example.cabbooking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private LocationDto currentLocation;
    private boolean available;
}
