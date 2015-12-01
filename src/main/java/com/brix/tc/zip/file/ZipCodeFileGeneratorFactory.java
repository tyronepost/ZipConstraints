package com.brix.tc.zip.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyrone on 11/30/2015.
 */
public class ZipCodeFileGeneratorFactory {

    private final Pattern XMLPATTERN = Pattern.compile("^[:,\\w,\\\\,/,.,-]+\\.xml$");

    public ZipCodeFileGenerator makeZipFileGenerator(String filename) {
        Matcher matcher = XMLPATTERN.matcher(filename);
        if (matcher.matches()) {
            return new ZipCodeXmlGenerator();
        }
        return new ZipCodeTxtGenerator();
    }
}
