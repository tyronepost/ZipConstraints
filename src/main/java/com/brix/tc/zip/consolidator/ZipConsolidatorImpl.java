package com.brix.tc.zip.consolidator;


import java.util.*;

import static java.lang.Integer.*;

/**
 * Created by Tyrone on 11/26/2015.
 */
public class ZipConsolidatorImpl implements ZipConsolidator {

    @Override
    public List<String> consolidateZipCodes(String[] zipList) {
        SortedSet<ZipRange> zipRangeSet = getSortedZipRanges(zipList);
        List<String> consolidatedZipCodes = getConsolidatedZipCodes(zipRangeSet);
        return consolidatedZipCodes;
    }

    private List<String> getConsolidatedZipCodes(SortedSet<ZipRange> zipRangeSet) {

        List<String> consolidatedZipCodes = new ArrayList<String>();
        Iterator<ZipRange> iterator = zipRangeSet.iterator();
        ZipRange previous = iterator.next();
        while (iterator.hasNext()) {
            ZipRange next = iterator.next();
            if (isMergeable(previous, next)) {
                previous = merge(previous, next);
            } else {
                consolidatedZipCodes.add(previous.toString());
                previous = next;
            }
        }
        consolidatedZipCodes.add(previous.toString());
        return consolidatedZipCodes;
    }

    private boolean isMergeable(ZipRange previous, ZipRange next) {

        int prevEndRange = parseInt(previous.getEndRange());
        int nextStartRange = parseInt(next.getStartRange());
        int nextEndRange = parseInt(next.getEndRange());
        return ((prevEndRange > nextStartRange) && (prevEndRange <= nextEndRange))
                || (prevEndRange == nextStartRange)
                || ((prevEndRange < nextStartRange) && ((nextStartRange - prevEndRange) == 1));
    }

    private ZipRange merge(ZipRange start, ZipRange end) {
        return new MultiZip(start.getStartRange(), end.getEndRange());
    }

    private SortedSet<ZipRange> getSortedZipRanges(String[] zipList) {
        SortedSet<ZipRange> zipRangeSet = new TreeSet<ZipRange>();
        ZipRangeFactory zipRangeFactory = new ZipRangeFactory();
        for (String zip : zipList) {
            zipRangeSet.add(zipRangeFactory.makeZipRange(zip));
        }
        return zipRangeSet;
    }
}
