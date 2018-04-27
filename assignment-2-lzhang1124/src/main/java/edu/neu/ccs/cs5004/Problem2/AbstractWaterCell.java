package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell{

    public AbstractWaterCell(Boolean isHit) {
        super(isHit);
    }

    @Override
    public attackResult attackResult() {
        return new Miss();
    }


}
