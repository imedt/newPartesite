
package fr.afcepf.al23.servicetaxes_frais.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getAllCountriesResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getAllCountriesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coutryList" type="{http://service.servicetaxes_frais.al23.afcepf.fr/}country" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllCountriesResponse", propOrder = {
    "coutryList"
})
public class GetAllCountriesResponse {

    protected List<Country> coutryList;

    /**
     * Gets the value of the coutryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coutryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoutryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Country }
     * 
     * 
     */
    public List<Country> getCoutryList() {
        if (coutryList == null) {
            coutryList = new ArrayList<Country>();
        }
        return this.coutryList;
    }

}
