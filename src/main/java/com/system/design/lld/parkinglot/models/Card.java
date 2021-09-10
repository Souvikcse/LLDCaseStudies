package com.system.design.lld.parkinglot.models;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.service.IdGenerator;
import java.util.Date;

public class Card {
    private String cardId;
    private String vehicleNumber;
    private Date checkInTime;
    private Date checkOutTime;
    private int slotNumber;
    private boolean isCardAssigned;
    public Card() {
        this.cardId = IdGenerator.generate("CID");
    }
    public Card(String vehicleNumber, Date checkInTime, Date checkOutTime, int slotNumber) {
        this.cardId = IdGenerator.generate("CID");
        this.vehicleNumber = vehicleNumber;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.slotNumber = slotNumber;
    }

    public String getCardId() {
        return cardId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isCardAssigned() {
        return isCardAssigned;
    }

    public void setCardAssigned(boolean cardAssigned) {
        isCardAssigned = cardAssigned;
    }

    public void dissociateVehicleNumberAndSlotNumber() {
        this.vehicleNumber = "";
        this.slotNumber = 0;
    }
}
