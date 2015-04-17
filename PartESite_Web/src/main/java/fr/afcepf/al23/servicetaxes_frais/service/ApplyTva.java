
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applyTva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applyTva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montantHT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxTVA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxCommission" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applyTva", propOrder = {
    "montantHT",
    "tauxTVA",
    "tauxCommission"
})
public class ApplyTva {

    protected double montantHT;
    protected double tauxTVA;
    protected double tauxCommission;

    /**
     * Gets the value of the montantHT property.
     * 
     */
    public double getMontantHT() {
        return montantHT;
    }

    /**
     * Sets the value of the montantHT property.
     * 
     */
    public void setMontantHT(double value) {
        this.montantHT = value;
    }

    /**
     * Gets the value of the tauxTVA property.
     * 
     */
    public double getTauxTVA() {
        return tauxTVA;
    }

    /**
     * Sets the value of the tauxTVA property.
     * 
     */
    public void setTauxTVA(double value) {
        this.tauxTVA = value;
    }

    /**
     * Gets the value of the tauxCommission property.
     * 
     */
    public double getTauxCommission() {
        return tauxCommission;
    }

    /**
     * Sets the value of the tauxCommission property.
     * 
     */
    public void setTauxCommission(double value) {
        this.tauxCommission = value;
    }

}
