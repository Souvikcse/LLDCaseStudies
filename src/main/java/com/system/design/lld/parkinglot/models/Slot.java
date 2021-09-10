package com.system.design.lld.parkinglot.models;

import com.system.design.lld.parkinglot.service.IdGenerator;

/**
 * @author nayanava
 */

public class Slot {
    private String slotId;
    private int slotNumber;
    private String carNumber;

    public Slot(int slotNumber) {
        this.slotId = IdGenerator.generate("SID");
    }

    public String getSlotId() {
        return slotId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isSlotEmpty() {
        return null == carNumber || carNumber.isEmpty();
    }

    public void assignCarToSlot(String carNumber) {
        this.carNumber = carNumber;
    }

    private void emptySlot() {
        this.carNumber = "";
    }
}
