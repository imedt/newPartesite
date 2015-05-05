
package localhost._8080.ode.processes.conversionprocess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="idPays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="montantHT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="commission" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deviseSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviseCible" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isHT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "idPays",
    "montantHT",
    "commission",
    "deviseSource",
    "deviseCible",
    "isHT"
})
@XmlRootElement(name = "ConversionProcessRequest")
public class ConversionProcessRequest {

    protected int idPays;
    protected double montantHT;
    protected double commission;
    @XmlElement(required = true)
    protected String deviseSource;
    @XmlElement(required = true)
    protected String deviseCible;
    protected boolean isHT;

    /**
     * Obtient la valeur de la propriété idPays.
     * 
     */
    public int getIdPays() {
        return idPays;
    }

    /**
     * Définit la valeur de la propriété idPays.
     * 
     */
    public void setIdPays(int value) {
        this.idPays = value;
    }

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
     * Obtient la valeur de la propriété commission.
     * 
     */
    public double getCommission() {
        return commission;
    }

    /**
     * Définit la valeur de la propriété commission.
     * 
     */
    public void setCommission(double value) {
        this.commission = value;
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

    /**
     * Obtient la valeur de la propriété isHT.
     * 
     */
    public boolean isIsHT() {
        return isHT;
    }

    /**
     * Définit la valeur de la propriété isHT.
     * 
     */
    public void setIsHT(boolean value) {
        this.isHT = value;
    }

}
