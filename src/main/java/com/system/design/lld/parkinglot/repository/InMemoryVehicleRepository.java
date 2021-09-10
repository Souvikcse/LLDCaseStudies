package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Vehicle;

import java.io.*;

public class InMemoryVehicleRepository implements IVehicleRepository {

    @Override
    public void save(Vehicle entity) throws InvalidObjectException {

    }

    @Override
    public Vehicle get(String s) {
        return null;
    }

    @Override
    public boolean update(Vehicle entity) {
        return false;
    }

    @Override
    public void delete(String s) {

    }
}
