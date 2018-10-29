package com.quickbase.devint.service.Impl;

import com.quickbase.devint.dao.IStatService;
import com.quickbase.devint.dao.Impl.ConcreteStatService;
import com.quickbase.devint.service.ConcreteDataClean;
import com.quickbase.devint.service.CountryShortCodes;
import org.apache.commons.lang3.tuple.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Darshan
 */
public class ConcreteDataCleanImpl implements ConcreteDataClean {

    /**
     *
     * @return A TreeMap with Cleaned Data from Concreted data
     * The Concrete data is compared from Key of CountryShortcodeList Map
     * If the Key is present in Concrete data , it will replace it with Map Value andd Add to Treemap
     */
    @Override
    public TreeMap<String, Integer> cleanConcreteData(){
        TreeMap<String,Integer> CoutryPopulationListConcrete = new TreeMap<>();
        IStatService iStatService = new ConcreteStatService();
        List<Pair<String, Integer>> CoutryPopulationList = iStatService.GetCountryPopulations();
        CountryShortCodes countryShortCodes = new CountryShortCodeImpl();
        HashMap<String, String> countryShortCodeList = countryShortCodes.getCountryShortCode();


        for (Pair<String, Integer> pair : CoutryPopulationList) {
            if(pair!=null) {
                for(Map.Entry<String, String> data : countryShortCodeList.entrySet()){
                    if(pair.getLeft().equalsIgnoreCase(data.getKey())){
                        CoutryPopulationListConcrete.put(data.getValue(), pair.getRight());
                    }
                    else {
                        CoutryPopulationListConcrete.put(pair.getLeft(), pair.getRight());
                    }
                }
            }

        }
        return CoutryPopulationListConcrete;
    }
}
