
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTauxChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTauxChange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monnaieSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monnaieCible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTauxChange", propOrder = {
    "monnaieSource",
    "monnaieCible"
})
public class GetTauxChange {

    protected String monnaieSource;
    protected String monnaieCible;

    /**
     * Gets the value of the monnaieSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaieSource() {
        return monnaieSource;
    }

    /**
     * Sets the value of the monnaieSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaieSource(String value) {
        this.monnaieSource = value;
    }

    /**
     * Gets the value of the monnaieCible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaieCible() {
        return monnaieCible;
    }

    /**
     * Sets the value of the monnaieCible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaieCible(String value) {
        this.monnaieCible = value;
    }

}
