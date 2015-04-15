
package fr.afcepf.al23.partesite.taxes.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for frais complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="frais">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paysDestination" type="{http://interfaces.taxes.partesite.al23.afcepf.fr/}pays" minOccurs="0"/>
 *         &lt;element name="paysOrigine" type="{http://interfaces.taxes.partesite.al23.afcepf.fr/}pays" minOccurs="0"/>
 *         &lt;element name="taxes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "frais", propOrder = {
    "id",
    "paysDestination",
    "paysOrigine",
    "taxes"
})
public class Frais {

    protected Integer id;
    protected Pays paysDestination;
    protected Pays paysOrigine;
    protected Integer taxes;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the paysDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Pays }
     *     
     */
    public Pays getPaysDestination() {
        return paysDestination;
    }

    /**
     * Sets the value of the paysDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pays }
     *     
     */
    public void setPaysDestination(Pays value) {
        this.paysDestination = value;
    }

    /**
     * Gets the value of the paysOrigine property.
     * 
     * @return
     *     possible object is
     *     {@link Pays }
     *     
     */
    public Pays getPaysOrigine() {
        return paysOrigine;
    }

    /**
     * Sets the value of the paysOrigine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pays }
     *     
     */
    public void setPaysOrigine(Pays value) {
        this.paysOrigine = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaxes(Integer value) {
        this.taxes = value;
    }

}
