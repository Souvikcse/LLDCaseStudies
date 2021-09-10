package com.system.design.lld.parkinglot.service.strategy.payment;

import com.system.design.lld.parkinglot.models.Pricing;

/**
 * @author nayanava
 */
public interface PaymentStrategy {
    boolean payBill(Pricing totalBill);
}
