package com.brix.tc.zip.main;

import com.brix.tc.zip.consolidator.ZipConsolidator;
import com.brix.tc.zip.consolidator.ZipConsolidatorImpl;
import com.brix.tc.zip.file.ZipCodeFileGenerator;
import com.brix.tc.zip.file.ZipFileGeneratorException;
import com.brix.tc.zip.file.ZipCodeFileGeneratorFactory;

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
        if (!fileExists(args[0])) {
            out.println("Input file '" + args[0] + "' does not exist");
            return;
        }

        String[] zipArray = readInputFile(args[0]);
        List<String> consolidatedZipCodes = consolidateZipCodes(zipArray);
        byte[] byteArray = generateFile(consolidatedZipCodes, args[1]);
        writeOutputFile(args[1], byteArray);
    }

    private static boolean fileExists(String arg) {
        File file = new File(arg);
        return  file.exists() && !file.isDirectory() ;
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

    private static List<String> consolidateZipCodes(String[] zipArray) {
        out.println("Consolidating zip codes...");
        ZipConsolidator zipConsolidator = new ZipConsolidatorImpl();
        out.println("Zip codes consolidated.");
        return zipConsolidator.consolidateZipCodes(zipArray);
    }

    private static byte[] generateFile(List<String> consolidatedZipCodes, String filename) {
        out.println("Generating output file data...");
        ZipCodeFileGeneratorFactory zipCodeFileGeneratorFactory = new ZipCodeFileGeneratorFactory();
        ZipCodeFileGenerator zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator(filename);
        byte[] byteArray = new byte[0];
        try {
            byteArray = zipCodeFileGenerator.generateFile(consolidatedZipCodes);
        } catch (ZipFileGeneratorException e) {
            e.printStackTrace();
            System.exit(1);
        }
        out.println("Output file data generated.");
        return byteArray;
    }

    private static void writeOutputFile(String arg, byte[] xmlByteArray) {
        out.println("Writing output file to disk...");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(arg);
            fileOutputStream.write(xmlByteArray);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        out.println("Output file '" + arg + "' written.");
    }


}
