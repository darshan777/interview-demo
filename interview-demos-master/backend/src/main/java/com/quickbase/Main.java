package com.quickbase;

import com.quickbase.devint.dao.interfcMain.DBManager;
import com.quickbase.devint.dao.Impl.DBManagerImpl;
import com.quickbase.devint.service.interfcMain.MergeData;
import com.quickbase.devint.service.Impl.MergeDataImpl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * The main method of the executable JAR generated from this repository. This is to let you
 * execute something from the command-line or IDE for the purposes of demonstration, but you can choose
 * to demonstrate in a different way (e.g. if you're using a framework)
 */
public class Main {
    private  static Logger LOGGER = Logger.getLogger(DBManagerImpl.class.getName());
    public static void main( String args[] ) {
        LOGGER.info("Starting Application");
        DBManager dbm = new DBManagerImpl();
        try {
            Connection c = dbm.getConnection();
            if (null == c) {
                System.out.println("failed.");
                System.exit(1);
            }
            c.close();
        }catch (Exception e){
            System.out.println(e);
        }
        MergeData mergeData = new MergeDataImpl();
        HashMap<String, Integer> mergedDataList = mergeData.getMergedData();
        if(mergedDataList!=null) {
              PrintOutput(mergedDataList);
         //   PrintOutputSorted(mergedDataList);
            LOGGER.info("Application Ended Successfully");
        }
        else{
            System.out.println("EmptyList returned");
        }
    }

    /**
     * Display all the Elements in mergeDataList
     * @param mergedDataList
     */
    public  static void PrintOutput(HashMap<String, Integer> mergedDataList){
        for(Map.Entry<String, Integer> data : mergedDataList.entrySet()){
            System.out.println(data.getKey()+" : "+data.getValue());
        }

    }

    /**
     * Display all the Elements in mergeDataList in sorted form
     * @param mergedDataList
     */
    public  static void PrintOutputSorted(HashMap<String, Integer> mergedDataList) {
        TreeMap<String, Integer> mergedDataListSorted = new TreeMap<>();
        for (Map.Entry<String, Integer> data : mergedDataList.entrySet()) {
            mergedDataListSorted.put(data.getKey(),data.getValue());
        }
        for (Map.Entry<String, Integer> dataSorted : mergedDataListSorted.entrySet()) {
            System.out.println(dataSorted.getKey() + " : " + dataSorted.getValue());
        }
    }
}