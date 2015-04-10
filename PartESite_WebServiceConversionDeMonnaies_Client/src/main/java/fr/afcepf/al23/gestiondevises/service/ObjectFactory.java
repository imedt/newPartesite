
package fr.afcepf.al23.gestiondevises.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al23.gestiondevises.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCurrencyResponse_QNAME = new QName("http://service.gestiondevises.al23.afcepf.fr/", "getCurrencyResponse");
    private final static QName _GetCurrency_QNAME = new QName("http://service.gestiondevises.al23.afcepf.fr/", "getCurrency");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.gestiondevises.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrency }
     * 
     */
    public GetCurrency createGetCurrency() {
        return new GetCurrency();
    }

    /**
     * Create an instance of {@link GetCurrencyResponse }
     * 
     */
    public GetCurrencyResponse createGetCurrencyResponse() {
        return new GetCurrencyResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gestiondevises.al23.afcepf.fr/", name = "getCurrencyResponse")
    public JAXBElement<GetCurrencyResponse> createGetCurrencyResponse(GetCurrencyResponse value) {
        return new JAXBElement<GetCurrencyResponse>(_GetCurrencyResponse_QNAME, GetCurrencyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gestiondevises.al23.afcepf.fr/", name = "getCurrency")
    public JAXBElement<GetCurrency> createGetCurrency(GetCurrency value) {
        return new JAXBElement<GetCurrency>(_GetCurrency_QNAME, GetCurrency.class, null, value);
    }

}
