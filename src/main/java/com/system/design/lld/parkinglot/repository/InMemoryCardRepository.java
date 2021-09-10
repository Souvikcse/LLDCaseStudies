package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Card;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InMemoryCardRepository implements ICardRepository {

    Map<String, Card> cardMap;

    public InMemoryCardRepository() {
        this.cardMap = new HashMap<>();
    }

    @Override
    public void save(Card entity) throws InvalidObjectException {

    }

    @Override
    public Card get(String s) {
        return null;
    }

    @Override
    public boolean update(Card entity) {
        return false;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Card> fetchCard(Function<Card, Boolean> function) {
        return cardMap.values().stream()
                .filter(card -> function.apply(card))
                .collect(Collectors.toList());
    }
}
