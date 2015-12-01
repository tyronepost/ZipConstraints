package com.brix.tc.zip.main;

import com.brix.tc.zip.consolidator.ZipConsolidator;
import com.brix.tc.zip.consolidator.ZipConsolidatorImpl;
import com.brix.tc.zip.file.ZipFileGeneratorException;
import com.brix.tc.zip.file.ZipXmlGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

/**
 * Application for creating a consolidated zip constraints output file
 */
public class ZipConstraintConsolidatorApp {

    public static void main(String[] args) {

        if (args.length == 0) {
            out.println("Input file must be specified.");
            return;
        }
        if (args.length == 1) {
            out.println("Output file must be specified.");
            return;
        }
        if (args.length > 2) {
            out.println("Only two arguments (input file and output file) should be specified");
            return;
        }

        String[] zipArray = readInputFile(args[0]);
        List<String> consolidatedZipCodes = consolidateZipCodes(zipArray);
        byte[] xmlByteArray = generateXML(consolidatedZipCodes);
        writeOutputFile(args[1], xmlByteArray);
    }

    private static byte[] generateXML(List<String> consolidatedZipCodes) {
        ZipXmlGenerator zipXmlGenerator = new ZipXmlGenerator();
        byte[] xml = new byte[0];
        try {
            xml = zipXmlGenerator.generateFile(consolidatedZipCodes);
        } catch (ZipFileGeneratorException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return xml;
    }

    private static List<String> consolidateZipCodes(String[] zipArray) {
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        return zipConsolidator.consolidateZipCodes(zipArray);
    }

    private static void writeOutputFile(String arg, byte[] xmlByteArray) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(arg);
            fileOutputStream.write(xmlByteArray);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String[] readInputFile(String arg) {
        String[] zipArray = new String[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(arg));
            List<String> zipList = new ArrayList<String>();
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                zipList.add(line);
            }
            zipArray = zipList.toArray(new String[zipList.size()]);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return zipArray;
    }
}
