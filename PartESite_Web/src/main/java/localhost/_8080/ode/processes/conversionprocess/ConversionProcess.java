
package localhost._8080.ode.processes.conversionprocess;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConversionProcess", targetNamespace = "http://localhost:8080/ode/processes/ConversionProcess", wsdlLocation = "http://localhost:8080/ode/processes/ConversionProcess?wsdl")
public class ConversionProcess
    extends Service
{

    private final static URL CONVERSIONPROCESS_WSDL_LOCATION;
    private final static WebServiceException CONVERSIONPROCESS_EXCEPTION;
    private final static QName CONVERSIONPROCESS_QNAME = new QName("http://localhost:8080/ode/processes/ConversionProcess", "ConversionProcess");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ode/processes/ConversionProcess?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONVERSIONPROCESS_WSDL_LOCATION = url;
        CONVERSIONPROCESS_EXCEPTION = e;
    }

    public ConversionProcess() {
        super(__getWsdlLocation(), CONVERSIONPROCESS_QNAME);
    }

    public ConversionProcess(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONVERSIONPROCESS_QNAME, features);
    }

    public ConversionProcess(URL wsdlLocation) {
        super(wsdlLocation, CONVERSIONPROCESS_QNAME);
    }

    public ConversionProcess(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONVERSIONPROCESS_QNAME, features);
    }

    public ConversionProcess(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConversionProcess(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ConversionProcessPortType
     */
    @WebEndpoint(name = "ConversionProcessPort")
    public ConversionProcessPortType getConversionProcessPort() {
        return super.getPort(new QName("http://localhost:8080/ode/processes/ConversionProcess", "ConversionProcessPort"), ConversionProcessPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConversionProcessPortType
     */
    @WebEndpoint(name = "ConversionProcessPort")
    public ConversionProcessPortType getConversionProcessPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost:8080/ode/processes/ConversionProcess", "ConversionProcessPort"), ConversionProcessPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONVERSIONPROCESS_EXCEPTION!= null) {
            throw CONVERSIONPROCESS_EXCEPTION;
        }
        return CONVERSIONPROCESS_WSDL_LOCATION;
    }

}
