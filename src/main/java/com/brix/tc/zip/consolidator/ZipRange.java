package com.brix.tc.zip.consolidator;

/**
 * Created by Tyrone on 11/26/2015.
 */
interface ZipRange extends Comparable<ZipRange> {
    String getStartRange();
    String getEndRange();
}



