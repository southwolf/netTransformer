//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.22 at 09:23:11 PM EEST 
//


package net.itransformers.topologyviewer.config.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for forType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="forType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="edge"/>
 *     &lt;enumeration value="node"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "forType")
@XmlEnum
public enum ForType {

    @XmlEnumValue("edge")
    EDGE("edge"),
    @XmlEnumValue("node")
    NODE("node");
    private final String value;

    ForType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ForType fromValue(String v) {
        for (ForType c: ForType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
