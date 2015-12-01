package com.brix.tc.zip.xml;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tyrone on 11/30/2015.
 */
public class ZipXmlGeneratorTest {

    @Test
    public void testGenerateXML() throws Exception {

        // set up
        byte[] expected = IOUtils.toByteArray(ZipXmlGeneratorTest.class.getResourceAsStream("expected.xml"));
        List<String> zipRanges = new ArrayList<String>(1);
        zipRanges.add("00000-00001");

        // exercise test
        ZipXmlGenerator zipXmlGenerator = new ZipXmlGenerator();
        byte[] actual = zipXmlGenerator.generateXML(zipRanges);

        //verify
        assertArrayEquals(expected, actual);
    }
}