package com.system.design.lld.parkinglot.service;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Card;
import com.system.design.lld.parkinglot.repository.ICardRepository;

import java.io.*;
import java.util.Date;

public class CardService {
    public ICardRepository cardRepository;

    public Card createCard() throws InvalidObjectException {
        Card card = new Card();
        cardRepository.save(card);
        return card;
    }

    public Card fetchAnyUnassignedCard() {
        return cardRepository.fetchCard(Card::isCardAssigned)
                .stream()
                .findAny()
                .get();
    }

    public Card assignVehicleAndSlotToCard(Card card, String vehicleNumber, int slotNumber) throws InvalidObjectException {
        card.setCardAssigned(true);
        card.setVehicleNumber(vehicleNumber);
        card.setSlotNumber(slotNumber);
        card.setCheckInTime(new Date(System.currentTimeMillis()));
        cardRepository.save(card);

        return card;
    }

    public Card releaseVehicleAndSlotFromCard(String cardId) {
        Card card = cardRepository.get(cardId);
        card.setCardAssigned(false);
        card.setCheckOutTime(new Date(System.currentTimeMillis()));
        card.dissociateVehicleNumberAndSlotNumber();
        cardRepository.update(card);

        return card;
    }
}
