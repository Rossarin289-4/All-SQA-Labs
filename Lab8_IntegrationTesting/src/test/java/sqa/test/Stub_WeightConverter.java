package sqa.test;

import sqa.main.WeightConverter;

public class Stub_WeightConverter
        extends WeightConverter{
    
    @Override
    public double convert(
        double value,
        String fromUnit,
        String toUnit
    ){
        return 160.0;
    }
}
