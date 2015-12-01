package com.brix.tc.zip.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tyrone on 11/30/2015.
 */
public class ZipCodeTxtGenerator implements ZipCodeFileGenerator {

    @Override
    public byte[] generateFile(List<String> zipRanges) throws ZipFileGeneratorException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (String zipRange : zipRanges) {
            writeToByteArray(byteArrayOutputStream, zipRange);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void writeToByteArray(ByteArrayOutputStream byteArrayOutputStream, String zipRange) throws ZipFileGeneratorException {
        try {
            byteArrayOutputStream.write(zipRange.getBytes());
            byteArrayOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            throw new ZipFileGeneratorException(e);
        }
    }
}
