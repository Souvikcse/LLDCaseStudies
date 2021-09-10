package com.system.design.lld.parkinglot.service;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Card;
import com.system.design.lld.parkinglot.models.Pricing;
import com.system.design.lld.parkinglot.models.Slot;
import com.system.design.lld.parkinglot.models.Vehicle;
import com.system.design.lld.parkinglot.repository.IVehicleRepository;

import java.io.InvalidObjectException;

public class ParkingService {

    private IVehicleRepository vehicleRepository;
    private SlotService slotService;
    private CardService cardService;

    public ParkingService(IVehicleRepository vehicleRepository, SlotService slotService, CardService cardService) {
        this.vehicleRepository = vehicleRepository;
        this.slotService = slotService;
        this.cardService = cardService;
    }

    public Card checkInVehicle(Vehicle vehicle) throws InvalidObjectException {
        vehicleRepository.save(vehicle);
        Card card = cardService.fetchAnyUnassignedCard();
        Slot vacantSlot = slotService.allotNextAvailableSlot(vehicle);
        cardService.assignVehicleAndSlotToCard(card, vehicle.getRegistrationNumber(), vacantSlot.getSlotNumber());
        return card;
    }

    public Pricing checkoutVehicle(Card card) {
        //TODO:: to be implemented
        return null;
    }
}
