
package fr.afcepf.al23.gestiondevises.service;

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
@WebServiceClient(name = "GestionDevisesImplService", targetNamespace = "http://service.gestiondevises.al23.afcepf.fr/", wsdlLocation = "http://localhost:9090/Serviceweb/GestionDevisesImpl?wsdl")
public class GestionDevisesImplService
    extends Service
{

    private final static URL GESTIONDEVISESIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException GESTIONDEVISESIMPLSERVICE_EXCEPTION;
    private final static QName GESTIONDEVISESIMPLSERVICE_QNAME = new QName("http://service.gestiondevises.al23.afcepf.fr/", "GestionDevisesImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/Serviceweb/GestionDevisesImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GESTIONDEVISESIMPLSERVICE_WSDL_LOCATION = url;
        GESTIONDEVISESIMPLSERVICE_EXCEPTION = e;
    }

    public GestionDevisesImplService() {
        super(__getWsdlLocation(), GESTIONDEVISESIMPLSERVICE_QNAME);
    }

    public GestionDevisesImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GESTIONDEVISESIMPLSERVICE_QNAME, features);
    }

    public GestionDevisesImplService(URL wsdlLocation) {
        super(wsdlLocation, GESTIONDEVISESIMPLSERVICE_QNAME);
    }

    public GestionDevisesImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GESTIONDEVISESIMPLSERVICE_QNAME, features);
    }

    public GestionDevisesImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GestionDevisesImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IGestionDevises
     */
    @WebEndpoint(name = "GestionDevisesImplPort")
    public IGestionDevises getGestionDevisesImplPort() {
        return super.getPort(new QName("http://service.gestiondevises.al23.afcepf.fr/", "GestionDevisesImplPort"), IGestionDevises.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IGestionDevises
     */
    @WebEndpoint(name = "GestionDevisesImplPort")
    public IGestionDevises getGestionDevisesImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.gestiondevises.al23.afcepf.fr/", "GestionDevisesImplPort"), IGestionDevises.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GESTIONDEVISESIMPLSERVICE_EXCEPTION!= null) {
            throw GESTIONDEVISESIMPLSERVICE_EXCEPTION;
        }
        return GESTIONDEVISESIMPLSERVICE_WSDL_LOCATION;
    }

}
