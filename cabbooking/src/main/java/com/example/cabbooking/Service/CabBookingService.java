package com.example.cabbooking.Service;

import com.example.cabbooking.DTO.DriverDto;
import com.example.cabbooking.DTO.LocationDto;
import com.example.cabbooking.DTO.UserDto;
import com.example.cabbooking.Model.Driver;
import com.example.cabbooking.Model.Location;
import com.example.cabbooking.Repository.CabBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabBookingService {

    @Autowired
    CabBookingRepository cabBookingSystem;

    public CabBookingService(CabBookingRepository cabBookingSystem) {
        this.cabBookingSystem = cabBookingSystem;
    }

    public void addUser(UserDto userDto) {
        cabBookingSystem.addUser(userDto.getUsername(), userDto.getGender(), userDto.getAge());
    }

    public void addDriver(DriverDto driverDto) {
        cabBookingSystem.addDriver(driverDto.getName(), driverDto.getGender(), driverDto.getAge(),
                driverDto.getVehicleDetails(), new Location(driverDto.getCurrentLocation().getLatitude(),
                        driverDto.getCurrentLocation().getLongitude()));
    }

    public List<DriverDto> findRide(String username, double sourceLatitude, double sourceLongitude,
                                    double destinationLatitude, double destinationLongitude) {
        List<Driver> availableRides = cabBookingSystem.findRide(username,
                new Location(sourceLatitude, sourceLongitude),
                new Location(destinationLatitude, destinationLongitude));

        return availableRides.stream().map(this::convertToDriverDto).toList();
    }

    public void chooseRide(String username, String driverName) {
        cabBookingSystem.chooseRide(username, driverName);
    }

    private DriverDto convertToDriverDto(Driver driver) {
        return new DriverDto(driver.getName(), driver.getGender(), driver.getAge(), driver.getVehicleDetails(),
                new LocationDto(driver.getCurrentLocation().getLatitude(), driver.getCurrentLocation().getLongitude()), driver.isAvailable());
    }
}