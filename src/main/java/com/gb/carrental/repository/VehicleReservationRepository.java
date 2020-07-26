package com.gb.carrental.repository;

import com.gb.carrental.model.reservation.VehicleReservation;
import com.gb.carrental.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleReservationRepository {
    public static Map<String, VehicleReservation> vehicleReservationMap =
            new HashMap<>();
    public static List<VehicleReservation> vehicleReservations = new ArrayList<>();

    public static List<VehicleReservation>
    getVehicleByType(String type, LocalDateTime fromDate, LocalDateTime toDate) {
        return null;
    }

    public List<VehicleReservation> getVehicleReservations(VehicleType vehicleType) {
        return vehicleReservations.stream().filter(vehicleReservation ->
                vehicleReservation.getVehicle().getVehicleType() == vehicleType)
                .collect(Collectors.toList());
    }

    public VehicleReservation getVehicleReservation(String reservationId) {
        return vehicleReservationMap.get(reservationId);
    }
}
