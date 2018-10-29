package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.MergeDataImpl;
import com.quickbase.devint.service.interfcMain.MergeData;
import junit.framework.Assert;
import org.junit.Test;

import java.util.TreeMap;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by Darshan
 */
public class MergeDataImplTest {
    private static Logger logger = LogManager.getLogger(MergeDataImplTest.class);
    MergeData mergeData = new MergeDataImpl();
    /**
     * Test case for GetMergedData method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void getMergedDataTest(){
       TreeMap<String, Integer> mergeDataList = mergeData.getMergedData();
        Assert.assertTrue("No Data was Returned", mergeDataList.size()>0);
        logger.error("test Run Successful");
    }
}
