package com.example.cabbooking.Repository;

import com.example.cabbooking.Model.Driver;
import com.example.cabbooking.Model.Location;
import com.example.cabbooking.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CabBookingRepository {

    private final List<User> users;
    private final List<Driver> drivers;

    public CabBookingRepository() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public void addUser(String username, String gender, int age) {
        users.add(new User(username, gender, age));
    }

    public void addDriver(String name, String gender, int age, String vehicleDetails, Location currentLocation) {
        drivers.add(new Driver(name, gender, age, vehicleDetails, currentLocation, true));
    }

    public List<Driver> findRide(String username, Location source, Location destination) {
        User user = findUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        List<Driver> availableRides = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && isDriverInRange(driver, source, destination)) {
                availableRides.add(driver);
            }
        }

        return availableRides;
    }

    public void chooseRide(String username, String driverName) {
        // Logic for booking the ride, updating driver status, etc.
        User user = findUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Driver selectedDriver = findDriverByName(driverName);
        if (selectedDriver == null || !selectedDriver.isAvailable()) {
            throw new RuntimeException("Invalid driver selection");
        }
        selectedDriver.setAvailable(false);
    }

    private boolean isDriverInRange(Driver driver, Location source, Location destination) {
        // logic to check if the driver is in the range of the source and destination
        double driverLatitude = driver.getCurrentLocation().getLatitude();
        double driverLongitude = driver.getCurrentLocation().getLongitude();
        double horizontalDistance = driverLatitude - source.getLatitude();
        double verticalDistance = driverLongitude - source.getLongitude();
        double inRange =Math.abs(Math.sqrt(Math.pow(verticalDistance,2)+Math.pow(horizontalDistance,2)));
        if(inRange > 5){
            return false;
        }
        return true;
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private Driver findDriverByName(String driverName) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(driverName)) {
                return driver;
            }
        }
        return null;
    }
}
