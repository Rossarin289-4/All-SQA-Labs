package sqa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sqa.main.DistanceConverter;
import sqa.main.WeightConverter;
import sqa.main.TemperatureConverter;
import sqa.main.UniversalConverter;

public class TopDownIntegrationTest {
    @Test
    public void testDistanceStub(){
        UniversalConverter converter = new UniversalConverter(
            new Stub_DistanceConverter(),
            new Stub_WeightConverter(),
            new Stub_TemperatureConverter());

            double result = converter.convert(10,"km", "m");
            assertEquals(10000.0, result);
    }

    @Test
    public void testDistanceRealConverter(){
        UniversalConverter converter = new UniversalConverter(
        new DistanceConverter(),
        new Stub_WeightConverter(),
        new Stub_TemperatureConverter());
        assertEquals(5000.0, converter.convert(5, "km", "m"));
    }

    @Test
    public void testWeightStub(){
        UniversalConverter converter = new UniversalConverter(
            new Stub_DistanceConverter(),
            new Stub_WeightConverter(),
            new Stub_TemperatureConverter());

            double result = converter.convert(10, "lb", "oz");
            assertEquals(160.0, result);
    }

    @Test
    public void testWeightRealConverter(){
        UniversalConverter converter = new UniversalConverter(
        new DistanceConverter(),
        new WeightConverter(),
        new Stub_TemperatureConverter());

        assertEquals(160.0, converter.convert(10, "lb", "oz"));
    }

    @Test
    public void testTempStub(){
        UniversalConverter converter = new UniversalConverter(
            new Stub_DistanceConverter(),
            new Stub_WeightConverter(),
            new Stub_TemperatureConverter());
        
            double result = converter.convert(0, "C", "F");
            assertEquals(32.0, result);
    }

    @Test
    public void testTemperatureRealConverter(){
        UniversalConverter converter = new UniversalConverter(
        new DistanceConverter(),
        new WeightConverter(),
        new TemperatureConverter());

        assertEquals(32.0, converter.convert(0, "C", "F"));
    }
}
