
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

    private final static QName _ReturnChangeByDevises_QNAME = new QName("http://service.gestiondevises.al23.afcepf.fr/", "returnChangeByDevises");
    private final static QName _ReturnChangeByDevisesResponse_QNAME = new QName("http://service.gestiondevises.al23.afcepf.fr/", "returnChangeByDevisesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.gestiondevises.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnChangeByDevisesResponse }
     * 
     */
    public ReturnChangeByDevisesResponse createReturnChangeByDevisesResponse() {
        return new ReturnChangeByDevisesResponse();
    }

    /**
     * Create an instance of {@link ReturnChangeByDevises }
     * 
     */
    public ReturnChangeByDevises createReturnChangeByDevises() {
        return new ReturnChangeByDevises();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnChangeByDevises }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gestiondevises.al23.afcepf.fr/", name = "returnChangeByDevises")
    public JAXBElement<ReturnChangeByDevises> createReturnChangeByDevises(ReturnChangeByDevises value) {
        return new JAXBElement<ReturnChangeByDevises>(_ReturnChangeByDevises_QNAME, ReturnChangeByDevises.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnChangeByDevisesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gestiondevises.al23.afcepf.fr/", name = "returnChangeByDevisesResponse")
    public JAXBElement<ReturnChangeByDevisesResponse> createReturnChangeByDevisesResponse(ReturnChangeByDevisesResponse value) {
        return new JAXBElement<ReturnChangeByDevisesResponse>(_ReturnChangeByDevisesResponse_QNAME, ReturnChangeByDevisesResponse.class, null, value);
    }

}
