package com.brix.tc.zip;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Tyrone on 11/26/2015.
 */
public class ZipRangeFactoryTest {

    @Test
    public void testMakeZipRange() throws Exception {
        ZipRangeFactory zipRangeFactory = new ZipRangeFactory();
        ZipRange zipRange = zipRangeFactory.makeZipRange("06412");
        assertThat(zipRange, instanceOf(SingleZip.class));

        ZipRange zipRange1 = zipRangeFactory.makeZipRange("06412-06443");
        assertThat(zipRange1, instanceOf(MultiZip.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeSingleRangeException() {
        ZipRangeFactory zipRangeFactory = new ZipRangeFactory();
        zipRangeFactory.makeZipRange("064165");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeMultiRangeException() {
        ZipRangeFactory zipRangeFactory = new ZipRangeFactory();
        zipRangeFactory.makeZipRange("06416-0641");
    }
}