
package fr.afcepf.al23.conversion.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al23.conversion.service package. 
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

    private final static QName _GetTauxChange_QNAME = new QName("http://service.conversion.al23.afcepf.fr/", "getTauxChange");
    private final static QName _Conversion_QNAME = new QName("http://service.conversion.al23.afcepf.fr/", "conversion");
    private final static QName _ConversionResponse_QNAME = new QName("http://service.conversion.al23.afcepf.fr/", "conversionResponse");
    private final static QName _GetTauxChangeResponse_QNAME = new QName("http://service.conversion.al23.afcepf.fr/", "getTauxChangeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.conversion.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConversionResponse }
     * 
     */
    public ConversionResponse createConversionResponse() {
        return new ConversionResponse();
    }

    /**
     * Create an instance of {@link Conversion }
     * 
     */
    public Conversion createConversion() {
        return new Conversion();
    }

    /**
     * Create an instance of {@link GetTauxChangeResponse }
     * 
     */
    public GetTauxChangeResponse createGetTauxChangeResponse() {
        return new GetTauxChangeResponse();
    }

    /**
     * Create an instance of {@link GetTauxChange }
     * 
     */
    public GetTauxChange createGetTauxChange() {
        return new GetTauxChange();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTauxChange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.conversion.al23.afcepf.fr/", name = "getTauxChange")
    public JAXBElement<GetTauxChange> createGetTauxChange(GetTauxChange value) {
        return new JAXBElement<GetTauxChange>(_GetTauxChange_QNAME, GetTauxChange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conversion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.conversion.al23.afcepf.fr/", name = "conversion")
    public JAXBElement<Conversion> createConversion(Conversion value) {
        return new JAXBElement<Conversion>(_Conversion_QNAME, Conversion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.conversion.al23.afcepf.fr/", name = "conversionResponse")
    public JAXBElement<ConversionResponse> createConversionResponse(ConversionResponse value) {
        return new JAXBElement<ConversionResponse>(_ConversionResponse_QNAME, ConversionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTauxChangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.conversion.al23.afcepf.fr/", name = "getTauxChangeResponse")
    public JAXBElement<GetTauxChangeResponse> createGetTauxChangeResponse(GetTauxChangeResponse value) {
        return new JAXBElement<GetTauxChangeResponse>(_GetTauxChangeResponse_QNAME, GetTauxChangeResponse.class, null, value);
    }

}
