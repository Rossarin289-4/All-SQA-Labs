package sqa.test;

import sqa.main.DistanceConverter;

public class Stub_DistanceConverter
        extends DistanceConverter{
    
    @Override
    public double convert(
        double value,
        String fromUnit,
        String toUnit
    ){
        return 10000.0;
    }
}
