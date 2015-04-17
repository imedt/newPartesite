
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for returnTvaCountryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="returnTvaCountryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tauxTva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnTvaCountryResponse", propOrder = {
    "tauxTva"
})
public class ReturnTvaCountryResponse {

    protected double tauxTva;

    /**
     * Gets the value of the tauxTva property.
     * 
     */
    public double getTauxTva() {
        return tauxTva;
    }

    /**
     * Sets the value of the tauxTva property.
     * 
     */
    public void setTauxTva(double value) {
        this.tauxTva = value;
    }

}
