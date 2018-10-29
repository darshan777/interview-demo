package com.quickbase.devint.service.Impl;

import com.quickbase.devint.service.CountryShortCodes;

import java.util.HashMap;

/**
 * Created by Darshan
 */
public class CountryShortCodeImpl  implements CountryShortCodes {

    /**
     *
     * @return Returns a Map of Country and its ShortCode
     */
    @Override
    public HashMap<String, String> getCountryShortCode(){
        HashMap<String, String> CountryShortCodeList= new HashMap<>();
        CountryShortCodeList.put("United States of America","U.S.A.");

        return CountryShortCodeList;
    }
}
