
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

    private final static QName _FindCountry_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "findCountry");
    private final static QName _ApplyTva_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "applyTva");
    private final static QName _GetAllCountries_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "getAllCountries");
    private final static QName _FindCountryResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "findCountryResponse");
    private final static QName _ReturnTvaCountryResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "returnTvaCountryResponse");
    private final static QName _ApplyTvaResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "applyTvaResponse");
    private final static QName _ReturnTvaCountry_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "returnTvaCountry");
    private final static QName _GetAllCountriesResponse_QNAME = new QName("http://service.servicetaxes_frais.al23.afcepf.fr/", "getAllCountriesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.servicetaxes_frais.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCountryResponse }
     * 
     */
    public FindCountryResponse createFindCountryResponse() {
        return new FindCountryResponse();
    }

    /**
     * Create an instance of {@link ReturnTvaCountryResponse }
     * 
     */
    public ReturnTvaCountryResponse createReturnTvaCountryResponse() {
        return new ReturnTvaCountryResponse();
    }

    /**
     * Create an instance of {@link GetAllCountries }
     * 
     */
    public GetAllCountries createGetAllCountries() {
        return new GetAllCountries();
    }

    /**
     * Create an instance of {@link ApplyTva }
     * 
     */
    public ApplyTva createApplyTva() {
        return new ApplyTva();
    }

    /**
     * Create an instance of {@link FindCountry }
     * 
     */
    public FindCountry createFindCountry() {
        return new FindCountry();
    }

    /**
     * Create an instance of {@link GetAllCountriesResponse }
     * 
     */
    public GetAllCountriesResponse createGetAllCountriesResponse() {
        return new GetAllCountriesResponse();
    }

    /**
     * Create an instance of {@link ReturnTvaCountry }
     * 
     */
    public ReturnTvaCountry createReturnTvaCountry() {
        return new ReturnTvaCountry();
    }

    /**
     * Create an instance of {@link ApplyTvaResponse }
     * 
     */
    public ApplyTvaResponse createApplyTvaResponse() {
        return new ApplyTvaResponse();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "findCountry")
    public JAXBElement<FindCountry> createFindCountry(FindCountry value) {
        return new JAXBElement<FindCountry>(_FindCountry_QNAME, FindCountry.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "getAllCountries")
    public JAXBElement<GetAllCountries> createGetAllCountries(GetAllCountries value) {
        return new JAXBElement<GetAllCountries>(_GetAllCountries_QNAME, GetAllCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "findCountryResponse")
    public JAXBElement<FindCountryResponse> createFindCountryResponse(FindCountryResponse value) {
        return new JAXBElement<FindCountryResponse>(_FindCountryResponse_QNAME, FindCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnTvaCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "returnTvaCountryResponse")
    public JAXBElement<ReturnTvaCountryResponse> createReturnTvaCountryResponse(ReturnTvaCountryResponse value) {
        return new JAXBElement<ReturnTvaCountryResponse>(_ReturnTvaCountryResponse_QNAME, ReturnTvaCountryResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnTvaCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "returnTvaCountry")
    public JAXBElement<ReturnTvaCountry> createReturnTvaCountry(ReturnTvaCountry value) {
        return new JAXBElement<ReturnTvaCountry>(_ReturnTvaCountry_QNAME, ReturnTvaCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.servicetaxes_frais.al23.afcepf.fr/", name = "getAllCountriesResponse")
    public JAXBElement<GetAllCountriesResponse> createGetAllCountriesResponse(GetAllCountriesResponse value) {
        return new JAXBElement<GetAllCountriesResponse>(_GetAllCountriesResponse_QNAME, GetAllCountriesResponse.class, null, value);
    }

}
