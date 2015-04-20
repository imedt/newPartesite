
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour conversion complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété montantHTAvantConversion.
     * 
     */
    public double getMontantHTAvantConversion() {
        return montantHTAvantConversion;
    }

    /**
     * Définit la valeur de la propriété montantHTAvantConversion.
     * 
     */
    public void setMontantHTAvantConversion(double value) {
        this.montantHTAvantConversion = value;
    }

    /**
     * Obtient la valeur de la propriété deviseSource.
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
     * Définit la valeur de la propriété deviseSource.
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
     * Obtient la valeur de la propriété deviseCible.
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
     * Définit la valeur de la propriété deviseCible.
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
