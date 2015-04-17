
package fr.afcepf.al23.servicetaxes_frais.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al23.servicetaxes_frais.service package. 
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

    private final static QName _ReturnTvaCountry_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "returnTvaCountry");
    private final static QName _ApplyTva_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "applyTva");
    private final static QName _ApplyTvaResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "applyTvaResponse");
    private final static QName _ReturnTvaCountryResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "returnTvaCountryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.servicetaxes_frais.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnTvaCountry }
     * 
     */
    public ReturnTvaCountry createReturnTvaCountry() {
        return new ReturnTvaCountry();
    }

    /**
     * Create an instance of {@link ApplyTva }
     * 
     */
    public ApplyTva createApplyTva() {
        return new ApplyTva();
    }

    /**
     * Create an instance of {@link ApplyTvaResponse }
     * 
     */
    public ApplyTvaResponse createApplyTvaResponse() {
        return new ApplyTvaResponse();
    }

    /**
     * Create an instance of {@link ReturnTvaCountryResponse }
     * 
     */
    public ReturnTvaCountryResponse createReturnTvaCountryResponse() {
        return new ReturnTvaCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnTvaCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "returnTvaCountry")
    public JAXBElement<ReturnTvaCountry> createReturnTvaCountry(ReturnTvaCountry value) {
        return new JAXBElement<ReturnTvaCountry>(_ReturnTvaCountry_QNAME, ReturnTvaCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyTva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "applyTva")
    public JAXBElement<ApplyTva> createApplyTva(ApplyTva value) {
        return new JAXBElement<ApplyTva>(_ApplyTva_QNAME, ApplyTva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyTvaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "applyTvaResponse")
    public JAXBElement<ApplyTvaResponse> createApplyTvaResponse(ApplyTvaResponse value) {
        return new JAXBElement<ApplyTvaResponse>(_ApplyTvaResponse_QNAME, ApplyTvaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnTvaCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "returnTvaCountryResponse")
    public JAXBElement<ReturnTvaCountryResponse> createReturnTvaCountryResponse(ReturnTvaCountryResponse value) {
        return new JAXBElement<ReturnTvaCountryResponse>(_ReturnTvaCountryResponse_QNAME, ReturnTvaCountryResponse.class, null, value);
    }

}
