package com.brix.tc.zip.file;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tyrone on 11/30/2015.
 */
public class ZipTxtGeneratorTest {

    @Test
    public void testGenerateFile() throws Exception {
        // set up
        byte[] expected = IOUtils.toByteArray(ZipTxtGeneratorTest.class.getResourceAsStream("expected.tx"));
        List<String> zipRanges = new ArrayList<String>(1);
        zipRanges.add("00000-00001");

        // exercise test
        ZipTxtGenerator zipTxtGenerator = new ZipTxtGenerator();
        byte[] actual = zipTxtGenerator.generateFile(zipRanges);

        //verify
        assertArrayEquals(expected, actual);
    }
}