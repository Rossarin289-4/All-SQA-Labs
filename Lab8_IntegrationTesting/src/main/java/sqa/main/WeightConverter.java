package sqa.main;

public class WeightConverter {
    
    public WeightConverter(){}

    public double getMultiplier(String fromUnit, String toUnit){

        if(fromUnit.equalsIgnoreCase("lb") && toUnit.equalsIgnoreCase("oz")){
            return 16.0;
        }

        if(fromUnit.equalsIgnoreCase("oz") && toUnit.equalsIgnoreCase("lb")){
            return 1.0/16.0;
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
