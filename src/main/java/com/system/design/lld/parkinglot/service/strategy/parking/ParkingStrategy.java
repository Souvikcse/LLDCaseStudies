package com.system.design.lld.parkinglot.service.strategy.parking;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Slot;
import com.system.design.lld.parkinglot.models.Vehicle;

public interface ParkingStrategy {
    Slot fetchVacantSlot(Vehicle vehicle);
}
