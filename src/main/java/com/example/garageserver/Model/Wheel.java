package com.example.garageserver.Model;

import java.text.ParseException;
import java.util.Random;
public class Wheel {

    private float curAirPressure;
    private float maximumAirPressure;

    public Wheel(String curAirPressure, String maxPressure) throws IllegalArgumentException, ParseException {
        setMaximumAirPressure(Float.parseFloat(maxPressure));
        if (curAirPressure == null) {
            this.curAirPressure = new Random().nextFloat() * maximumAirPressure;
        } else {
            FillAir(Float.parseFloat(curAirPressure));
        }
    }


    public float getCurAirPressure() {
        return curAirPressure;
    }

    public float getMaximumAirPressure() {
        return maximumAirPressure;
    }

    public void setMaximumAirPressure(float i_MaximumAirPressure) throws IllegalArgumentException{
        if (i_MaximumAirPressure < 0) {
            throw new IllegalArgumentException("The maximum air pressure must be above 0\n");
        }
        maximumAirPressure = i_MaximumAirPressure;
    }

    public void setCurAirPressure(float i_CurAirPressure) {
        this.curAirPressure = i_CurAirPressure;
    }

    public void FillAir(float i_AddAirPressure)
    {
        if (i_AddAirPressure < 0 || i_AddAirPressure + curAirPressure > maximumAirPressure)
        {
            throw new ValueOutOfRangeException(0, maximumAirPressure - curAirPressure);
        }
        curAirPressure += i_AddAirPressure;
    }

    public void FillMaxAir()
    {
        curAirPressure = maximumAirPressure;
    }
}
