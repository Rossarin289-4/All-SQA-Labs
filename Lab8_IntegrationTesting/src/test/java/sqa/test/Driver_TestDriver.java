package sqa.test;

import sqa.main.DistanceConverter;
import sqa.main.WeightConverter;
import sqa.main.TemperatureConverter;
import sqa.main.UniversalConverter;

public class Driver_TestDriver {

    public static void main(String[] args) {

        DistanceConverter distance =
                new DistanceConverter();

        WeightConverter weight =
                new WeightConverter();

        TemperatureConverter temperature =
                new TemperatureConverter();

        UniversalConverter universal =
                new UniversalConverter();

        System.out.println(
                "===== Bottom-up Integration =====");

        System.out.println(
                "Distance multiplier = "
                + distance.getMultiplier("km", "m"));

        System.out.println(
                "Weight multiplier = "
                + weight.getMultiplier("lb", "oz"));

        System.out.println(
                "Distance conversion = "
                + distance.convert(5, "km", "m"));

        System.out.println(
                "Weight conversion = "
                + weight.convert(10, "lb", "oz"));

        System.out.println(
                "Temperature conversion = "
                + temperature.convert(0, "C", "F"));

        System.out.println(
                "Universal Distance = "
                + universal.convert(10, "km", "m"));

        System.out.println(
                "Universal Weight = "
                + universal.convert(10, "lb", "oz"));

        System.out.println(
                "Universal Temperature = "
                + universal.convert(0, "C", "F"));
    }
}