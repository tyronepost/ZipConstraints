package com.brix.tc.zip.consolidator;

/**
 * Created by Tyrone on 11/26/2015.
 */
final class SingleZip implements ZipRange {

    public final String zipCode;

    public SingleZip(String zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public String getStartRange() {
        return zipCode;
    }

    @Override
    public String getEndRange() {
        return zipCode;
    }

    @Override
    public int compareTo(ZipRange zipRange) {
        return zipCode.compareTo(zipRange.getStartRange());
    }

    @Override
    public String toString() {
        return zipCode;
    }
}
