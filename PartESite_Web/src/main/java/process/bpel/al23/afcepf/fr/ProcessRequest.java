
package process.bpel.al23.afcepf.fr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxTva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tauxCommission" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deviseSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviseCible" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "montant",
    "tauxTva",
    "tauxCommission",
    "deviseSource",
    "deviseCible"
})
@XmlRootElement(name = "ProcessRequest")
public class ProcessRequest {

    protected double montant;
    protected double tauxTva;
    protected double tauxCommission;
    @XmlElement(required = true)
    protected String deviseSource;
    @XmlElement(required = true)
    protected String deviseCible;

    /**
     * Gets the value of the montant property.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Sets the value of the montant property.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

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

    /**
     * Gets the value of the deviseSource property.
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
     * Sets the value of the deviseSource property.
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
     * Gets the value of the deviseCible property.
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
     * Sets the value of the deviseCible property.
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
