
package localhost._8080.ode.processes.conversionprocess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
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
@XmlType(name = "", propOrder = {
    "montantTTC"
})
@XmlRootElement(name = "ConversionProcessResponse")
public class ConversionProcessResponse {

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
