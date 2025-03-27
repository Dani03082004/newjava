package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.DataCheck;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PhysicalData {
    protected double high;
    protected double width;
    protected double length;
    protected double weight;
    protected boolean fragile;

    protected PhysicalData() {
    }

    public static PhysicalData getInstance(double high, double width, double length, double weight, boolean fragile) throws BuildException {
        PhysicalData physicalData = new PhysicalData();
        StringBuilder message = new StringBuilder();

        if (physicalData.setHigh(high) != 0) {
            message.append("Bad high; ");
        }
        if (physicalData.setWidth(width) != 0) {
            message.append("Bad width; ");
        }
        if (physicalData.setLength(length) != 0) {
            message.append("Bad length; ");
        }
        if (physicalData.setWeight(weight) != 0) {
            message.append("Bad weight; ");
        }
        physicalData.setFragile(fragile); 

        if (message.length() > 0) {
            throw new BuildException("Failed to create PhysicalData: " + message.toString());
        }
        return physicalData;
    }

    public double getHigh() {
        return high;
    }

    public int setHigh(double high) {
        if (DataCheck.checkNumber(high, 0.1) != 0) {
            return -1;
        }
        this.high = high;
        return 0;
    }

    public double getWidth() {
        return width;
    }

    public int setWidth(double width) {
        if (DataCheck.checkNumber(width, 1) != 0) {
            return -1;
        }
        this.width = width;
        return 0;
    }

    public double getLength() {
        return length;
    }

    public int setLength(double length) {
        if (DataCheck.checkNumber(length, 1) != 0) {
            return -1;
        }
        this.length = length;
        return 0;
    }

    public double getWeight() {
        return weight;
    }

    public int setWeight(double weight) {
        if (DataCheck.checkNumber(weight, 1) != 0) {
            return -1;
        }
        this.weight = weight;
        return 0;
    }

    public boolean getFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public String getSize() {
        return "high: " + this.high + "; width: " + this.width + "; length: " + this.length;
    }

    public double getVolume() {
        return this.high * this.width * this.length;
    }

    @Override
    public String toString() {
        return "PhysicalData[" +
                "high=" + high +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", fragile=" + fragile +
                ']';
    }
}
