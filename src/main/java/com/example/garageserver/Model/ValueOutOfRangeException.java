package com.example.garageserver.Model;



public class ValueOutOfRangeException extends RuntimeException  {
    public ValueOutOfRangeException(float minVal, float maxVal)
    {
        super("The value is out of range.\nThe maximum value is " + maxVal + " and the minimum value is " + minVal);
    }
}
