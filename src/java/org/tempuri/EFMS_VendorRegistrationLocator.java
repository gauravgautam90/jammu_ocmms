/**
 * EFMS_VendorRegistrationLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class EFMS_VendorRegistrationLocator extends org.apache.axis.client.Service implements org.tempuri.EFMS_VendorRegistration {

    public EFMS_VendorRegistrationLocator() {
    }


    public EFMS_VendorRegistrationLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EFMS_VendorRegistrationLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EFMS_VendorRegistrationSoap
    private java.lang.String EFMS_VendorRegistrationSoap_address = "https://www.techprocess.in/e_TFMS_Service/EFMS_VendorRegistration.asmx";

    public java.lang.String getEFMS_VendorRegistrationSoapAddress() {
        return EFMS_VendorRegistrationSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EFMS_VendorRegistrationSoapWSDDServiceName = "EFMS_VendorRegistrationSoap";

    public java.lang.String getEFMS_VendorRegistrationSoapWSDDServiceName() {
        return EFMS_VendorRegistrationSoapWSDDServiceName;
    }

    public void setEFMS_VendorRegistrationSoapWSDDServiceName(java.lang.String name) {
        EFMS_VendorRegistrationSoapWSDDServiceName = name;
    }

    public org.tempuri.EFMS_VendorRegistrationSoap getEFMS_VendorRegistrationSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EFMS_VendorRegistrationSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEFMS_VendorRegistrationSoap(endpoint);
    }

    public org.tempuri.EFMS_VendorRegistrationSoap getEFMS_VendorRegistrationSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.EFMS_VendorRegistrationSoapStub _stub = new org.tempuri.EFMS_VendorRegistrationSoapStub(portAddress, this);
            _stub.setPortName(getEFMS_VendorRegistrationSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEFMS_VendorRegistrationSoapEndpointAddress(java.lang.String address) {
        EFMS_VendorRegistrationSoap_address = address;
    }


    // Use to get a proxy class for EFMS_VendorRegistrationSoap12
    private java.lang.String EFMS_VendorRegistrationSoap12_address = "http://www.techprocess.in/e_TFMS_Service/EFMS_VendorRegistration.asmx";

    public java.lang.String getEFMS_VendorRegistrationSoap12Address() {
        return EFMS_VendorRegistrationSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EFMS_VendorRegistrationSoap12WSDDServiceName = "EFMS_VendorRegistrationSoap12";

    public java.lang.String getEFMS_VendorRegistrationSoap12WSDDServiceName() {
        return EFMS_VendorRegistrationSoap12WSDDServiceName;
    }

    public void setEFMS_VendorRegistrationSoap12WSDDServiceName(java.lang.String name) {
        EFMS_VendorRegistrationSoap12WSDDServiceName = name;
    }

    public org.tempuri.EFMS_VendorRegistrationSoap getEFMS_VendorRegistrationSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EFMS_VendorRegistrationSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEFMS_VendorRegistrationSoap12(endpoint);
    }

    public org.tempuri.EFMS_VendorRegistrationSoap getEFMS_VendorRegistrationSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.EFMS_VendorRegistrationSoap12Stub _stub = new org.tempuri.EFMS_VendorRegistrationSoap12Stub(portAddress, this);
            _stub.setPortName(getEFMS_VendorRegistrationSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEFMS_VendorRegistrationSoap12EndpointAddress(java.lang.String address) {
        EFMS_VendorRegistrationSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.EFMS_VendorRegistrationSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.EFMS_VendorRegistrationSoapStub _stub = new org.tempuri.EFMS_VendorRegistrationSoapStub(new java.net.URL(EFMS_VendorRegistrationSoap_address), this);
                _stub.setPortName(getEFMS_VendorRegistrationSoapWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.EFMS_VendorRegistrationSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.EFMS_VendorRegistrationSoap12Stub _stub = new org.tempuri.EFMS_VendorRegistrationSoap12Stub(new java.net.URL(EFMS_VendorRegistrationSoap12_address), this);
                _stub.setPortName(getEFMS_VendorRegistrationSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EFMS_VendorRegistrationSoap".equals(inputPortName)) {
            return getEFMS_VendorRegistrationSoap();
        }
        else if ("EFMS_VendorRegistrationSoap12".equals(inputPortName)) {
            return getEFMS_VendorRegistrationSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "EFMS_VendorRegistration");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "EFMS_VendorRegistrationSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "EFMS_VendorRegistrationSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EFMS_VendorRegistrationSoap".equals(portName)) {
            setEFMS_VendorRegistrationSoapEndpointAddress(address);
        }
        else 
if ("EFMS_VendorRegistrationSoap12".equals(portName)) {
            setEFMS_VendorRegistrationSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
