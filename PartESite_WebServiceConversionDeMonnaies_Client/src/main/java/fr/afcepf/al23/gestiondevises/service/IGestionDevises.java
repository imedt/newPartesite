
package fr.afcepf.al23.gestiondevises.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IGestionDevises", targetNamespace = "http://service.gestiondevises.al23.afcepf.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IGestionDevises {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrency", targetNamespace = "http://service.gestiondevises.al23.afcepf.fr/", className = "fr.afcepf.al23.gestiondevises.service.GetCurrency")
    @ResponseWrapper(localName = "getCurrencyResponse", targetNamespace = "http://service.gestiondevises.al23.afcepf.fr/", className = "fr.afcepf.al23.gestiondevises.service.GetCurrencyResponse")
    public double getCurrency(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}