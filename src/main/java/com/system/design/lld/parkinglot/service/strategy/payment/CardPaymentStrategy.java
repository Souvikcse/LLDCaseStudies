package com.system.design.lld.parkinglot.service.strategy.payment;

import com.system.design.lld.parkinglot.models.Pricing;

public class CardPaymentStrategy implements PaymentStrategy{
    private String cardNumber;
    private String nameOnCard;
    private String monthAndYearOfExpiry;

    public CardPaymentStrategy() {

    }
    public CardPaymentStrategy(String cardNumber,
                               String nameOnCard,
                               String monthAndYearOfExpiry) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.monthAndYearOfExpiry = monthAndYearOfExpiry;
    }

    @Override
    public boolean payBill(Pricing totalBill) {
        return true;
    }
}
