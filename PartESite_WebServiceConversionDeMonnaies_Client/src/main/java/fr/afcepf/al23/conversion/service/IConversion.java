
package fr.afcepf.al23.conversion.service;

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
@WebService(name = "IConversion", targetNamespace = "http://service.conversion.al23.afcepf.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IConversion {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(name = "montantHTApresConversion", targetNamespace = "")
    @RequestWrapper(localName = "conversion", targetNamespace = "http://service.conversion.al23.afcepf.fr/", className = "fr.afcepf.al23.conversion.service.Conversion")
    @ResponseWrapper(localName = "conversionResponse", targetNamespace = "http://service.conversion.al23.afcepf.fr/", className = "fr.afcepf.al23.conversion.service.ConversionResponse")
    public double conversion(
        @WebParam(name = "montantHTAvantConversion", targetNamespace = "")
        double arg0,
        @WebParam(name = "DeviseSource", targetNamespace = "")
        String arg1,
        @WebParam(name = "DeviseCible", targetNamespace = "")
        String arg2);

}
