
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conversion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montantHTAvantConversion" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deviseSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviseCible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversion", propOrder = {
    "montantHTAvantConversion",
    "deviseSource",
    "deviseCible"
})
public class Conversion {

    protected double montantHTAvantConversion;
    protected String deviseSource;
    protected String deviseCible;

    /**
     * Gets the value of the montantHTAvantConversion property.
     * 
     */
    public double getMontantHTAvantConversion() {
        return montantHTAvantConversion;
    }

    /**
     * Sets the value of the montantHTAvantConversion property.
     * 
     */
    public void setMontantHTAvantConversion(double value) {
        this.montantHTAvantConversion = value;
    }

    /**
     * Gets the value of the deviseSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviseSource() {
        return deviseSource;
    }

    /**
     * Sets the value of the deviseSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviseSource(String value) {
        this.deviseSource = value;
    }

    /**
     * Gets the value of the deviseCible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviseCible() {
        return deviseCible;
    }

    /**
     * Sets the value of the deviseCible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviseCible(String value) {
        this.deviseCible = value;
    }

}
