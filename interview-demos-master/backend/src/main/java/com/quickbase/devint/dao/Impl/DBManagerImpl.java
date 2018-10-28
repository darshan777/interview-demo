package com.quickbase.devint.dao.Impl;

import com.quickbase.devint.dao.DBManager;

import java.sql.*;
import java.util.TreeMap;

/**
 * This DBManager implementation provides a connection to the database containing population data.
 *
 * Created by ckeswani on 9/16/15.
 */
public class DBManagerImpl implements DBManager {
    public Connection getConnection() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resources/data/citystatecountry.db");
            System.out.println("Opened database successfully");

        } catch (ClassNotFoundException cnf) {
            System.out.println("could not load driver");
        } catch (SQLException sqle) {
            System.out.println("sql exception:" + sqle.getStackTrace());
        }
        return c;
    }
    //TODO: Add a method (signature of your choosing) to query the db for population data by country

    /**
     * @param
     * @return A TreeMap with data fetched from database
     * Key of TreeMap is Country Name, Value is total population
     */
    public TreeMap<String, Integer> getAllData(){
        TreeMap<String, Integer> data= new TreeMap<>();
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
            while(rs.next()){
                if(rs!=null){
                    data.put(rs.getString("CountryName"), rs.getInt("Population"));
                }
            }
            System.out.println(data);
            c.close();
            System.out.println("Connection is closed");
        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return data;
    }
}
