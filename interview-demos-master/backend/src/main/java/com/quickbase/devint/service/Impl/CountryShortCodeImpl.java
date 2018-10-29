package com.quickbase.devint.service.Impl;

import com.quickbase.devint.exception.AppException;
import com.quickbase.devint.service.CountryShortCodes;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by Darshan
 */
public class CountryShortCodeImpl  implements CountryShortCodes {
    private final static Logger LOGGER = Logger.getLogger(CountryShortCodeImpl.class.getName());
    /**
     *
     * @return Returns a Map of Country and its ShortCode
     */
    @Override
    public HashMap<String, String> getCountryShortCode() {
        LOGGER.info("Fetching country Shortcodes fro map");
        HashMap<String, String> CountryShortCodeList = new HashMap<>();
        try {

            CountryShortCodeList.put("United States of America", "U.S.A.");

            throw new AppException("Data not provided");

        }
        catch (AppException e){
            System.out.println(e);
        }
        LOGGER.info("Country Shortcodes Fetched Successfully");
        return CountryShortCodeList;
    }
}
