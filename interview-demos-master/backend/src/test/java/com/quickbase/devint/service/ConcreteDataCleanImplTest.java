package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.ConcreteDataCleanImpl;
import junit.framework.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by Darshan
 */
public class ConcreteDataCleanImplTest {

    ConcreteDataClean concreteDataClean = new ConcreteDataCleanImpl();


    
    @Test
    public void  cleanConcreteDataImpl(){
        TreeMap<String, Integer> concreteDataList= concreteDataClean.cleanConcreteData();
        Assert.assertTrue("No Data From Concrete List was returned", concreteDataList.size()>0);
    }
}
