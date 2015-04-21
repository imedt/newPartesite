
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour conversionResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété montantHTApresConversion.
     * 
     */
    public double getMontantHTApresConversion() {
        return montantHTApresConversion;
    }

    /**
     * Définit la valeur de la propriété montantHTApresConversion.
     * 
     */
    public void setMontantHTApresConversion(double value) {
        this.montantHTApresConversion = value;
    }

}
