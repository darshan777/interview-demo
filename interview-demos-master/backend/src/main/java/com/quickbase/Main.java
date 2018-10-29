package com.quickbase;

import com.quickbase.devint.dao.DBManager;
import com.quickbase.devint.dao.Impl.DBManagerImpl;
import com.quickbase.devint.service.MergeData;
import com.quickbase.devint.service.Impl.MergeDataImpl;

import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * The main method of the executable JAR generated from this repository. This is to let you
 * execute something from the command-line or IDE for the purposes of demonstration, but you can choose
 * to demonstrate in a different way (e.g. if you're using a framework)
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(DBManagerImpl.class.getName());

    public static void main( String args[] ) {
        LOGGER.info("Starting Application");
        DBManager dbm = new DBManagerImpl();

        MergeData mergeData = new MergeDataImpl();
        TreeMap<String, Integer> mergedDataList = mergeData.getMergedData();
        printOutput(mergedDataList);
    }

    /**
     *
     * @param mergedDataList
     */
    public  static void printOutput(TreeMap<String, Integer> mergedDataList){
        for(Map.Entry<String, Integer> data : mergedDataList.entrySet()){
            System.out.println(data.getKey()+" : "+data.getValue());
        }
    }
}