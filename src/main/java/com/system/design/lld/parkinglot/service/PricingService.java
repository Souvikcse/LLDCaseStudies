package com.system.design.lld.parkinglot.service;

import com.system.design.lld.parkinglot.models.Pricing;
import com.system.design.lld.parkinglot.service.strategy.payment.PaymentStrategy;

import java.util.Date;

public class PricingService {
    private PaymentStrategy payStrategy;
    private static int billId = 1;

    public PricingService(PaymentStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public Pricing getBill(Date checkinTime, Date checkoutTime){
        Double amt = (checkoutTime.getTime() - checkinTime.getTime())*0.5;
        Pricing bill = new Pricing(billId++, amt);
        return bill;
    }

    public void PayBill(Pricing bill){
        payStrategy.payBill(bill);
    }
}
