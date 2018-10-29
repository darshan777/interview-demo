package com.quickbase.devint.service.Impl;

import com.quickbase.devint.dao.DBManager;
import com.quickbase.devint.dao.Impl.DBManagerImpl;
import com.quickbase.devint.service.ConcreteDataClean;
import com.quickbase.devint.service.MergeData;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Darshan
 */
public class MergeDataImpl implements MergeData {
    private final static Logger LOGGER = Logger.getLogger(MergeDataImpl.class.getName());

    /**
     *
     * @return TreeMap with merged data from database and concrete class
     */
    @Override
    public TreeMap<String, Integer> getMergedData(){
        LOGGER.info("Merging Data of Database and ConcreteClass");
        DBManager dbm = new DBManagerImpl();
        Connection c = dbm.getConnection();
        ConcreteDataClean concreteDataClean = new ConcreteDataCleanImpl();
        TreeMap<String, Integer> coutryPopulationList = concreteDataClean.cleanConcreteData();

        TreeMap<String, Integer> mergedDataList = ((DBManagerImpl) dbm).getAllData();
        for (Map.Entry<String, Integer> pair: coutryPopulationList.entrySet()) {
            if(pair!=null) {
                if (!mergedDataList.containsKey(pair.getKey())) {
                    mergedDataList.put(pair.getKey(), pair.getValue());
                }
            }
        }
        LOGGER.info("Merging of Data Completed");
        return mergedDataList;

    }
}
