package sqa.main;

public class UniversalConverter {
    private DistanceConverter distanceConverter;
    private TemperatureConverter temperatureConverter;
    private WeightConverter weightConverter;

    public UniversalConverter(){
        this.distanceConverter = new DistanceConverter();
        this.weightConverter = new WeightConverter();
        this.temperatureConverter = new TemperatureConverter();
    }

    public UniversalConverter(
        DistanceConverter distanceConverter,
        WeightConverter weightConverter,
        TemperatureConverter temperatureConverter
    ){
        this.distanceConverter = new DistanceConverter();
        this.weightConverter = new WeightConverter();
        this.temperatureConverter = new TemperatureConverter();
    }

    public double convert(double value, String fromUnit, String toUnit){
        if(isDistance(fromUnit,toUnit)){
            return distanceConverter.convert(value, fromUnit, toUnit);
        }
        if(isWeight(fromUnit,toUnit)){
            return weightConverter.convert(value, fromUnit, toUnit);
        }
        if(isTemp(fromUnit,toUnit)){
            return temperatureConverter.convert(value, fromUnit, toUnit);
        }
        return value;
    }

    private boolean isDistance(
        String fromUnit,
        String toUnit){

        return (fromUnit.equalsIgnoreCase("km") 
        || fromUnit.equalsIgnoreCase("m")
        && toUnit.equalsIgnoreCase("m")
        || toUnit.equalsIgnoreCase("km"));
    }

    private boolean isWeight(
        String fromUnit,
        String toUnit){

        return (fromUnit.equalsIgnoreCase("lb")
        || fromUnit.equalsIgnoreCase("oz")
        && toUnit.equalsIgnoreCase("oz")
        || toUnit.equalsIgnoreCase("lb"));
    }

    private boolean isTemp(
        String fromUnit,
        String toUnit){

        return (fromUnit.equalsIgnoreCase("C")
        || fromUnit.equalsIgnoreCase("F")
        && toUnit.equalsIgnoreCase("F")
        || toUnit.equalsIgnoreCase("C"));
    }
}
