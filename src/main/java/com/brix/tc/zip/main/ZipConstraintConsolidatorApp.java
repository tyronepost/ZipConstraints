package com.brix.tc.zip.main;

import com.brix.tc.zip.consolidator.ZipConsolidator;
import com.brix.tc.zip.consolidator.ZipConsolidatorImpl;

import java.util.List;

/**
 * Application for creating a consolidated zip constraints output file
 */
public class ZipConstraintConsolidatorApp {

    public static void main(String[] args) {
        String[] input = new String[]{"00000", "06412-06578", "99999", "00001", "99998", "06579", "00005"};
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        List<String> output = zipConsolidator.consolidateZipCodes(input);
        for (String str : output)
            System.out.println(str);
    }
}
