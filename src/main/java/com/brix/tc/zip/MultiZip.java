package com.brix.tc.zip;

/**
 * Created by Tyrone on 11/26/2015.
 */
final class MultiZip implements ZipRange {
    private final String startRange;
    private final String endRange;

    public MultiZip(String startRange, String endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public String getStartRange() {
        return startRange;
    }

    @Override
    public String getEndRange() {
        return endRange;
    }

    @Override
    public int compareTo(ZipRange o) {
        return startRange.compareTo(o.getStartRange());
    }

    @Override
    public String toString() {
        return startRange + "-" + endRange;
    }
}
