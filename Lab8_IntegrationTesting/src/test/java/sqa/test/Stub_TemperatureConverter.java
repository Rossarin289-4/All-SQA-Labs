package sqa.test;

import sqa.main.DistanceConverter;
import sqa.main.TemperatureConverter;

public class Stub_TemperatureConverter
        extends TemperatureConverter{

    @Override
    public double convert(
        double value,
        String fromUnit,
        String toUnit
    ){
        return 32.0;
    }
}
