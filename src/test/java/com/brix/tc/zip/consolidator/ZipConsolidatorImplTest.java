package com.brix.tc.zip.consolidator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tyrone on 11/26/2015.
 */
public class ZipConsolidatorImplTest {

    @Test
    public void testConsolidateZipCodes() throws Exception {
        // test set up
        String[] input = new String[]{"00000", "06412-06578", "99999", "00001", "99998", "06579", "00005"};
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00001");
        expected.add("00005");
        expected.add("06412-06579");
        expected.add("99998-99999");

        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }

    @Test
    public void testConsolidateZipCodes2() throws Exception {
        // test set up
        String[] input = new String[]{"00000", "00001", "00002", "00003", "00004", "00005", "00006"};
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00006");


        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }

    @Test
    public void testConsolidateZipCodes3() throws Exception {
        // test set up
        String[] input = new String[]{"00006", "00005", "00004", "00003", "00002", "00001", "00000"};
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00006");


        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }

    @Test
    public void testConsolidateZipCodes4() throws Exception {
        // test set up
        String[] input = new String[]{"00000", "00001", "00002", "00004", "00005", "00006"};
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00002");
        expected.add("00004-00006");

        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }

    @Test
    public void testConsolidateZipCodes5() throws Exception {
        // test set up
        String[] input = new String[]{"00000-00003", "00002-00005", "00006", "06544-06600", "06601", "77777"};
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00006");
        expected.add("06544-06601");
        expected.add("77777");

        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }

    @Test
    public void testConsolidateZipCodes6() throws Exception {
        // test set up
        String[] input = new String[]{"77777", "00000-00003","06544-06600", "00002-00005", "06601", "00006" };
        List<String> expected = new ArrayList<String>();
        expected.add("00000-00006");
        expected.add("06544-06601");
        expected.add("77777");

        // exercise test
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);

        // verify
        assertEquals(expected, output);
    }
}