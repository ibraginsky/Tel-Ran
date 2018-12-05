package dto;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Car {

    private static final int NUM_MODELS = 5;
    private static final int MIN_YEAR = 1980;
    private static final int MAX_YEAR = 2018;
    private static final double MIN_ENGINE = 0.7;
    private static final double MAX_ENGINE = 2.2;
    private static final double AC_PROBABILITY = 0.7;

    static Random gen = new Random();

    private int id;
    private String name;
    private int year;
    private double engine;
    private boolean ac;

    public Car(String name, int year, double engine, boolean ac) {
        super();
        this.name = name;
        this.year = year;
        this.engine = engine;
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", year=" + year + ", engine=" + engine + ", ac=" + ac + "]";
    }

    public String toInsertString() {
        return "('"+name+"',"+year+","+engine+","+ac+")";

    }

    public static Car getRandomCar() {
        String randomModel = "model#"+gen.nextInt(NUM_MODELS);
        int randomYear = MIN_YEAR + gen.nextInt(MAX_YEAR-MIN_YEAR+1);
        double randomEngine = ((int)((MIN_ENGINE + gen.nextDouble()*(MAX_ENGINE-MIN_ENGINE))*100.))/100.;
        boolean randomAc = gen.nextDouble() < AC_PROBABILITY;

        return new Car(randomModel, randomYear, randomEngine, randomAc);
    }




}