package com.quickbase.devint.service;

import com.quickbase.devint.service.Impl.CountryShortCodeImpl;
import junit.framework.Assert;
import org.junit.Test;
import java.util.HashMap;


/**
 * Created by Darshan
 */
public class CountryShortCodeImplTest {

    CountryShortCodes countryShortCodes = new CountryShortCodeImpl();

    @Test
    public void  getCountryShortCodeTest(){
        HashMap<String, String> countryShortCodeList = countryShortCodes.getCountryShortCode();
        Assert.assertTrue("No ShortCode Present in the List", countryShortCodeList.size()>0);
    }
}
