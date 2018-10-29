package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.ConcreteDataCleanImpl;
import com.quickbase.devint.service.interfcMain.ConcreteDataClean;
import junit.framework.Assert;

import org.junit.Test;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Created by Darshan
 */
public class ConcreteDataCleanImplTest {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(ConcreteDataCleanImplTest.class.getName());
    ConcreteDataClean concreteDataClean = new ConcreteDataCleanImpl();
    /**
     * Test case for CleanConcreteData method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void  cleanConcreteDataImpl(){
        HashMap<String, Integer> concreteDataList= concreteDataClean.cleanConcreteData();
        Assert.assertTrue("No Data From Concrete List was returned", concreteDataList.size()>0);
        LOGGER.fine("cleanConcreteDataImpl Test passed Successfully");
    }
}
