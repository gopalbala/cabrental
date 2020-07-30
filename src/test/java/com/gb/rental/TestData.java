package com.gb.rental;

import com.gb.rental.model.common.Address;
import com.gb.rental.model.common.Coordinates;
import com.gb.rental.model.reservation.ReservationStatus;
import com.gb.rental.model.reservation.VehicleInventory;
import com.gb.rental.model.reservation.VehicleReservation;
import com.gb.rental.model.reservation.VehicleReservationType;
import com.gb.rental.model.vehicle.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestData {
    public static HireableVehicle getTruck() {
        HireableVehicle truck = new Car();
        String id = UUID.randomUUID().toString();
        truck.setId(id);
        truck.setLicensePlateNumber("ka05ma8390");
        truck.setQrCode(id);
        truck.setMake("Mahindra");
        truck.setMake("Bolero");
        truck.setYearOfManufacture(2015);
        truck.setMileage(95910);
        truck.setNumberOfSeats(5);
        truck.setVehicleCategory(VehicleCategory.COMMERCIAL);
        truck.setVehicleStatus(VehicleStatus.AVAILALBE);
        truck.setVehicleType(VehicleType.TRUCK);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        truck.setParkedLocation(vehicleLocation);
        return truck;
    }

    public static HireableVehicle getHatchBack() {
        HireableVehicle car = new Car();
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setLicensePlateNumber("ka51ca8344");
        car.setQrCode(id);
        car.setMake("Hyundai");
        car.setMake("i20");
        car.setYearOfManufacture(2018);
        car.setMileage(15010);
        car.setNumberOfSeats(5);
        car.setVehicleCategory(VehicleCategory.PASSENGER);
        car.setVehicleStatus(VehicleStatus.AVAILALBE);
        car.setVehicleType(VehicleType.HATCHBACK);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        car.setParkedLocation(vehicleLocation);
        return car;
    }

    public static HireableVehicle getMarutiHatchBack() {
        HireableVehicle car = new Car();
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setLicensePlateNumber("ka02ca7416");
        car.setQrCode(id);
        car.setMake("Maruti");
        car.setMake("Swift");
        car.setYearOfManufacture(2015);
        car.setMileage(55010);
        car.setNumberOfSeats(5);
        car.setVehicleCategory(VehicleCategory.PASSENGER);
        car.setVehicleStatus(VehicleStatus.AVAILALBE);
        car.setVehicleType(VehicleType.HATCHBACK);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        car.setParkedLocation(vehicleLocation);
        return car;
    }

    public static HireableVehicle getSuvCar() {
        HireableVehicle car = new Car();
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setLicensePlateNumber("ka01aa4561");
        car.setQrCode(id);
        car.setMake("TATA");
        car.setMake("Harrier");
        car.setYearOfManufacture(2019);
        car.setMileage(12156);
        car.setNumberOfSeats(5);
        car.setVehicleCategory(VehicleCategory.PASSENGER);
        car.setVehicleStatus(VehicleStatus.AVAILALBE);
        car.setVehicleType(VehicleType.SUV);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setAddress(getAddress());
        vehicleLocation.setCoordinates(getCoordinates());
        car.setParkedLocation(vehicleLocation);
        return car;
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setAddressLine1("Bannerghatta road parking");
        address.setAddressLine2("Bilekkahalli");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setPinCode("600071");
        return address;
    }

    public static Coordinates getCoordinates() {
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(12.459454);
        coordinates.setLatitude(79.459454);
        return coordinates;
    }


    public static VehicleReservation buildHatchbackReservation() {
        HireableVehicle vehicle = getHatchBack();
        vehicle.setVehicleStatus(VehicleStatus.BOOKED);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId("user1");
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusDays(2));
        vehicleReservation.setStatus(ReservationStatus.ACTIVE);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        vehicleReservation.setAccocatedVehicleId(vehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.DAY);
        return vehicleReservation;
    }

    public static VehicleReservation buildMarutiHatchbackReservation() {
        HireableVehicle vehicle = getMarutiHatchBack();
        vehicle.setVehicleStatus(VehicleStatus.BOOKED);
        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId("user1");
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now().plusDays(20));
        vehicleReservation.setDueDate(LocalDateTime.now().plusDays(25));
        vehicleReservation.setStatus(ReservationStatus.ACTIVE);
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickupLocation(
                vehicle.getParkedLocation().getAddress());

        vehicleReservation.setAccocatedVehicleId(vehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.DAY);
        return vehicleReservation;
    }

    public static List<VehicleInventory> buildVehicleInventory() {
        List<VehicleInventory> vehicleInventories = new ArrayList<>();
        vehicleInventories.add(new VehicleInventory(buildHatchbackReservation(),
                getHatchBack()));
        vehicleInventories.add(new VehicleInventory(buildMarutiHatchbackReservation(),
                getMarutiHatchBack()));
        return vehicleInventories;
    }
}
