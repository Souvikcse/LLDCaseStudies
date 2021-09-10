package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Card;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public interface ICardRepository extends IRepository<Card, String>{
    List<Card> fetchCard(Function<Card, Boolean> function) ;
}
