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
import java.util.Date;

public class ParkingService {

    private IVehicleRepository vehicleRepository;
    private SlotService slotService;
    private CardService cardService;
    private PricingService pricingService;

    public ParkingService(IVehicleRepository vehicleRepository, SlotService slotService,
                          CardService cardService, PricingService pricingService) {
        this.vehicleRepository = vehicleRepository;
        this.slotService = slotService;
        this.cardService = cardService;
        this.pricingService = pricingService;
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
        Date inTime = card.getCheckInTime();
        Vehicle vehicle = vehicleRepository.get(card.getVehicleNumber());

        // release card
        cardService.releaseVehicleAndSlotFromCard(card.getCardId());

        //generate bill
        Pricing bill = pricingService.getBill(inTime, card.getCheckOutTime());

        // delete vehicle from memory
        vehicleRepository.delete(vehicle.getRegistrationNumber());

        // release slot
        slotService.releaseSlot(card.getSlotNumber());

        return bill;
    }
}
