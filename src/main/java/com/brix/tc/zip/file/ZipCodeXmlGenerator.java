package com.brix.tc.zip.file;

import com.brix.tc.zip.xsd.ZipConstraints;

import static com.brix.tc.zip.xsd.ZipConstraints.ZIPConstraint;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyrone on 11/29/2015.
 */
public class ZipCodeXmlGenerator implements ZipCodeFileGenerator {

    private final Pattern SINGLEREGEX = Pattern.compile("^\\d{5}$");
    private final Pattern MULTIREGEX = Pattern.compile("^\\d{5}-\\d{5}$");

    public byte[] generateFile(List<String> zipRanges) throws ZipFileGeneratorException {

        ZipConstraints zipConstraints = createZipConstraints(zipRanges);
        byte[] xml;
        try {
            Marshaller jaxbMarshaller = createMarshaller();
            xml = marshalXML(zipConstraints, jaxbMarshaller);
        } catch (JAXBException e) {
            throw new ZipFileGeneratorException(e);
        }
        return xml;
    }

    private byte[] marshalXML(ZipConstraints zipConstraints, Marshaller jaxbMarshaller) throws JAXBException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jaxbMarshaller.marshal(zipConstraints, byteArrayOutputStream);
        byte[] xml = byteArrayOutputStream.toByteArray();
        return xml;
    }

    private Marshaller createMarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ZipConstraints.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return jaxbMarshaller;
    }

    private ZipConstraints createZipConstraints(List<String> zipRanges) {
        ZipConstraints zipConstraints = new ZipConstraints();
        for (String zipRange : zipRanges) {
            ZIPConstraint zipConstraint = createZipConstraint(zipRange);
            zipConstraints.getZIPConstraint().add(zipConstraint);
        }
        return zipConstraints;
    }

    private ZIPConstraint createZipConstraint(String zipRange) {
        ZIPConstraint zipConstraint = new ZIPConstraint();
        Matcher singleMatcher = SINGLEREGEX.matcher(zipRange);
        Matcher multiMatcher = MULTIREGEX.matcher(zipRange);
        if (singleMatcher.matches()) {
            zipConstraint.setZIPRangeStart(zipRange);
        } else if (multiMatcher.matches()) {
            setFullZipRange(zipRange, zipConstraint);
        }
        return zipConstraint;
    }

    private void setFullZipRange(String zipRange, ZIPConstraint zipConstraint) {
        String[] zipRangeArr = zipRange.split("-");
        zipConstraint.setZIPRangeStart(zipRangeArr[0]);
        zipConstraint.setZIPRangeEnd(zipRangeArr[1]);
    }

}
