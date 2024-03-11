package org.example;

//import org.example.log4j2.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Car;
import org.example.CarRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository {

    private JdbcUtils dbUtils;


    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
 	//to do
        logger.traceEntry("finding tasks by manufacturer {}",manufacturerN);
        Connection con=dbUtils.getConnection();
        List<Car> tasks=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from cars where manufacturer=?")){
            preStmt.setString(1,manufacturerN);
            try(ResultSet result=preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    tasks.add(car);
                }
                return tasks;
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB "+e);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
	//to do
        logger.traceEntry("finding tasks between years {} {}",min,max);
        Connection con=dbUtils.getConnection();
        List<Car> tasks=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from cars where year between ? and ?")){
            preStmt.setInt(1,min);
            preStmt.setInt(2,max);
            try(ResultSet result=preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    tasks.add(car);
                }
                return tasks;
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB "+e);
        }

        return new ArrayList<>();
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {} ",elem);
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("insert into cars (manufacturer,model,year) values (?,?,?)")){
            preStmt.setString(1,elem.getManufacturer());
            preStmt.setString(2,elem.getModel());
            preStmt.setInt(3,elem.getYear());
            int result=preStmt.executeUpdate();
            logger.trace("Saved {} instances",result);
        //to do
    } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB "+e);
        }
           logger.traceExit();
    }

        @Override
    public void update(Integer integer, Car elem) {
        logger.traceEntry("updating task with id {} ",integer);
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preStmt=con.prepareStatement("update cars set manufacturer=?, model=?, year=? where id=?")){
            preStmt.setString(1,elem.getManufacturer());
            preStmt.setString(2,elem.getModel());
            preStmt.setInt(3,elem.getYear());
            preStmt.setInt(4,integer);
            int result=preStmt.executeUpdate();
            logger.trace("Updated {} instances",result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB "+e);
        }

      //to do
    }

    @Override
    public List<Car> findAll() {
        logger.traceEntry();
        Connection con=dbUtils.getConnection();
        List<Car> tasks=new ArrayList<>();
        try(PreparedStatement preStmt=con.prepareStatement("select * from cars")) {
            try(ResultSet result=preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    tasks.add(car);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB "+e);
        }
        logger.traceExit(tasks);
        return tasks;
         //to do
	//return new ArrayList<>();

    }
}
