package com.brix.tc.zip.xml;

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
public class ZipXmlGenerator {

    private final Pattern SINGLEREGEX = Pattern.compile("^\\d{5}$");
    private final Pattern MULTIREGEX = Pattern.compile("^\\d{5}-\\d{5}$");

    public byte[] generateXML(List<String> zipRanges) {

        ZipConstraints zipConstraints = new ZipConstraints();
        for (String zipRange : zipRanges) {
            ZIPConstraint zipConstraint = new ZIPConstraint();
            Matcher singleMatcher = SINGLEREGEX.matcher(zipRange);
            Matcher multiMatcher = MULTIREGEX.matcher(zipRange);

            if (singleMatcher.matches()) {
                zipConstraint.setZIPRangeStart(zipRange);
            } else if (multiMatcher.matches()) {
                String[] zipRangeArr = zipRange.split("-");
                zipConstraint.setZIPRangeStart(zipRangeArr[0]);
                zipConstraint.setZIPRangeEnd(zipRangeArr[1]);
            }
            zipConstraints.getZIPConstraint().add(zipConstraint);
        }


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ZipConstraints.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(zipConstraints, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (JAXBException es) {

        }
        return new byte[0];
    }

}
