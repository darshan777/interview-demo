package com.quickbase.devint.service.Impl;

import com.quickbase.devint.dao.interfcMain.IStatService;
import com.quickbase.devint.dao.Impl.ConcreteStatService;
import com.quickbase.devint.service.interfcMain.ConcreteDataClean;
import com.quickbase.devint.service.interfcMain.CountryShortCodes;
import org.apache.commons.lang3.tuple.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
/**
 * Created by Darshan
 */
public class ConcreteDataCleanImpl implements ConcreteDataClean {
    private final static Logger LOGGER = Logger.getLogger(ConcreteDataCleanImpl.class.getName());
    /**
     *
     * @return A HashMap with Cleaned Data from Concreted data
     * The Concrete data is compared from Key of CountryShortcodeList Map
     * If the Key is present in Concrete data , it will replace it with Map Value andd Add to HashMap
     */
    @Override
    public HashMap<String, Integer> cleanConcreteData(){
        LOGGER.fine("Cleaning ConcreteData from API");
        HashMap<String,Integer> CoutryPopulationListConcrete = new HashMap<>();
        IStatService iStatService = new ConcreteStatService();
        List<Pair<String, Integer>> CoutryPopulationList = iStatService.GetCountryPopulations();
        CountryShortCodes countryShortCodes = new CountryShortCodeImpl();
        HashMap<String, String> countryShortCodeList = countryShortCodes.getCountryShortCode();
        //Iterating over CoutryPopulationList and again iterating over countryShortCodeList
        //to find and replace if any matches found
        if(countryShortCodeList!=null) {
            for (Pair<String, Integer> pair : CoutryPopulationList) {
                if (pair != null) {
                    for (Map.Entry<String, String> data : countryShortCodeList.entrySet()) {
                        if (pair.getLeft().equalsIgnoreCase(data.getKey())) {
                            CoutryPopulationListConcrete.put(data.getValue(), pair.getRight());
                        } else {
                            CoutryPopulationListConcrete.put(pair.getLeft(), pair.getRight());
                        }
                    }
                }

            }
            LOGGER.fine("Concrete Data from API cleaned successfully");
            return CoutryPopulationListConcrete;
        }
        return null;
    }
}
