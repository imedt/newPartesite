
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applyTvaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applyTvaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montantTTC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applyTvaResponse", propOrder = {
    "montantTTC"
})
public class ApplyTvaResponse {

    protected double montantTTC;

    /**
     * Gets the value of the montantTTC property.
     * 
     */
    public double getMontantTTC() {
        return montantTTC;
    }

    /**
     * Sets the value of the montantTTC property.
     * 
     */
    public void setMontantTTC(double value) {
        this.montantTTC = value;
    }

}
