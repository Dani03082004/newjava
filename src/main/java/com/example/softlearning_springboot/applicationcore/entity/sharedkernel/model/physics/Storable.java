package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

public interface Storable {
    double getHigh();

    double getLength();

    double getWidth();

    double getWeight();

    double getVolume(); // W*L*H

    boolean getFragile();

    String getPackageDimensions(); // W:1:L;2,2:H:3,1
}
