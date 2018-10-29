package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.ConcreteDataCleanImpl;
import junit.framework.Assert;

import org.junit.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.TreeMap;

/**
 * Created by Darshan
 */
public class ConcreteDataCleanImplTest {
    private static Logger logger = LogManager.getLogger(ConcreteDataCleanImplTest.class);
    ConcreteDataClean concreteDataClean = new ConcreteDataCleanImpl();
    /**
     * Test case for CleanConcreteData method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void  cleanConcreteDataImpl(){
        TreeMap<String, Integer> concreteDataList= concreteDataClean.cleanConcreteData();
        Assert.assertTrue("No Data From Concrete List was returned", concreteDataList.size()>0);
        logger.info("test Run Successful");
    }
}
