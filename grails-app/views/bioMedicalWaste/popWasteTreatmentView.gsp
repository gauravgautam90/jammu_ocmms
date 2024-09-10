<html>
<head>
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
     <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'bootstrap.css')}" />
     <style>
     div.form{
          padding-left: 10%;
          padding-right: 10%;
          padding-top: 2%;
     }
     center{
          text-align: center;
          margin: auto;
     }
     input#addButton{
          margin-top: 4%;
          margin-left:50%;

     }
     .secondRow{
          background-color: #A8DAF3;
     }
     </style>
</head>
<body>
<div class="form">
     <table class="table table-striped" width="80%">
          <tr  class="headngblue secondRow" style="background-color: #A8DAF3">
               <td>
                    Type Of Waste
               </td>
               <td>
                    Quantity Generated
               </td>
               <td>
                    Where Disposal
               </td>

          </tr>
          <g:each in="${wasteTreatmentList}"  status="i" var="wt">
               <tr class="small">
                    <td bgcolor="#E8F6F9">
                         ${wt.typeOfWaste}
                    </td>
                    <td bgcolor="#E8F6F9">
                         ${wt.quantityGenerated}
                    </td>
                    <td bgcolor="#E8F6F9">
                         ${wt.whereDisposal}
                    </td>


               </tr>
          </g:each>

     </table>
</div>
</body>
</html>