package sqa.main;

public class DistanceConverter {
    public DistanceConverter(){}

    public double getMultiplier(String fromUnit, String toUnit){

        if(fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("m")){
            return 1000.0;
        }

        if(fromUnit.equalsIgnoreCase("m") && toUnit.equalsIgnoreCase("km")){
            return 0.001;
        }
        return 1.0;
    }

    public double convert(
        double value,
        String fromUnit,
        String toUnit){
            return value * getMultiplier(fromUnit, toUnit);
        }
}
