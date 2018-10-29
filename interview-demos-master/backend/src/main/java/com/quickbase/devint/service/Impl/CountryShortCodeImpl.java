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
        LOGGER.fine("Fetching country Shortcodes fro map");
        //Adding shortcodes to countryShortcodeList
        HashMap<String, String> CountryShortCodeList = new HashMap<>();
        CountryShortCodeList.put("United States of America", "U.S.A.");
        LOGGER.fine("Country Shortcodes Fetched Successfully");
        return CountryShortCodeList;
    }
}
