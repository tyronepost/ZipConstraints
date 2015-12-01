package com.brix.tc.zip.file;

import java.util.List;

/**
 * Created by Tyrone on 11/30/2015.
 */
public interface ZipCodeFileGenerator {
    byte[] generateFile(List<String> zipRanges) throws ZipFileGeneratorException;
}
