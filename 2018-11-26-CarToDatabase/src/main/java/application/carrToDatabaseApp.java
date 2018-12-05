package application;

import connection.ConnectionDB;
import dto.Car;
import model.carModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class carrToDatabaseApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        ArrayList<Car> garage = new ArrayList<>();
        for(int i=0; i<97; i++)garage.add(Car.getRandomCar());
        carModel.insertCars(connection, garage);
//        carModel
    }
}
