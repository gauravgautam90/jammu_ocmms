class SingleWindowStatus {
    Long id
    String appId
    String cafNo
    String serviceId       
    String applicationType
    String applicationFor
    String statusCode
    String appRemarks    
    String pendingWith
    String pendingWithRole
    String printAppUrl
    String revertedUrl
    String certificateUrl
    String responce
    Date createdDate


    public SingleWindowStatus(){
        createdDate=new Date();
        responce=""
    }
}