package com.brix.tc.zip;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tyrone on 11/26/2015.
 */
public class MultiZipTest {

    @Test
    public void test() {

        ZipRange multiZip = new MultiZip("06412", "06415");
        assertEquals("06412", multiZip.getStartRange());
        assertEquals("06415", multiZip.getEndRange());

        ZipRange lower = new SingleZip("06411");
        assertEquals(1, multiZip.compareTo(lower));

        ZipRange higher = new SingleZip("06413");
        assertEquals(-1, multiZip.compareTo(higher));

        ZipRange same = new SingleZip("06412");
        assertEquals(0, multiZip.compareTo(same));
    }
}