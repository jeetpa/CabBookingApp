package com.example.cabbooking.Controller;

import com.example.cabbooking.DTO.DriverDto;
import com.example.cabbooking.DTO.UserDto;
import com.example.cabbooking.Service.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cab")
public class CabController {
    @Autowired
    CabBookingService cabBookingService;


    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDto userDto) {
        cabBookingService.addUser(userDto);
    }

    @PostMapping("/addDriver")
    public void addDriver(@RequestBody DriverDto driverDto) {
        cabBookingService.addDriver(driverDto);
    }

    @GetMapping("/findRide")
    public List<DriverDto> findRide(@RequestParam String username,
                                    @RequestParam double sourceLatitude,
                                    @RequestParam double sourceLongitude,
                                    @RequestParam double destinationLatitude,
                                    @RequestParam double destinationLongitude) {
        return cabBookingService.findRide(username, sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude);
    }

    @PostMapping("/chooseRide")
    public void chooseRide(@RequestParam String username, @RequestParam String driverName) {
        cabBookingService.chooseRide(username, driverName);
    }
}