package com.quickbase.devint.dao.Impl;

import com.quickbase.devint.dao.interfcMain.DBManager;

import java.sql.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This DBManager implementation provides a connection to the database containing population data.
 *
 * Created by ckeswani on 9/16/15.
 */
public class DBManagerImpl implements DBManager {
    private final static Logger LOGGER = Logger.getLogger(DBManagerImpl.class.getName());
    public Connection getConnection() {
        Connection c = null;
        Statement stmt = null;
        try {
            LOGGER.fine("Opening Database connection");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/data/citystatecountry.db");
            LOGGER.fine("Database Connection opened Successfully");
        } catch (ClassNotFoundException cnf) {
            LOGGER.log(Level.SEVERE,"Could not Load Driver");
            System.out.println("could not load driver");
        } catch (SQLException sqle) {
            LOGGER.log(Level.SEVERE,"Sql Exeption has occured" );
            System.out.println("sql exception:" + sqle.getStackTrace());
        }

        return c;
    }
    //TODO: Add a method (signature of your choosing) to query the db for population data by country
    /**
     *
     * @return A TreeMap with data fetched from database
     * Key of TreeMap is Country Name, Value is total population
     */
    public HashMap<String, Integer> getAllData(){
        LOGGER.fine("Getting all data from database");
        HashMap<String, Integer> data= new HashMap<>();
        try {
            Connection c = getConnection();
             String query = "select country.countryName, sum(city.population) as population " +
                    "from country " +
                    "left join " +
                    "State on Country.countryId == State.CountryId " +
                    "left join " +
                    "City on State.StateId == City.StateId " +
                    "Group BY Country.CountryName";
            Statement stmn = c.createStatement();
            ResultSet rs = stmn.executeQuery(query);
            //Storing value from Database to TreeMap
            while(rs.next()){
                if(rs!=null){
                    data.put(rs.getString("CountryName"), rs.getInt("Population"));
                }
            }
            LOGGER.fine("Connection Closed");
            c.close();
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage() );
        }
        LOGGER.fine("Data Fetched from database");
        return data;
    }
}
