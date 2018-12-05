package model;


import dto.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class carModel {

    public static void createCarTable(Connection connection) throws SQLException {
        String dbReq = "CREATE TABLE IF NOT EXISTS cars (" +
                "id INT(11) NOT NULL AUTOINCRIMENT, " +
                "model VARCHAR(254), " +
                "year INT(11), " +
                "engine DOUBLE, " +
                "ac TYPEINT(1), " +
                "PRIMARY KEY (id)";

        System.out.println(dbReq);
        connection.createStatement().executeUpdate(dbReq);

    }

    public static void insertCars(Connection connection, Collection<Car> cars) throws SQLException {
        String[] carsSQL = new String[cars.size()];
        int i = 0;
        for(Car car : cars) carsSQL[i++] = Car.getRandomCar().toInsertString();
        String dbReq = "INSERT INTO cars (model, year, engine, ac) VALUES "+ String.join(",", carsSQL);
        connection.createStatement().executeUpdate(dbReq);
    }
}
