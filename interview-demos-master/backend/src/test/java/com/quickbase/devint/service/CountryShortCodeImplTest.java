package com.quickbase.devint.service;


import com.quickbase.devint.service.Impl.CountryShortCodeImpl;
import com.quickbase.devint.service.interfcMain.CountryShortCodes;
import junit.framework.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Darshan
 */
public class CountryShortCodeImplTest {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(CountryShortCodeImplTest.class.getName());
    CountryShortCodes countryShortCodes = new CountryShortCodeImpl();
    /**
     * Test case for GetCountryShortCode method
     * Test will fail if Map does not contain more than one element
     */
    @Test
    public void  getCountryShortCodeTest(){
        HashMap<String, String> countryShortCodeList = countryShortCodes.getCountryShortCode();
        Assert.assertTrue("No ShortCode Present in the List", countryShortCodeList.size()>0);
        LOGGER.fine("getCountryShortCodeTest Test passed Successfully");
    }
}
