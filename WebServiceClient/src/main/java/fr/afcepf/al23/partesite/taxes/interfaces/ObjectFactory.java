
package fr.afcepf.al23.partesite.taxes.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al23.partesite.taxes.interfaces package. 
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

    private final static QName _GetFrais_QNAME = new QName("http://interfaces.taxes.partesite.al23.afcepf.fr/", "getFrais");
    private final static QName _GetFraisResponse_QNAME = new QName("http://interfaces.taxes.partesite.al23.afcepf.fr/", "getFraisResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al23.partesite.taxes.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFrais }
     * 
     */
    public GetFrais createGetFrais() {
        return new GetFrais();
    }

    /**
     * Create an instance of {@link GetFraisResponse }
     * 
     */
    public GetFraisResponse createGetFraisResponse() {
        return new GetFraisResponse();
    }

    /**
     * Create an instance of {@link Frais }
     * 
     */
    public Frais createFrais() {
        return new Frais();
    }

    /**
     * Create an instance of {@link Pays }
     * 
     */
    public Pays createPays() {
        return new Pays();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFrais }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.taxes.partesite.al23.afcepf.fr/", name = "getFrais")
    public JAXBElement<GetFrais> createGetFrais(GetFrais value) {
        return new JAXBElement<GetFrais>(_GetFrais_QNAME, GetFrais.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFraisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.taxes.partesite.al23.afcepf.fr/", name = "getFraisResponse")
    public JAXBElement<GetFraisResponse> createGetFraisResponse(GetFraisResponse value) {
        return new JAXBElement<GetFraisResponse>(_GetFraisResponse_QNAME, GetFraisResponse.class, null, value);
    }

}
