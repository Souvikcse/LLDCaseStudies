package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Slot;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public interface ISlotRepository extends IRepository<Slot, Integer> {
    List<Slot> fetch(Function<Slot, Boolean> func);
}
