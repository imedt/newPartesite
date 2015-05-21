
package fr.afcepf.al23.conversion.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConversionImplService", targetNamespace = "http://service.conversion.al23.afcepf.fr/", wsdlLocation = "http://localhost:9595/Serviceweb/ConversionImpl?wsdl")
public class ConversionImplService
    extends Service
{

    private final static URL CONVERSIONIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONVERSIONIMPLSERVICE_EXCEPTION;
    private final static QName CONVERSIONIMPLSERVICE_QNAME = new QName("http://service.conversion.al23.afcepf.fr/", "ConversionImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9595/Serviceweb/ConversionImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONVERSIONIMPLSERVICE_WSDL_LOCATION = url;
        CONVERSIONIMPLSERVICE_EXCEPTION = e;
    }

    public ConversionImplService() {
        super(__getWsdlLocation(), CONVERSIONIMPLSERVICE_QNAME);
    }

    public ConversionImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONVERSIONIMPLSERVICE_QNAME, features);
    }

    public ConversionImplService(URL wsdlLocation) {
        super(wsdlLocation, CONVERSIONIMPLSERVICE_QNAME);
    }

    public ConversionImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONVERSIONIMPLSERVICE_QNAME, features);
    }

    public ConversionImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConversionImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IConversion
     */
    @WebEndpoint(name = "ConversionImplPort")
    public IConversion getConversionImplPort() {
        return super.getPort(new QName("http://service.conversion.al23.afcepf.fr/", "ConversionImplPort"), IConversion.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IConversion
     */
    @WebEndpoint(name = "ConversionImplPort")
    public IConversion getConversionImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.conversion.al23.afcepf.fr/", "ConversionImplPort"), IConversion.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONVERSIONIMPLSERVICE_EXCEPTION!= null) {
            throw CONVERSIONIMPLSERVICE_EXCEPTION;
        }
        return CONVERSIONIMPLSERVICE_WSDL_LOCATION;
    }

}
