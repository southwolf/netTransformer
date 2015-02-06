//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.01 at 07:57:49 AM EET 
//


package net.itransformers.topologyviewer.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for topology-viewer-confType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topology-viewer-confType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataMatcher" type="{}dataMatcherType" maxOccurs="unbounded"/>
 *         &lt;element name="icon" type="{}iconType" maxOccurs="unbounded"/>
 *         &lt;element name="edgeStroke" type="{}edgeStrokeType" maxOccurs="unbounded"/>
 *         &lt;element name="edgeColor" type="{}edgeColorType" maxOccurs="unbounded"/>
 *         &lt;element name="filters" type="{}filtersType"/>
 *         &lt;element name="hops" type="{}hopsType"/>
 *         &lt;element name="tooltip" type="{}tooltipType" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="rightClickItem" type="{}rightClickItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "topology-viewer-confType", propOrder = {
    "dataMatcher",
    "icon",
    "edgeStroke",
    "edgeColor",
    "filters",
    "hops",
    "tooltip",
    "rightClickItem"
})
public class TopologyViewerConfType {

    @XmlElement(required = true)
    protected List<DataMatcherType> dataMatcher;
    @XmlElement(required = true)
    protected List<IconType> icon;
    @XmlElement(required = true)
    protected List<EdgeStrokeType> edgeStroke;
    @XmlElement(required = true)
    protected List<EdgeColorType> edgeColor;
    @XmlElement(required = true)
    protected FiltersType filters;
    @XmlElement(required = true)
    protected HopsType hops;
    protected List<TooltipType> tooltip;
    protected List<RightClickItemType> rightClickItem;

    /**
     * Gets the value of the dataMatcher property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataMatcher property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataMatcher().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataMatcherType }
     * 
     * 
     */
    public List<DataMatcherType> getDataMatcher() {
        if (dataMatcher == null) {
            dataMatcher = new ArrayList<DataMatcherType>();
        }
        return this.dataMatcher;
    }

    /**
     * Gets the value of the icon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IconType }
     * 
     * 
     */
    public List<IconType> getIcon() {
        if (icon == null) {
            icon = new ArrayList<IconType>();
        }
        return this.icon;
    }

    /**
     * Gets the value of the edgeStroke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edgeStroke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdgeStroke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EdgeStrokeType }
     * 
     * 
     */
    public List<EdgeStrokeType> getEdgeStroke() {
        if (edgeStroke == null) {
            edgeStroke = new ArrayList<EdgeStrokeType>();
        }
        return this.edgeStroke;
    }

    /**
     * Gets the value of the edgeColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edgeColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdgeColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EdgeColorType }
     * 
     * 
     */
    public List<EdgeColorType> getEdgeColor() {
        if (edgeColor == null) {
            edgeColor = new ArrayList<EdgeColorType>();
        }
        return this.edgeColor;
    }

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link FiltersType }
     *     
     */
    public FiltersType getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltersType }
     *     
     */
    public void setFilters(FiltersType value) {
        this.filters = value;
    }

    /**
     * Gets the value of the hops property.
     * 
     * @return
     *     possible object is
     *     {@link HopsType }
     *     
     */
    public HopsType getHops() {
        return hops;
    }

    /**
     * Sets the value of the hops property.
     * 
     * @param value
     *     allowed object is
     *     {@link HopsType }
     *     
     */
    public void setHops(HopsType value) {
        this.hops = value;
    }

    /**
     * Gets the value of the tooltip property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tooltip property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTooltip().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TooltipType }
     * 
     * 
     */
    public List<TooltipType> getTooltip() {
        if (tooltip == null) {
            tooltip = new ArrayList<TooltipType>();
        }
        return this.tooltip;
    }

    /**
     * Gets the value of the rightClickItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rightClickItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRightClickItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RightClickItemType }
     * 
     * 
     */
    public List<RightClickItemType> getRightClickItem() {
        if (rightClickItem == null) {
            rightClickItem = new ArrayList<RightClickItemType>();
        }
        return this.rightClickItem;
    }

}
