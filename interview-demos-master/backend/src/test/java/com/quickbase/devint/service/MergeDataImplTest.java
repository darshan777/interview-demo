package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.MergeDataImpl;
import com.quickbase.devint.service.interfcMain.MergeData;
import junit.framework.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Darshan
 */
public class MergeDataImplTest {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(MergeDataImplTest.class.getName());
    MergeData mergeData = new MergeDataImpl();
    /**
     * Test case for GetMergedData method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void getMergedDataTest(){
       HashMap<String, Integer> mergeDataList = mergeData.getMergedData();
        Assert.assertTrue("No Data was Returned", mergeDataList.size()>0);
        LOGGER.fine("getMergedDataTest Test passed Successfully");
    }
}
