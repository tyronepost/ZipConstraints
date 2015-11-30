package com.brix.tc.zip.consolidator;

import java.util.List;

/**
 * Interface for consolidating Zip Constraints
 */
public interface ZipConsolidator {

    /**
     * Consolidates an array of zip codes and ranges
     *
     * @param zipList array with each entry being either a single zip code or a rang in the format 00000-99999
     * @return  a list of the consolidated zip codes
     */
    public List<String> consolidateZipCodes(String[] zipList);
	
}
