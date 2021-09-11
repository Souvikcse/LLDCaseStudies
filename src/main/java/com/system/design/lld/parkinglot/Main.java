package com.system.design.lld.parkinglot;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Card;
import com.system.design.lld.parkinglot.models.Pricing;
import com.system.design.lld.parkinglot.models.Vehicle;
import com.system.design.lld.parkinglot.repository.ISlotRepository;
import com.system.design.lld.parkinglot.repository.IVehicleRepository;
import com.system.design.lld.parkinglot.repository.InMemorySlotRepository;
import com.system.design.lld.parkinglot.repository.InMemoryVehicleRepository;
import com.system.design.lld.parkinglot.service.CardService;
import com.system.design.lld.parkinglot.service.ParkingService;
import com.system.design.lld.parkinglot.service.PricingService;
import com.system.design.lld.parkinglot.service.SlotService;
import com.system.design.lld.parkinglot.service.strategy.parking.NaturalOrderParkingStrategy;
import com.system.design.lld.parkinglot.service.strategy.payment.CardPaymentStrategy;
import com.system.design.lld.parkinglot.service.strategy.payment.PaymentStrategy;

import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //1. create an admin object and create the slots and cards

        //2. Check-in checkout and bill-payment
        Vehicle vehicle1 = new Vehicle("A10", "black", "Sedan");
        ISlotRepository slotRepository = new InMemorySlotRepository();
        IVehicleRepository vehicleRepository = new InMemoryVehicleRepository();
        SlotService slotService = new SlotService(new NaturalOrderParkingStrategy(slotRepository), slotRepository);
        CardService cardService = new CardService();

        PaymentStrategy paymentStrategy = new CardPaymentStrategy("1011", "Souvik", "Aug/2025");
        PricingService pricingService = new PricingService(paymentStrategy);
        ParkingService parkingService = new ParkingService(vehicleRepository, slotService, cardService, pricingService);

        Card card = null;
        try {
            card = parkingService.checkInVehicle(vehicle1);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        Pricing bill = parkingService.checkoutVehicle(card);
        paymentStrategy.payBill(bill);

    }
}
