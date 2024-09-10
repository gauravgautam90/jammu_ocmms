/**
 * E_TFMS_BalanceCheckLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
 package org.tempuri;

public class E_TFMS_BalanceCheckLocator extends org.apache.axis.client.Service implements org.tempuri.E_TFMS_BalanceCheck {

    public E_TFMS_BalanceCheckLocator() {
    }


    public E_TFMS_BalanceCheckLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public E_TFMS_BalanceCheckLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for E_TFMS_BalanceCheckSoap
   private java.lang.String E_TFMS_BalanceCheckSoap_address = "https://www.techprocess.in/e_TFMS_Service/E_TFMS_BalanceCheck.asmx";

    public java.lang.String getE_TFMS_BalanceCheckSoapAddress() {
        return E_TFMS_BalanceCheckSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String E_TFMS_BalanceCheckSoapWSDDServiceName = "E_TFMS_BalanceCheckSoap";

    public java.lang.String getE_TFMS_BalanceCheckSoapWSDDServiceName() {
        return E_TFMS_BalanceCheckSoapWSDDServiceName;
    }

    public void setE_TFMS_BalanceCheckSoapWSDDServiceName(java.lang.String name) {
        E_TFMS_BalanceCheckSoapWSDDServiceName = name;
    }

    public org.tempuri.E_TFMS_BalanceCheckSoap getE_TFMS_BalanceCheckSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(E_TFMS_BalanceCheckSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getE_TFMS_BalanceCheckSoap(endpoint);
    }

    public org.tempuri.E_TFMS_BalanceCheckSoap getE_TFMS_BalanceCheckSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.E_TFMS_BalanceCheckSoapStub _stub = new org.tempuri.E_TFMS_BalanceCheckSoapStub(portAddress, this);
            _stub.setPortName(getE_TFMS_BalanceCheckSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setE_TFMS_BalanceCheckSoapEndpointAddress(java.lang.String address) {
        E_TFMS_BalanceCheckSoap_address = address;
    }


    // Use to get a proxy class for E_TFMS_BalanceCheckSoap12
    private java.lang.String E_TFMS_BalanceCheckSoap12_address = "https://www.tpsl.co.in/EFMS_Services/E_TFMS_BalanceCheck.asmx";

    public java.lang.String getE_TFMS_BalanceCheckSoap12Address() {
        return E_TFMS_BalanceCheckSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String E_TFMS_BalanceCheckSoap12WSDDServiceName = "E_TFMS_BalanceCheckSoap12";

    public java.lang.String getE_TFMS_BalanceCheckSoap12WSDDServiceName() {
        return E_TFMS_BalanceCheckSoap12WSDDServiceName;
    }

    public void setE_TFMS_BalanceCheckSoap12WSDDServiceName(java.lang.String name) {
        E_TFMS_BalanceCheckSoap12WSDDServiceName = name;
    }

    public org.tempuri.E_TFMS_BalanceCheckSoap getE_TFMS_BalanceCheckSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(E_TFMS_BalanceCheckSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getE_TFMS_BalanceCheckSoap12(endpoint);
    }

    public org.tempuri.E_TFMS_BalanceCheckSoap getE_TFMS_BalanceCheckSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.E_TFMS_BalanceCheckSoap12Stub _stub = new org.tempuri.E_TFMS_BalanceCheckSoap12Stub(portAddress, this);
            _stub.setPortName(getE_TFMS_BalanceCheckSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setE_TFMS_BalanceCheckSoap12EndpointAddress(java.lang.String address) {
        E_TFMS_BalanceCheckSoap12_address = address;
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
            if (org.tempuri.E_TFMS_BalanceCheckSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.E_TFMS_BalanceCheckSoapStub _stub = new org.tempuri.E_TFMS_BalanceCheckSoapStub(new java.net.URL(E_TFMS_BalanceCheckSoap_address), this);
                _stub.setPortName(getE_TFMS_BalanceCheckSoapWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.E_TFMS_BalanceCheckSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.E_TFMS_BalanceCheckSoap12Stub _stub = new org.tempuri.E_TFMS_BalanceCheckSoap12Stub(new java.net.URL(E_TFMS_BalanceCheckSoap12_address), this);
                _stub.setPortName(getE_TFMS_BalanceCheckSoap12WSDDServiceName());
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
        if ("E_TFMS_BalanceCheckSoap".equals(inputPortName)) {
            return getE_TFMS_BalanceCheckSoap();
        }
        else if ("E_TFMS_BalanceCheckSoap12".equals(inputPortName)) {
            return getE_TFMS_BalanceCheckSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "E_TFMS_BalanceCheck");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "E_TFMS_BalanceCheckSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "E_TFMS_BalanceCheckSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("E_TFMS_BalanceCheckSoap".equals(portName)) {
            setE_TFMS_BalanceCheckSoapEndpointAddress(address);
        }
        else 
if ("E_TFMS_BalanceCheckSoap12".equals(portName)) {
            setE_TFMS_BalanceCheckSoap12EndpointAddress(address);
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
