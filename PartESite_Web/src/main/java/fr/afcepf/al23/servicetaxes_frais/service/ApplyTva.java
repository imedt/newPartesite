
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour applyTva complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété montantHT.
     * 
     */
    public double getMontantHT() {
        return montantHT;
    }

    /**
     * Définit la valeur de la propriété montantHT.
     * 
     */
    public void setMontantHT(double value) {
        this.montantHT = value;
    }

    /**
     * Obtient la valeur de la propriété tauxTVA.
     * 
     */
    public double getTauxTVA() {
        return tauxTVA;
    }

    /**
     * Définit la valeur de la propriété tauxTVA.
     * 
     */
    public void setTauxTVA(double value) {
        this.tauxTVA = value;
    }

    /**
     * Obtient la valeur de la propriété tauxCommission.
     * 
     */
    public double getTauxCommission() {
        return tauxCommission;
    }

    /**
     * Définit la valeur de la propriété tauxCommission.
     * 
     */
    public void setTauxCommission(double value) {
        this.tauxCommission = value;
    }

}
