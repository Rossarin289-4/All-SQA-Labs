package  sqa.main;

public class TemperatureConverter {
    public TemperatureConverter(){}

    public double convert(
        double value,
        String fromUnit,
        String toUnit){
    if(fromUnit.equalsIgnoreCase("C") && toUnit.equalsIgnoreCase("F")){
        return (value * 9.0/5.0) + 32.0;
    }
    
    if(fromUnit.equalsIgnoreCase("F") && toUnit.equalsIgnoreCase("C")){
        return (value - 32.0) * 5.0/9.0;
        }
        return value;
    }
}
