package org.tempuri;
public class E_TFMS_BalanceCheckSoapProxy implements org.tempuri.E_TFMS_BalanceCheckSoap {
  private String _endpoint = null;
  private org.tempuri.E_TFMS_BalanceCheckSoap e_TFMS_BalanceCheckSoap = null;
  
  public E_TFMS_BalanceCheckSoapProxy() {
    _initE_TFMS_BalanceCheckSoapProxy();
  }
  
  public E_TFMS_BalanceCheckSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initE_TFMS_BalanceCheckSoapProxy();
  }
  
  private void _initE_TFMS_BalanceCheckSoapProxy() {
    try {
      e_TFMS_BalanceCheckSoap = (new org.tempuri.E_TFMS_BalanceCheckLocator()).getE_TFMS_BalanceCheckSoap();
      if (e_TFMS_BalanceCheckSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)e_TFMS_BalanceCheckSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)e_TFMS_BalanceCheckSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (e_TFMS_BalanceCheckSoap != null)
      ((javax.xml.rpc.Stub)e_TFMS_BalanceCheckSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.E_TFMS_BalanceCheckSoap getE_TFMS_BalanceCheckSoap() {
    if (e_TFMS_BalanceCheckSoap == null)
      _initE_TFMS_BalanceCheckSoapProxy();
    return e_TFMS_BalanceCheckSoap;
  }
  
  public java.lang.String balanceCheck(java.lang.String parameters) throws java.rmi.RemoteException{
    if (e_TFMS_BalanceCheckSoap == null)
      _initE_TFMS_BalanceCheckSoapProxy();
    return e_TFMS_BalanceCheckSoap.balanceCheck(parameters);
  }
  
  
}