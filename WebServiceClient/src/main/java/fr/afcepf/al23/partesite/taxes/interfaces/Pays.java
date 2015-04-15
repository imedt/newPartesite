
package fr.afcepf.al23.partesite.taxes.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pays complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pays">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alpha2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alpha3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nomEnGb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomFrFr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pays", propOrder = {
    "alpha2",
    "alpha3",
    "code",
    "id",
    "nomEnGb",
    "nomFrFr"
})
public class Pays {

    protected String alpha2;
    protected String alpha3;
    protected Integer code;
    protected Integer id;
    protected String nomEnGb;
    protected String nomFrFr;

    /**
     * Gets the value of the alpha2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlpha2() {
        return alpha2;
    }

    /**
     * Sets the value of the alpha2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlpha2(String value) {
        this.alpha2 = value;
    }

    /**
     * Gets the value of the alpha3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlpha3() {
        return alpha3;
    }

    /**
     * Sets the value of the alpha3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlpha3(String value) {
        this.alpha3 = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCode(Integer value) {
        this.code = value;
    }

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
     * Gets the value of the nomEnGb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomEnGb() {
        return nomEnGb;
    }

    /**
     * Sets the value of the nomEnGb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomEnGb(String value) {
        this.nomEnGb = value;
    }

    /**
     * Gets the value of the nomFrFr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomFrFr() {
        return nomFrFr;
    }

    /**
     * Sets the value of the nomFrFr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomFrFr(String value) {
        this.nomFrFr = value;
    }

}
