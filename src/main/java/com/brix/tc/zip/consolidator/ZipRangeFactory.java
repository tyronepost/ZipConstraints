package com.brix.tc.zip.consolidator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Tyrone on 11/26/2015.
 */
class ZipRangeFactory {

    private final Pattern SINGLEREGEX = Pattern.compile("^\\d{5}$");
    private final Pattern MULTIREGEX = Pattern.compile("^\\d{5}-\\d{5}$");

    ZipRange makeZipRange(String zipStr) throws IllegalArgumentException {

        Matcher singleMatcher = SINGLEREGEX.matcher(zipStr);
        if (singleMatcher.matches()) {
            return new SingleZip(zipStr);
        }

        Matcher multiMatcher = MULTIREGEX.matcher(zipStr);
        if (multiMatcher.matches()) {
            String[] zipRange = zipStr.split("-");
            return new MultiZip(zipRange[0], zipRange[1]);
        }
        throw new IllegalArgumentException("invalid Zip Format");
    }
}
