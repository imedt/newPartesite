
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour applyTvaResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété montantTTC.
     * 
     */
    public double getMontantTTC() {
        return montantTTC;
    }

    /**
     * Définit la valeur de la propriété montantTTC.
     * 
     */
    public void setMontantTTC(double value) {
        this.montantTTC = value;
    }

}
