
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conversionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conversionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montantHTApresConversion" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversionResponse", propOrder = {
    "montantHTApresConversion"
})
public class ConversionResponse {

    protected double montantHTApresConversion;

    /**
     * Gets the value of the montantHTApresConversion property.
     * 
     */
    public double getMontantHTApresConversion() {
        return montantHTApresConversion;
    }

    /**
     * Sets the value of the montantHTApresConversion property.
     * 
     */
    public void setMontantHTApresConversion(double value) {
        this.montantHTApresConversion = value;
    }

}
