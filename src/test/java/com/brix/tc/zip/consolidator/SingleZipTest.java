package com.brix.tc.zip.consolidator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tyrone on 11/26/2015.
 */
public class SingleZipTest {

    @Test
    public void test() {

        ZipRange singleZip = new SingleZip("06412");
        assertEquals("06412", singleZip.getStartRange());
        assertEquals("06412", singleZip.getEndRange());

        ZipRange lower = new SingleZip("06411");
        assertEquals(1, singleZip.compareTo(lower));

        ZipRange higher = new SingleZip("06413");
        assertEquals(-1, singleZip.compareTo(higher));

        ZipRange same = new SingleZip("06412");
        assertEquals(0, singleZip.compareTo(same));
    }

}