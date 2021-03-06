//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.01 at 12:19:40 PM EST 
//


package com.brix.tc.zip.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZIPConstraint" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ZIPRangeEnd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ZIPRangeStart" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zipConstraint"
})
@XmlRootElement(name = "ZipConstraints")
public class ZipConstraints {

    @XmlElement(name = "ZIPConstraint")
    protected List<ZipConstraints.ZIPConstraint> zipConstraint;

    /**
     * Gets the value of the zipConstraint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zipConstraint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZIPConstraint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZipConstraints.ZIPConstraint }
     * 
     * 
     */
    public List<ZipConstraints.ZIPConstraint> getZIPConstraint() {
        if (zipConstraint == null) {
            zipConstraint = new ArrayList<ZipConstraints.ZIPConstraint>();
        }
        return this.zipConstraint;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ZIPRangeEnd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ZIPRangeStart" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zipRangeEnd",
        "zipRangeStart"
    })
    public static class ZIPConstraint {

        @XmlElement(name = "ZIPRangeEnd", required = true)
        protected String zipRangeEnd;
        @XmlElement(name = "ZIPRangeStart", required = true)
        protected String zipRangeStart;

        /**
         * Gets the value of the zipRangeEnd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZIPRangeEnd() {
            return zipRangeEnd;
        }

        /**
         * Sets the value of the zipRangeEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZIPRangeEnd(String value) {
            this.zipRangeEnd = value;
        }

        /**
         * Gets the value of the zipRangeStart property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZIPRangeStart() {
            return zipRangeStart;
        }

        /**
         * Sets the value of the zipRangeStart property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZIPRangeStart(String value) {
            this.zipRangeStart = value;
        }

    }

}
