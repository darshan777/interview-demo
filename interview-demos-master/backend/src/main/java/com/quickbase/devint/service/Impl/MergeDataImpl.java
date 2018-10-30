package com.quickbase.devint.service.Impl;

import com.quickbase.devint.dao.interfcMain.DBManager;
import com.quickbase.devint.dao.Impl.DBManagerImpl;
import com.quickbase.devint.exception.AppException;
import com.quickbase.devint.service.interfcMain.ConcreteDataClean;
import com.quickbase.devint.service.interfcMain.MergeData;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;
/**
 * Created by Darshan
 */
public class MergeDataImpl implements MergeData {
    private final static Logger LOGGER = Logger.getLogger("com.quickbase.devint.service.Impl");

    /**
     *
     * @return Hashmap with merged data from database and concrete class
     */
    @Override
    public HashMap<String, Integer> getMergedData(){

        try {
            Handler fileHandler  = null;
            fileHandler  = new FileHandler( "./quickbaseDemoService.log");
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(fileHandler);
            LOGGER.info("Merging Data of Database and ConcreteClass");
            DBManager dbm = new DBManagerImpl();
            Connection c = dbm.getConnection();
            ConcreteDataClean concreteDataClean = new ConcreteDataCleanImpl();
            HashMap<String, Integer> coutryPopulationList = concreteDataClean.cleanConcreteData();
            HashMap<String, Integer> mergedDataList = ((DBManagerImpl) dbm).getAllData();
            //Iterating over countrypopulationlist and mergedDataList to find possible duplicates
            if (mergedDataList != null) {
                for (Map.Entry<String, Integer> pair : coutryPopulationList.entrySet()) {
                    if (pair != null) {
                        if (!mergedDataList.containsKey(pair.getKey())) {
                            mergedDataList.put(pair.getKey(), pair.getValue());
                        }
                    } else {
                        throw  new AppException("MergedDataList map is empty");
                    }
                }
                LOGGER.info("Merging of Data Completed");
                return mergedDataList;
            }
        }catch (AppException e){
            e.printStackTrace();
        }catch (IOException e){

        }
        return null;
    }

}
