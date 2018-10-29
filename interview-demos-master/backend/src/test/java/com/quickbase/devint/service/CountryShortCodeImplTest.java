package com.quickbase.devint.service;


import com.quickbase.devint.service.Impl.CountryShortCodeImpl;
import junit.framework.Assert;
import org.junit.Test;
import java.util.HashMap;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Created by Darshan
 */
public class CountryShortCodeImplTest {
    private static Logger logger = LogManager.getLogger(CountryShortCodeImplTest.class);
    CountryShortCodes countryShortCodes = new CountryShortCodeImpl();

    /**
     * Test case for GetCountryShortCode method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void  getCountryShortCodeTest(){
        HashMap<String, String> countryShortCodeList = countryShortCodes.getCountryShortCode();
        Assert.assertTrue("No ShortCode Present in the List", countryShortCodeList.size()>0);
        logger.info("test Run Successful");
    }
}
