package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import sqa.main.DistanceConverter;
import sqa.main.TemperatureConverter;
import sqa.main.UniversalConverter;
import sqa.main.WeightConverter;

public class BottomUpIntegrationTest {
    
    @Test
    public void testDistanceMultiplier(){
        DistanceConverter converter = new DistanceConverter();

        assertEquals(1000.0, converter.getMultiplier("km", "m"));
    }

    @Test
    public void testWeightMultiplier(){
        WeightConverter converter = new WeightConverter();

        assertEquals(16.0, converter.getMultiplier("lb", "oz"));
    }

    @Test
    public void testDistanceConversion(){
        DistanceConverter converter = new DistanceConverter();

        assertEquals(5000.0, converter.convert(5,"km","m"));
    }

    @Test
    public void testWeightConversion(){
        WeightConverter converter = new WeightConverter();

        assertEquals(160, converter.convert(10, "lb", "oz"));
    }

    @Test
    public void testTempConversion(){
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32.0, converter.convert(0,"C", "F"));
    }

    @Test
    public void testDistanceWithMultiplier(){
        DistanceConverter converter = new DistanceConverter();

        double multiplier = converter.getMultiplier("km", "m");
        double result = 5 * multiplier;
        assertEquals(5000.0, result);
    }

    @Test
    public void testWeightWithMultiplier(){
        WeightConverter converter = new WeightConverter();

        double multiplier = converter.getMultiplier("lb", "oz");
        double result = 10*multiplier;
        assertEquals(160.0, result);
    }

    @Test
    public void testAllConverters(){
        DistanceConverter distance = new DistanceConverter();
        WeightConverter weight = new WeightConverter();
        TemperatureConverter temp = new TemperatureConverter();

        assertEquals(5000.0, distance.convert(5,"km", "m"));
        assertEquals(160.0, weight.convert(10,"lb", "oz"));
        assertEquals(32.0, temp.convert(0,"C", "F"));
    }

    @Test
    public void testCompleteIntegration() {
        UniversalConverter converter = new UniversalConverter();

        assertEquals(10000.0, converter.convert(10, "km", "m"));
        assertEquals(160.0, converter.convert(10, "lb", "oz"));
        assertEquals(32.0, converter.convert(0, "C", "F"));
    }
}
