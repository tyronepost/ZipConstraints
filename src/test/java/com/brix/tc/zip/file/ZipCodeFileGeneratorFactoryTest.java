package com.brix.tc.zip.file;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Tyrone on 12/1/2015.
 */
public class ZipCodeFileGeneratorFactoryTest {

    @Test
    public void testMakeZipFileGenerator() throws Exception {
        ZipCodeFileGeneratorFactory  zipCodeFileGeneratorFactory = new ZipCodeFileGeneratorFactory();

        ZipCodeFileGenerator zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("hello.txt");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeTxtGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("hello");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeTxtGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("hello.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("hello.txt.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("hello-world.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("c:/hello-world.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("c:\\hello-world.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("c:/dir/hello-world.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));

        zipCodeFileGenerator = zipCodeFileGeneratorFactory.makeZipFileGenerator("c:\\dir\\hello-world.xml");
        assertThat(zipCodeFileGenerator, instanceOf(ZipCodeXmlGenerator.class));
    }
}