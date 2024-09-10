package org.tempuri;

public class EFMS_VendorRegistrationSoapProxy implements org.tempuri.EFMS_VendorRegistrationSoap {
  private String _endpoint = null;
  private org.tempuri.EFMS_VendorRegistrationSoap eFMS_VendorRegistrationSoap = null;
  
  public EFMS_VendorRegistrationSoapProxy() {
    _initEFMS_VendorRegistrationSoapProxy();
  }
  
  public EFMS_VendorRegistrationSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEFMS_VendorRegistrationSoapProxy();
  }
  
  private void _initEFMS_VendorRegistrationSoapProxy() {
    try {
      eFMS_VendorRegistrationSoap = (new org.tempuri.EFMS_VendorRegistrationLocator()).getEFMS_VendorRegistrationSoap();
      if (eFMS_VendorRegistrationSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eFMS_VendorRegistrationSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eFMS_VendorRegistrationSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eFMS_VendorRegistrationSoap != null)
      ((javax.xml.rpc.Stub)eFMS_VendorRegistrationSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.EFMS_VendorRegistrationSoap getEFMS_VendorRegistrationSoap() {
    if (eFMS_VendorRegistrationSoap == null)
      _initEFMS_VendorRegistrationSoapProxy();
    return eFMS_VendorRegistrationSoap;
  }
  
  public java.lang.String vendorRegistration(java.lang.String parameters) throws java.rmi.RemoteException{
    if (eFMS_VendorRegistrationSoap == null)
      _initEFMS_VendorRegistrationSoapProxy();
    return eFMS_VendorRegistrationSoap.vendorRegistration(parameters);
  }
  
  
}