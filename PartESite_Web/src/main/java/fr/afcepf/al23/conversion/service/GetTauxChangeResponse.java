
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTauxChangeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTauxChangeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tauxChange" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTauxChangeResponse", propOrder = {
    "tauxChange"
})
public class GetTauxChangeResponse {

    protected double tauxChange;

    /**
     * Gets the value of the tauxChange property.
     * 
     */
    public double getTauxChange() {
        return tauxChange;
    }

    /**
     * Sets the value of the tauxChange property.
     * 
     */
    public void setTauxChange(double value) {
        this.tauxChange = value;
    }

}
