package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.MergeDataImpl;
import com.quickbase.devint.service.MergeData;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by Darshan
 */
public class MergeDataImplTest {


    MergeData mergeData = new MergeDataImpl();

    @Test
    public void getMergedDataTest(){
       TreeMap<String, Integer> mergeDataList = mergeData.getMergedData();
        Assert.assertTrue("No Data was Returned", mergeDataList.size()>0);
    }
}
