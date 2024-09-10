import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

class RoleProfileAssignmentController {
    
def index = {
    		 try {
    			 redirect(action:list,params:params) 
    			     }catch(Exception e) {
    			            e.printStackTrace();
    						 flash.message = "Server Busy ..Please try after some time....";
    						if(session.indUser){
    					redirect(controller:'indUser',action:'openIndustryHome')
    			 }
    			 else if(session.userMaster){
    			  redirect(controller:'userMaster',action:'openSpcbHome');
    			 }else{
    			        session.invalidate()
    			        redirect(uri:'/index.gsp');
    			 }
    			   }
}

def feeCalculator = { }

def searchPage={}

def fees= {
    		 try {
    			  redirect(action:feeCal,params:params) 
    			     }catch(Exception e) {
    			            e.printStackTrace();
    						 flash.message = "Server Busy ..Please try after some time....";
    						if(session.indUser){
    					redirect(controller:'indUser',action:'openIndustryHome')
    			 }
    			 else if(session.userMaster){
    			  redirect(controller:'userMaster',action:'openSpcbHome');
    			 }else{
    			        session.invalidate()
    			        redirect(uri:'/index.gsp');
    			 }
    			   }
 }

def feeCal={

		 try {
			 def capitalInvestMent
	    		def checked=null
	    		def result
	    		def category=params.category
	    		def consentType=params.consentType
	    		def certificatefor=params.certificatefor
		    	try{
		    		 capitalInvestMent=(params.capital).toLong()
		    		 checked="checkin"
		    		}
	    		catch(java.lang.NumberFormatException e)
	    			{
	    				flash.message="Please Enter The Capital In Integers"
	    				render(view:feeCalculator)
	    			}
	    		if(checked)
	    			{
	    			if(certificatefor=="new")
	    			{
	    			if(consentType=="CTE")
	    			{	
	    	if(category=="RED")
	       		{
	       			if(capitalInvestMent <= 1)
	        		{
	        			result=400;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=800;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1500;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=3000;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=6000;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=10000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=20000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=35000;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=55000;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=80000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=110000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=150000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=200000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=270000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=370000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=500000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=1000000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=2500000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=5000000;
	        		}
	        			}
	        	if(category=="ORANGE")
	       		{	
	       			if(capitalInvestMent <= 1)
	        		{
	        			result=360;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=720;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1350;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=2700;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=5400;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=9000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=18000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=31500;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=49500;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=72000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=99000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=135000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=180000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=243000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=333000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=450000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=900000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=2250000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=4500000;
	        		}
	        		
	        	}
	    		if(category=="GREEN")
	       		{
	    			if(capitalInvestMent <= 1)
	        		{
	        			result=200;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=500;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1000;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=2100;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=4200;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=7000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=14000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=24500;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=38500;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=56000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=77000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=105000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=140000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=189000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=259000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=350000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=700000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=1750000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=3500000;
	        		}
	          }
	     }  		else
	        		{	
	    	 	if(category=="RED")
	       		{
	       			if(capitalInvestMent <= 1)
	        		{
	        			result=400;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=800;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1500;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=3000;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=6000;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=10000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=20000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=35000;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=55000;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=80000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=110000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=150000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=200000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=270000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=370000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=500000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=1000000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=2500000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=5000000;
	        		}
	        			}
	        	if(category=="ORANGE")
	       		{	
	       			if(capitalInvestMent <= 1)
	        		{
	        			result=360;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=720;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1350;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=2700;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=5400;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=9000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=18000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=31500;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=49500;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=72000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=99000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=135000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=180000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=243000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=333000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=450000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=900000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=2250000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=4500000;
	        		}
	        		
	        	}
	    		if(category=="GREEN")
	       		{
	    			if(capitalInvestMent <= 1)
	        		{
	        			result=200;
	        		}
	        		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	        		{
	        			result=500;
	        		}
	        		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	        		{
	        			result=1000;
	        		}
	        		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	        		{
	        			result=2100;
	        		}
	        		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	        		{
	        			result=4200;
	        		}
	        		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	        		{
	        			result=7000;
	        		}
	        		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	        		{
	        			result=14000;
	        		}
	        		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	        		{
	        			result=24500;
	        		}
	        		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	        		{
	        			result=38500;
	        		}
	        		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	        		{
	        			result=56000;
	        		}
	        		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	        		{
	        			result=77000;
	        		}
	        		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	        		{
	        			result=105000;
	        		}
	        		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	        		{
	        			result=140000;
	        		}
	        		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	        		{
	        			result=189000;
	        		}
	        		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	        		{
	        			result=259000;
	        		}
	        		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	        		{
	        			result=350000;
	        		}
	        		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	        		{
	        			result=700000;
	        		}
	        			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	        		{
	        			result=1750000;
	        		}
	        		else if(capitalInvestMent > 500000)
	        		{
	        			result=3500000;
	        		}
	        }    
	        }}
	    			if(certificatefor=="reNew")
	    			{
	    				if(consentType=="CTE")
	    				{	
	    					if(category=="RED")
	    	   		{
	    						if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=250;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=500;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=900;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1800;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=3600;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=6000;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=14000;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=24500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=38500;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=56000;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=77000;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=112500;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=150000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=202500;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=277500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=375000;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=750000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1875000;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=375000;
	    	    		}
	    	    		}
	    	    	if(category=="ORANGE")
	    	   		{	
	    	   			if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=200;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=400;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=800;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1600;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=3200;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=5400;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=12600;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=22100;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=34700;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=50400;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=69300;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=101300;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=135000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=182300;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=249800;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=337500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=675000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1687500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=3375000;
	    	    		}
	    	    		
	    	    	}
	    			if(category=="GREEN")
	    	   		{
	    				if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=100;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=300;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=600;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1300;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=2500;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=4200;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=9800;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=17200;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=27000;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=39200;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=53900;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=78800;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=105000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=141800;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=194300;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=262500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=525000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1312500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=2625000;
	    	    		}
	    	    	}
	    	 }  		
	    	    		else
	    	    		{
	    	    		if(category=="RED")
	    	   		{
	    	   			if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=250;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=500;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=900;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1800;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=3600;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=6000;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=14000;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=24500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=38500;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=56000;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=77000;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=112500;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=150000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=202500;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=277500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=375000;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=750000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1875000;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=375000;
	    	    		}
	    	    		}
	    	    	if(category=="ORANGE")
	    	   		{	
	    	   			if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=200;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=400;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=800;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1600;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=3200;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=5400;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=12600;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=22100;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=34700;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=50400;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=69300;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=101300;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=135000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=182300;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=249800;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=337500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=675000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1687500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=3375000;
	    	    		}
	    	    	}
	    			if(category=="GREEN")
	    	   		{
	    				if(capitalInvestMent <= 1)
	    	    		{
	    	    			result=100;
	    	    		}
	    	    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	    	    		{
	    	    			result=300;
	    	    		}
	    	    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	    	    		{
	    	    			result=600;
	    	    		}
	    	    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	    	    		{
	    	    			result=1300;
	    	    		}
	    	    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	    	    		{
	    	    			result=2500;
	    	    		}
	    	    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	    	    		{
	    	    			result=4200;
	    	    		}
	    	    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	    	    		{
	    	    			result=9800;
	    	    		}
	    	    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	    	    		{
	    	    			result=17200;
	    	    		}
	    	    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	    	    		{
	    	    			result=27000;
	    	    		}
	    	    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	    	    		{
	    	    			result=39200;
	    	    		}
	    	    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	    	    		{
	    	    			result=53900;
	    	    		}
	    	    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	    	    		{
	    	    			result=78800;
	    	    		}
	    	    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	    	    		{
	    	    			result=105000;
	    	    		}
	    	    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	    	    		{
	    	    			result=141800;
	    	    		}
	    	    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=194300;
	    	    		}
	    	    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	    	    		{
	    	    			result=262500;
	    	    		}
	    	    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	    	    		{
	    	    			result=525000;
	    	    		}
	    	    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	    	    		{
	    	    			result=1312500;
	    	    		}
	    	    		else if(capitalInvestMent > 500000)
	    	    		{
	    	    			result=2625000;
	    	    		}
	    	    	}
	    	    }
	    	}
		}	
render(view:'feeCalculator',model:[result:result])
}catch(Exception e) {
    e.printStackTrace();
		 flash.message = "Server Busy ..Please try after some time....";
		if(session.indUser){
	redirect(controller:'indUser',action:'openIndustryHome')
}
else if(session.userMaster){
redirect(controller:'userMaster',action:'openSpcbHome');
}else{
session.invalidate()
redirect(uri:'/index.gsp');
}
}
}
		    		
def goToAttach = {
    		 try {
    			ArrayList myArrayList2 = new ArrayList()
    	    		def empList=UserProfile.list()
    	    		for(int q=0;q<empList.size();q++)
    	    		{
    	    			if((empList.get(q)).status=="active")
    	    			{
    	    				myArrayList2.add((empList.get(q)))
    	    			}
    	    		}
    	    		render(view:'create',model:[myArrayList2:myArrayList2])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
    
def updateAttach = {
    		 try {
    			 redirect(action:updateAttachOfficers,params:params) 
    			     }catch(Exception e) {
    			            e.printStackTrace();
    						 flash.message = "Server Busy ..Please try after some time....";
    						if(session.indUser){
    					redirect(controller:'indUser',action:'openIndustryHome')
    			 }
    			 else if(session.userMaster){
    			  redirect(controller:'userMaster',action:'openSpcbHome');
    			 }else{
    			        session.invalidate()
    			        redirect(uri:'/index.gsp');
    			 }
    			   }
 }
    
def updateAttachOfficers = { }

static allowedMethods = [delete:'POST', save:'POST', update:'POST']

def list = {
    	 try {
    		 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
    	        [ roleProfileAssignmentInstanceList: RoleProfileAssignment.list( params ), roleProfileAssignmentInstanceTotal: RoleProfileAssignment.count() ]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

def show = {
    	 try {
    		 def roleProfileAssignmentInstance = RoleProfileAssignment.get( params.id )
    	        if(!roleProfileAssignmentInstance) {
    	            flash.message = "RoleProfileAssignment not found with id ${params.id}"
    	            redirect(action:list)
    	        }
    	        else { return [ roleProfileAssignmentInstance : roleProfileAssignmentInstance ] }
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

    def delete = {
        def roleProfileAssignmentInstance = RoleProfileAssignment.get( params.id )
        if(roleProfileAssignmentInstance) {
            try {
                roleProfileAssignmentInstance.delete()
                flash.message = "RoleProfileAssignment ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "RoleProfileAssignment ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "RoleProfileAssignment not found with id ${params.id}"
            redirect(action:list)
        }
    }

def edit = {
    	 try {
    		if(params.grp==null)
    	    	{
    	    		flash.message = "Please Select From The List"
    	                redirect(action:updateAttachOfficers)
    	    	}
    	    	def roleProfileAssignmentInstance1 = new RoleProfileAssignment()
    	    	 roleProfileAssignmentInstance1.id = (params.grp).toLong()
    	        def roleProfileAssignmentInstance = RoleProfileAssignment.get( roleProfileAssignmentInstance1.id )

    	        if(!roleProfileAssignmentInstance) {
    	            flash.message = "RoleProfileAssignment not found with id ${params.grp}"
    	            redirect(action:updateAttachOfficers)
    	        }
    	        else {
    	            return [ roleProfileAssignmentInstance : roleProfileAssignmentInstance ]
    	        }
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}

def update = {
    	 try {
    		def roleProfileAssignmentInstance = RoleProfileAssignment.get( params.id )
    	        if(roleProfileAssignmentInstance) {
    	            if(params.version) {
    	                def version = params.version.toLong()
    	                if(roleProfileAssignmentInstance.version > version) {
    	                    
    	                    roleProfileAssignmentInstance.errors.rejectValue("version", "roleProfileAssignment.optimistic.locking.failure", "Another user has updated this RoleProfileAssignment while you were editing.")
    	                    render(view:'edit',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance])
    	                    return
    	                }
    	            }
    	            roleProfileAssignmentInstance.properties = params
    	            if(!roleProfileAssignmentInstance.hasErrors() && roleProfileAssignmentInstance.save()) {
    	                flash.message = "RoleProfileAssignment ${params.id} updated"
    	                redirect(action:updateAttachOfficers,id:roleProfileAssignmentInstance.id)
    	            }
    	            else {
    	                render(view:'edit',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance])
    	            }
    	        }
    	        else {
    	            flash.message = "RoleProfileAssignment not found with id ${params.id}"
    	            redirect(action:edit,id:params.id)
    	        }
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

def create = {
    	 try {
    		def roleProfileAssignmentInstance = new RoleProfileAssignment()
    	        roleProfileAssignmentInstance.properties = params
    	        return ['roleProfileAssignmentInstance':roleProfileAssignmentInstance]
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

 def save = {
    	 try {
    		if(params.grp == null)
    	    	{
    	    		flash.message = "Please Select The Role To Attach Officers"
    	    			 redirect(action:goToAttach)
    	    	}
    	        def roleProfileAssignmentInstance = new RoleProfileAssignment(params)
    	       roleProfileAssignmentInstance.role = RoleMaster.get((params.grp).toLong())
    	         def Duplicate=RoleProfileAssignment.findAllByRole(roleProfileAssignmentInstance.role)
    	        if(Duplicate)
    	        {
    	        	flash.message = "RoleProfileAssignment ${roleProfileAssignmentInstance.role} already Linked"
    	        		 redirect(action:goToAttach)
    	        }
    	        else
    	        {
    	        if(!roleProfileAssignmentInstance.hasErrors() && roleProfileAssignmentInstance.save()) {
    	            flash.message = "RoleProfileAssignment ${roleProfileAssignmentInstance.id} created"
    	            redirect(action:goToAttach)
    	        }
    	        else {
    	            render(view:'goToAttach',model:[roleProfileAssignmentInstance:roleProfileAssignmentInstance])
    	        }
    	        }
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
     
def searchUtility = {
    	 try {
    		def paramList
     		def orphList
     		def pendList
     		def compList
     		def abc
     		def abc3
     		def allFour= new ArrayList()
     		def appList= new ArrayList()
     		def pendingWithList= new ArrayList()
     		def rolependingWithList= new ArrayList()
     		if(params)
     		{
     			paramList=params
     		}
     		def xyz5
     		def qwe
     		if(params.max)
        		{
        			xyz5=(params.max).toInteger()
        		}
        		else
        		{
        			xyz5=10
        		}
        		if(params.offset)
        		{
        			qwe=(params.offset).toInteger()
        		}
        		else
        		{
        			qwe=0
        		}
     		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     		Date date = new Date();
     		Calendar calendar = Calendar.getInstance();
     		calendar.add(Calendar.MONTH, -3);
     		Date date1 = new Date(dateFormat.format(calendar.getTime()));   
     		def dateF=date1
     		def checkDate=dateF
     		def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
     		def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
     		def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
     		def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
     		def recTotal=recDet.size()
     		def total
     		def pendTotal=pendDet.size()
     		def compTotal=compDet.size()
     		def orphTotal=orphDet.size()
     		def level
     		if(params.checkVar)
     		{
     			if(params.checkVar=="received")
     			{
     				Date today = new Date();
     				def diffList= new ArrayList()
     				level="Received Applications"
     				def abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate] ); 
         		def abc2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate],[max:xyz5,offset:qwe] );
         		for(int g=0;g<abc2.size();g++)
     			{
     				allFour=abc2.get(g)
     				if(allFour)
     				{
     					appList.add(((ArrayList)allFour).get(0))
     				}
     			}
     			abc3=appList
         		total=abcR.size()
         		for(int p=0;p<abc3.size();p++)
     						{
 			        			def varAppInstance=abc3.get(p)
 			        			def varindApplInstance=varAppInstance.application
 								def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varindApplInstance,[max:1,sort:"lastUpdated", order:"desc"])
     							def abcFinal=(abc3.get(p)).application.actualApplicationDate
     							if(appProcessingInstance)
     							{
     								def appProcessingTime=appProcessingInstance.lastUpdated
     								long diff = today.getTime() - appProcessingTime.getTime();
     								int diffDays=diff / (1000*60*60*24)
     								diffList.add(diffDays.toString())
     							}else{
     							long diff = today.getTime() - abcFinal.getTime();
     							int diffDays=diff / (1000*60*60*24)
     							diffList.add(diffDays.toString())
     							}
     							if(abcFinal.getClass().getName()=="java.sql.Date")
     								{
     								(abc3.get(p)).application.actualApplicationDate=abcFinal
     								}
 								else
 								{
     							DateCustom dd=new DateCustom()
     							def xyz= dd.toDate(abcFinal)
     						(abc3.get(p)).application.actualApplicationDate=xyz
 								}
     						}
     			render(view:'searchPage',model:[diffList:diffList,level:level,orphList:orphList,pendList:pendList,compList:compList,abc3:abc3,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
         		}
     			if(params.checkVar=="completed")
     			{
     				Date today = new Date();
     				def diffList= new ArrayList()
     				level="Completed Applications"
     				def compL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  order by dateCheck.id desc", [checkDate],[max:xyz5,offset:qwe] );
     				for(int g=0;g<compL.size();g++)
 					{
 						allFour=compL.get(g)
 						if(allFour)
 						{
 							appList.add(((ArrayList)allFour).get(0))
 							pendingWithList.add(((ArrayList)allFour).get(1))
 							rolependingWithList.add((((ArrayList)allFour).get(1)).role)
 						}
 					}
 					abc=appList
     				for(int u=0;u<abc.size();u++)
 					{
     					def varAppInstance=abc.get(u)
     					def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varAppInstance,[max:1,sort:"lastUpdated", order:"desc"])
 						def abcFinal=(abc.get(u)).actualApplicationDate
 						if(appProcessingInstance)
 						{
 							def appProcessingTime=appProcessingInstance.lastUpdated
 							long diff = today.getTime() - appProcessingTime.getTime();
 							int diffDays=diff / (1000*60*60*24)
 							diffList.add(diffDays.toString())
 						}else{
 						long diff = today.getTime() - abcFinal.getTime();
 						int diffDays=diff / (1000*60*60*24)
 						diffList.add(diffDays.toString())
 						}
 						if(abcFinal.getClass().getName()=="java.sql.Date")
     								{
 							(abc.get(u)).actualApplicationDate=abcFinal
     								}
 								else
 								{
 						DateCustom dd=new DateCustom()
 						def xyz= dd.toDate(abcFinal)
 					(abc.get(u)).actualApplicationDate=xyz
 								}
 					}	
     				total=compTotal
     				render(view:'searchPage',model:[diffList:diffList,rolependingWithList:rolependingWithList,level:level,orphList:orphList,pendList:pendList,compList:compList,abc:abc,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
     			}
     			if(params.checkVar=="pending")
     			{
     				def pendvariabCheck="yes"
     				 Date today = new Date();
     				 def diffList= new ArrayList()
     				 def lessThan7List= new ArrayList()
      				def bet7To15List= new ArrayList()
      				def after15List= new ArrayList()
      				def diffListless7= new ArrayList()
      				def diffListbet7To15= new ArrayList()
      				def diffListbetmore15= new ArrayList()
     				level="Pending Applications"
     				def lessThan7ListRole= new ArrayList()
      					def bet7To15ListRole= new ArrayList()
      					def after15ListRole= new ArrayList()
     				def lessThan7ListRoleEmployee= new ArrayList()
   					def bet7To15ListRoleEmployee= new ArrayList()
   					def after15ListRoleEmployee= new ArrayList()
     				def pendL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  order by dateCheck.id desc", [checkDate]); 
     				 for(int g=0;g<pendL.size();g++)
 					{
 						allFour=pendL.get(g)
 						if(allFour)
 						{
 							appList.add(((ArrayList)allFour).get(0))
 							pendingWithList.add(((ArrayList)allFour).get(1).pendingWithId)
 							rolependingWithList.add((((ArrayList)allFour).get(1)).role)
 						}
 					}
 					abc=appList
     				for(int u=0;u<abc.size();u++)
 					{
     					def varAppInstance=abc.get(u)
     					def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(varAppInstance,[max:1,sort:"lastUpdated", order:"desc"])
     					def abcFinal=(abc.get(u)).actualApplicationDate
 						if(appProcessingInstance)
 						{
 							def appProcessingTime=appProcessingInstance[0].lastUpdated
 							long diff = today.getTime() - appProcessingTime.getTime();
 							int diffDays=diff / (1000*60*60*24)
 							if(diffDays<7)
 							{
 								lessThan7List.add(abc.get(u))
 								lessThan7ListRole.add(rolependingWithList.get(u))
 								lessThan7ListRoleEmployee.add(pendingWithList.get(u))
 								diffListless7.add(diffDays.toString())
 							}else if (diffDays>=7 && diffDays<15){
 								bet7To15List.add(abc.get(u))
 								bet7To15ListRole.add(rolependingWithList.get(u))
 								bet7To15ListRoleEmployee.add(pendingWithList.get(u))
 								diffListbet7To15.add(diffDays.toString())
 							}else if (diffDays>=15) {
 								after15List.add(abc.get(u))
 								after15ListRole.add(rolependingWithList.get(u))
 								after15ListRoleEmployee.add(pendingWithList.get(u))
 								diffListbetmore15.add(diffDays.toString())
 							}
 							diffList.add(diffDays.toString())
 							abcFinal=appProcessingTime
 						}else{
 						long diff = today.getTime() - abcFinal.getTime();
 						int diffDays=diff / (1000*60*60*24)
 						if(diffDays<7)
 						{
 							lessThan7List.add(abc.get(u))
 							lessThan7ListRole.add(rolependingWithList.get(u))
 							lessThan7ListRoleEmployee.add(pendingWithList.get(u))
 							diffListless7.add(diffDays.toString())
 						}else if (diffDays>=7 && diffDays<15){
 							bet7To15List.add(abc.get(u))
 							bet7To15ListRole.add(rolependingWithList.get(u))
 							bet7To15ListRoleEmployee.add(pendingWithList.get(u))
 							diffListbet7To15.add(diffDays.toString())
 						}else if (diffDays>=15) {
 							after15List.add(abc.get(u))
 							after15ListRole.add(rolependingWithList.get(u))
 							after15ListRoleEmployee.add(pendingWithList.get(u))
 							diffListbetmore15.add(diffDays.toString())
 						}
 						diffList.add(diffDays.toString())
 						}
 						DateCustom dd=new DateCustom()
 							if(abcFinal.getClass().getName()=="java.sql.Date")
     								{
     									(abc.get(u)).actualApplicationDate=abcFinal
     									
     								}
     								else
     								{
     								def xyz= dd.toDate(abcFinal)
     							(abc.get(u)).actualApplicationDate=xyz
     	   					}
 					}	
     				total=pendTotal
     				render(view:'searchPage',model:[pendvariabCheck:pendvariabCheck,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,level:level,orphList:orphList,pendList:pendList,compList:compList,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal,rolependingWithList:rolependingWithList,after15ListRole:after15ListRole,bet7To15ListRole:bet7To15ListRole,lessThan7ListRole:lessThan7ListRole,after15ListRoleEmployee:after15ListRoleEmployee,bet7To15ListRoleEmployee:bet7To15ListRoleEmployee,lessThan7ListRoleEmployee:lessThan7ListRoleEmployee])
     			}
     			if(params.checkVar=="orphan")
     			{
     				def pendCheck="yes"
     				def lessThan7List= new ArrayList()
     				def bet7To15List= new ArrayList()
     				def after15List= new ArrayList()
     				def diffListless7= new ArrayList()
     				def diffListbet7To15= new ArrayList()
     				def diffListbetmore15= new ArrayList()
     				level="Unattended Applications"
     					 Date today = new Date();
     				def diffList= new ArrayList()
     				def orphL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan' order by dateCheck.actualApplicationDate desc", [checkDate]);
     				abc=orphL
     				for(int u=0;u<abc.size();u++)
 					{
 						def abcFinal=(abc.get(u)).actualApplicationDate
 						long diff = today.getTime() - abcFinal.getTime();
 						int diffDays=diff / (1000*60*60*24)
 					if(diffDays<7)
 						{
 							lessThan7List.add(abc.get(u))
 							diffListless7.add(diffDays.toString())
 						}else if (diffDays>=7 && diffDays<15){
 							bet7To15List.add(abc.get(u))
 							diffListbet7To15.add(diffDays.toString())
 						}else if (diffDays>=15) {
 							after15List.add(abc.get(u))
 							diffListbetmore15.add(diffDays.toString())
 						}
 						diffList.add(diffDays.toString())
 						if(abcFinal.getClass().getName()=="java.sql.Date")
     								{
 									(abc.get(u)).actualApplicationDate==abcFinal
     								}
 								else
 								{
 									DateCustom dd=new DateCustom()
 						def xyz= dd.toDate(abcFinal)
 					(abc.get(u)).actualApplicationDate=xyz
 								}
 					}	
     				total=orphTotal
     				render(view:'searchPage',model:[pendCheck:pendCheck,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,level:level,orphList:orphList,pendList:pendList,compList:compList,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
     			}
     		}
     		else
     		{
     			def viewLevels="yes"
     			def abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate] ); 
     		def abc2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate],[max:xyz5,offset:qwe] );
     		for(int g=0;g<abc2.size();g++)
 			{
 				allFour=abc2.get(g)
 				if(allFour)
 				{
 					appList.add(((ArrayList)allFour).get(0))
 				}
 			}
 			abc3=appList
     		total=abcR.size()
     	for(int p=0;p<abc3.size();p++)
 						{
 							def abcFinal=(abc3.get(p)).application.actualApplicationDate
 							if(abcFinal.getClass().getName()=="java.sql.Date")
     								{
 									(abc3.get(p)).application.actualApplicationDate=abcFinal
     								}
 								else
 								{
 							DateCustom dd=new DateCustom()
 							def xyz= dd.toDate(abcFinal)
 						(abc3.get(p)).application.actualApplicationDate=xyz
 								}
 						}
     		render(view:'searchPage',model:[viewLevels:viewLevels,level:level,orphList:orphList,pendList:pendList,compList:compList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
     		}
     	 }catch(Exception e) {
             e.printStackTrace();
 			 flash.message = "Server Busy ..Please try after some time....";
 			if(session.indUser){
 		redirect(controller:'indUser',action:'openIndustryHome')
  }
  else if(session.userMaster){
   redirect(controller:'userMaster',action:'openSpcbHome');
  }else{
         session.invalidate()
         redirect(uri:'/index.gsp');
  }
    }
}
     
def search = {
try {
		def xyz5
   		def qwe
   		def listToPrintCriteria= new ArrayList()
   		if(params.max)
   		{
   			xyz5=(params.max).toInteger()
   		}
   		else
   		{
   			xyz5=10
   		}
   		if(params.offset)
   		{
   			qwe=(params.offset).toInteger()
   		}
   		else
   		{
   			qwe=0
   		}
    	def paramList= new ArrayList()
    	paramList=params
    	 session["listResult"] = params
    	def appList= new ArrayList()
    	def gettingObject= new ArrayList()
		def allFour= new ArrayList()
    	def fullListToPrint= new ArrayList()
			def abc1= new ApplicationPendingDetails()
   		def abcR= new IndApplicationDetails()
			int total;
    	def diffList= new ArrayList()
    	Date today = new Date();
    	def startDate1=params.start_date_value
			def endDate1=params.end_date_value
			def x
			def y
			def totalRes
			def categories
			def checkDate=null
			println("------"+startDate1+"-------"+endDate1)
			session.startDateForPrint=startDate1
			session.endDate1ForPrint=endDate1
			
		if(params.category != "xyz")
		{
			categories=(params.category)
		}
		else
		{
			categories = params.category
		}
		def status=params.status 		
    	try
		{
			def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
			x = sdfh.parse(startDate1); //Date
			y = sdfh.parse(endDate1);  //Date
			checkDate="checked"
		}
		catch(Exception e)
		{
			flash.message="Enter Both The Dates in Correct Format "
			redirect(action:searchPage)
		}	
		if(checkDate)
		{
		java.sql.Date sqlDate = new java.sql.Date(x.getTime())
		java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
		sqlDate2.setDate((sqlDate2.getDate()+1))
	if(status!="xyz" && (status=="pending" ||status=="orphan"))
		{
			if(status=="pending"){
				if(startDate1 && endDate1 && categories != "xyz" && status != "xyz" )
				{
					def searchCriteriaPending="yes"
					def lessThan7List= new ArrayList()
    				def bet7To15List= new ArrayList()
    				def after15List= new ArrayList()
    				def diffListless7= new ArrayList()
    				def diffListbet7To15= new ArrayList()
    				def diffListbetmore15= new ArrayList()
					def nis
					def xyz
					nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status]); 
					xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status]);
				for(int g=0;g<xyz.size();g++)
					{
						allFour=xyz.get(g)
						if(allFour)
						{
							appList.add(((ArrayList)allFour).get(0))
						}
					}
					abc1=appList
				total=nis.size()
					for(int d=0;d<abc1.size();d++)
					{
						def varAppInstance=(abc1.get(d)).application
						def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(varAppInstance,[max:1,sort:"lastUpdated", order:"desc"])
						def abcFina=(abc1.get(d)).application.actualApplicationDate
						if(appProcessingInstance)
						{
							def appProcessingTime=appProcessingInstance[0].lastUpdated
							long diff = today.getTime() - appProcessingTime.getTime();
							int diffDays=diff / (1000*60*60*24)
							if(diffDays<7)
							{
								lessThan7List.add(abc1.get(d))
								diffListless7.add(diffDays.toString())
							}else if (diffDays>=7 && diffDays<15){
								bet7To15List.add(abc1.get(d))
								diffListbet7To15.add(diffDays.toString())
							}else if (diffDays>=15) {
								after15List.add(abc1.get(d))
								diffListbetmore15.add(diffDays.toString())
							}
							diffList.add(diffDays.toString())
							abcFina=appProcessingTime
						}else{
						long diff = today.getTime() - abcFina.getTime();
						int diffDays=diff / (1000*60*60*24)
						if(diffDays<7)
						{
							lessThan7List.add(abc1.get(d))
							diffListless7.add(diffDays.toString())
						}else if (diffDays>=7 && diffDays<15){
							bet7To15List.add(abc1.get(d))
							diffListbet7To15.add(diffDays.toString())
						}else if (diffDays>=15) {
							after15List.add(abc1.get(d))
							diffListbetmore15.add(diffDays.toString())
						}
						diffList.add(diffDays.toString())
						}
						if(abcFina.getClass().getName()=="java.sql.Date")
							{
							(abc1.get(d)).application.actualApplicationDate=abcFina
							}
						else
						{
						DateCustom dd2=new DateCustom()
						def xyz2= dd2.toDate(abcFina)
					(abc1.get(d)).application.actualApplicationDate=xyz2
						}
					}
					render(view:'searchPage',model:[searchCriteriaPending:searchCriteriaPending,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,total:total,paramList:paramList])
			}
		if(startDate1 && endDate1 && categories == "xyz" && status != "xyz" )
				{
					def searchCriteriaOne="yes"
					def lessThan7List= new ArrayList()
    				def bet7To15List= new ArrayList()
    				def after15List= new ArrayList()
    				def diffListless7= new ArrayList()
    				def diffListbet7To15= new ArrayList()
    				def diffListbetmore15= new ArrayList()
					def ewq
					def xyz
				ewq=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status]); 
				xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status]);
				for(int a=0;a<xyz.size();a++)
					{
						allFour=xyz.get(a)
						if(allFour)
						{
							appList.add(((ArrayList)allFour).get(0))
						}
					}
    			abc1=appList
    			total=ewq.size()
    			for(int k=0;k<abc1.size();k++)
					{
						def varAppInstance=(abc1.get(k)).application
						def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(varAppInstance,[max:1,sort:"lastUpdated", order:"desc"])
						def abcFinl=(abc1.get(k)).application.actualApplicationDate
						if(appProcessingInstance)
						{
							def appProcessingTime=appProcessingInstance[0].lastUpdated
							long diff = today.getTime() - appProcessingTime.getTime();
							int diffDays=diff / (1000*60*60*24)
							if(diffDays<7)
							{
								lessThan7List.add(abc1.get(k))
								diffListless7.add(diffDays.toString())
							}else if (diffDays>=7 && diffDays<15){
								bet7To15List.add(abc1.get(k))
								diffListbet7To15.add(diffDays.toString())
							}else if (diffDays>=15) {
								after15List.add(abc1.get(k))
								diffListbetmore15.add(diffDays.toString())
							}
							diffList.add(diffDays.toString())
							abcFinl=appProcessingTime
						}else{
						long diff = today.getTime() - abcFinl.getTime();
						int diffDays=diff / (1000*60*60*24)
						if(diffDays<7)
						{
							lessThan7List.add(abc1.get(k))
							diffListless7.add(diffDays.toString())
						}else if (diffDays>=7 && diffDays<15){
							bet7To15List.add(abc1.get(k))
							diffListbet7To15.add(diffDays.toString())
						}else if (diffDays>=15) {
							after15List.add(abc1.get(k))
							diffListbetmore15.add(diffDays.toString())
						}
						diffList.add(diffDays.toString())
						}
						if(abcFinl.getClass().getName()=="java.sql.Date")
							{
							(abc1.get(k)).application.actualApplicationDate=abcFinl
							}
						else
						{
						DateCustom dd3=new DateCustom()
						def xyz3= dd3.toDate(abcFinl)
						(abc1.get(k)).application.actualApplicationDate=xyz3
						}
					}
    			render(view:'searchPage',model:[searchCriteriaOne:searchCriteriaOne,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,total:total,paramList:paramList])
				}
			}else{
				if(startDate1 && endDate1 && categories != "xyz" && status != "xyz" )
				{
					def searchCriteriaPendingNoStatus="yes"
					def lessThan7List= new ArrayList()
    				def bet7To15List= new ArrayList()
    				def after15List= new ArrayList()
    				def diffListless7= new ArrayList()
    				def diffListbet7To15= new ArrayList()
    				def diffListbetmore15= new ArrayList()
					def nis
					def xyz
					xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ?  and dateCheck.indUser.category.name = ? and dateCheck.completionStatus=? order by dateCheck.actualApplicationDate desc", [sqlDate,sqlDate2,categories,status]);
				abc1=xyz
				total=xyz.size()
					for(int d=0;d<abc1.size();d++)
					{
						def abcFina=(abc1.get(d)).actualApplicationDate
						long diff = today.getTime() - abcFina.getTime();
						int diffDays=diff / (1000*60*60*24)
						if(diffDays<7)
						{
							lessThan7List.add(abc1.get(d))
							diffListless7.add(diffDays.toString())
						}else if (diffDays>=7 && diffDays<15){
							bet7To15List.add(abc1.get(d))
							diffListbet7To15.add(diffDays.toString())
						}else if (diffDays>=15) {
							after15List.add(abc1.get(d))
							diffListbetmore15.add(diffDays.toString())
						}
						diffList.add(diffDays.toString())
						if(abcFina.getClass().getName()=="java.sql.Date")
							{
							(abc1.get(d)).actualApplicationDate=abcFina
							}
						else
						{
						DateCustom dd2=new DateCustom()
						def xyz2= dd2.toDate(abcFina)
					(abc1.get(d)).actualApplicationDate=xyz2
						}
					}
					render(view:'searchPage',model:[searchCriteriaPendingNoStatus:searchCriteriaPendingNoStatus,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,total:total,paramList:paramList])
			}
			if(startDate1 && endDate1 && categories == "xyz" && status != "xyz" )
				{
					def searchCriteriaOneUnattended="yes"
					def lessThan7List= new ArrayList()
    				def bet7To15List= new ArrayList()
    				def after15List= new ArrayList()
    				def diffListless7= new ArrayList()
    				def diffListbet7To15= new ArrayList()
    				def diffListbetmore15= new ArrayList()
					def ewq
					def xyz
				xyz=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.completionStatus=? order by dateCheck.actualApplicationDate desc", [sqlDate,sqlDate2,status]);
				abc1=xyz
    			total=xyz.size()
    			for(int k=0;k<abc1.size();k++)
					{
						def abcFinl=(abc1.get(k)).actualApplicationDate
						long diff = today.getTime() - abcFinl.getTime();
						int diffDays=diff / (1000*60*60*24)
						if(diffDays<7)
						{
							lessThan7List.add(abc1.get(k))
							diffListless7.add(diffDays.toString())
						}else if (diffDays>=7 && diffDays<15){
							bet7To15List.add(abc1.get(k))
							diffListbet7To15.add(diffDays.toString())
						}else if (diffDays>=15) {
							after15List.add(abc1.get(k))
							diffListbetmore15.add(diffDays.toString())
						}
						diffList.add(diffDays.toString())
						if(abcFinl.getClass().getName()=="java.sql.Date")
							{
							(abc1.get(k)).actualApplicationDate=abcFinl
							}
						else
						{
						DateCustom dd3=new DateCustom()
						def xyz3= dd3.toDate(abcFinl)
						(abc1.get(k)).actualApplicationDate=xyz3
						}
					}
    			render(view:'searchPage',model:[searchCriteriaOneUnattended:searchCriteriaOneUnattended,diffListless7:diffListless7,diffListbet7To15:diffListbet7To15,diffListbetmore15:diffListbetmore15,lessThan7List:lessThan7List,bet7To15List:bet7To15List,after15List:after15List,diffList:diffList,total:total,paramList:paramList])
				}
			}
		}
		else{		
		if(startDate1 && endDate1 && categories=="xyz" && status=="xyz")
					{
					abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.actualApplicationDate <= ? order by dateCheck.id desc",  [sqlDate,sqlDate2]); 
						def var1=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.actualApplicationDate <= ? order by dateCheck.id desc",  [sqlDate,sqlDate2],[max:xyz5,offset:qwe] ); 
    		            total=abcR.size()
    		            for(int intlist=0;intlist<abcR.size();intlist++)
						{
    		            	gettingObject=abcR.get(intlist)
							if(gettingObject)
							{
								fullListToPrint.add(((ArrayList)gettingObject).get(0))
							}
						}
    		           for(int g=0;g<var1.size();g++)
						{
							allFour=var1.get(g)
							if(allFour)
							{
								appList.add(((ArrayList)allFour).get(0))
							}
						}
						abc1=appList
						for(int p=0;p<abc1.size();p++)
						{
							def varAppInstance=(abc1.get(p)).application
							def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varAppInstance,[max:1])
							def abcFinal=(abc1.get(p)).application.actualApplicationDate
							if(appProcessingInstance)
							{
								def appProcessingTime=appProcessingInstance.lastUpdated
								long diff = today.getTime() - appProcessingTime.getTime();
								int diffDays=diff / (1000*60*60*24)
								diffList.add(diffDays.toString())
							}else{
							long diff = today.getTime() - abcFinal.getTime();
							int diffDays=diff / (1000*60*60*24)
							diffList.add(diffDays.toString())
							}
						if(abcFinal.getClass().getName()=="java.sql.Date")
								{
								(abc1.get(p)).application.actualApplicationDate=abcFinal
								}
							else
							{
							DateCustom dd=new DateCustom()
							def xyz= dd.toDate(abcFinal)
						(abc1.get(p)).application.actualApplicationDate=xyz
							}
					}
    				}
    		 if(startDate1 && endDate1 && categories != "xyz" && status=="xyz")
					{
    				abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? order by dateCheck.id desc ", [sqlDate,sqlDate2,categories]);
						def var2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? order by dateCheck.id desc ", [sqlDate,sqlDate2,categories],[max:xyz5,offset:qwe]);
						total=abcR.size()
						 for(int intlist=0;intlist<abcR.size();intlist++)
						{
    		            	gettingObject=abcR.get(intlist)
							if(gettingObject)
							{
								fullListToPrint.add(((ArrayList)gettingObject).get(0))
							}
						}
    		        for(int g=0;g<var2.size();g++)
						{
							allFour=var2.get(g)
							if(allFour)
							{
								appList.add(((ArrayList)allFour).get(0))
							}
						}
						abc1=appList
						for(int r=0;r<abc1.size();r++)
						{
							def varAppInstance=(abc1.get(r)).application
							def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varAppInstance,[max:1])
							def abcFin=(abc1.get(r)).application.actualApplicationDate
							if(appProcessingInstance)
							{
								def appProcessingTime=appProcessingInstance.lastUpdated
								long diff = today.getTime() - appProcessingTime.getTime();
								int diffDays=diff / (1000*60*60*24)
								diffList.add(diffDays.toString())
							}else{
							long diff = today.getTime() - abcFin.getTime();
							int diffDays=diff / (1000*60*60*24)
							diffList.add(diffDays.toString())
							}
							if(abcFin.getClass().getName()=="java.sql.Date")
								{
								(abc1.get(r)).application.actualApplicationDate=abcFin
								}
							else
							{
							DateCustom dd1=new DateCustom()
							def xyz1= dd1.toDate(abcFin)
							(abc1.get(r)).application.actualApplicationDate=xyz1
						}
						}
					}	
					if(startDate1 && endDate1 && categories != "xyz" && status != "xyz" )
					{
						def nis
						def xyz
					nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status]); 
					xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.name = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status],[max:xyz5,offset:qwe]); 
					 for(int intlist=0;intlist<nis.size();intlist++)
						{
    		            	gettingObject=nis.get(intlist)
							if(gettingObject)
							{
								fullListToPrint.add(((ArrayList)gettingObject).get(0))
							}
						}
    		          for(int g=0;g<xyz.size();g++)
						{
							allFour=xyz.get(g)
							if(allFour)
							{
								appList.add(((ArrayList)allFour).get(0))
							}
						}
						abc1=appList
					total=nis.size()
						for(int d=0;d<abc1.size();d++)
						{
							def varAppInstance=(abc1.get(d)).application
							def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varAppInstance,[max:1])
							def abcFina=(abc1.get(d)).application.actualApplicationDate
							if(appProcessingInstance)
							{
								def appProcessingTime=appProcessingInstance.lastUpdated
								long diff = today.getTime() - appProcessingTime.getTime();
								int diffDays=diff / (1000*60*60*24)
								diffList.add(diffDays.toString())
							}else{
							long diff = today.getTime() - abcFina.getTime();
							int diffDays=diff / (1000*60*60*24)
							diffList.add(diffDays.toString())
							}
							if(abcFina.getClass().getName()=="java.sql.Date")
								{
								(abc1.get(d)).application.actualApplicationDate=abcFina
								}
							else
							{
							DateCustom dd2=new DateCustom()
							def xyz2= dd2.toDate(abcFina)
						(abc1.get(d)).application.actualApplicationDate=xyz2
							}
						}
    		}
    			if(startDate1 && endDate1 && categories == "xyz" && status != "xyz" )
					{
						def ewq
						def xyz
					ewq=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status]); 
								xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status],[max:xyz5,offset:qwe]); 
					 for(int intlist=0;intlist<ewq.size();intlist++)
								{
		    		            	gettingObject=ewq.get(intlist)
									if(gettingObject)
									{
										fullListToPrint.add(((ArrayList)gettingObject).get(0))
									}
								}
		    		    for(int a=0;a<xyz.size();a++)
						{
							allFour=xyz.get(a)
							if(allFour)
							{
								appList.add(((ArrayList)allFour).get(0))
							}
						}
        			abc1=appList
        			total=ewq.size()
        			for(int k=0;k<abc1.size();k++)
						{
							def varAppInstance=(abc1.get(k)).application
							def appProcessingInstance=ApplicationProcessingDetails.findByApplication(varAppInstance,[max:1])
							def abcFinl=(abc1.get(k)).application.actualApplicationDate
							if(appProcessingInstance)
							{
								def appProcessingTime=appProcessingInstance.lastUpdated
								long diff = today.getTime() - appProcessingTime.getTime();
								int diffDays=diff / (1000*60*60*24)
								diffList.add(diffDays.toString())
							}else{
							long diff = today.getTime() - abcFinl.getTime();
							int diffDays=diff / (1000*60*60*24)
							diffList.add(diffDays.toString())
							}
							if(abcFinl.getClass().getName()=="java.sql.Date")
								{
								(abc1.get(k)).application.actualApplicationDate=abcFinl
								}
							else
							{
							DateCustom dd3=new DateCustom()
							def xyz3= dd3.toDate(abcFinl)
							(abc1.get(k)).application.actualApplicationDate=xyz3
							}
						}
					}
    		if(abc1.size()==0)
    				{
    					flash.message="No Result Found With This Search Combination"
    				}
    				if(sqlDate>sqlDate2)
					{
						flash.message="End Date should be Greater than Starting Date"
					}	
    				render(view:'searchPage',model:[fullListToPrint:fullListToPrint,diffList:diffList,abc1:abc1,total:total,paramList:paramList])
				}
		}
    		 }catch(Exception e) {
    		            e.printStackTrace();
    					 flash.message = "Server Busy ..Please try after some time....";
    					if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    		 }else if(session.userMaster){
    		 redirect(controller:'userMaster',action:'openSpcbHome');
    		 }else{
    		      session.invalidate()
    		       redirect(uri:'/index.gsp');
    		 }
    		}
    }		   
							
def popListSummary={
    	 try {
    		def paramList
    			def orphList
    			def pendList
    			def compList
    			def abc
    			def abc3
    			def allFour= new ArrayList()
    			def appList= new ArrayList()
    			def pendingWithList= new ArrayList()
    			def rolependingWithList= new ArrayList()
    			def level
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			Date date = new Date();
    			Calendar calendar = Calendar.getInstance();
    			calendar.add(Calendar.MONTH, -3);
    			Date date1 = new Date(dateFormat.format(calendar.getTime()));   
    			def dateF=date1
    			def checkDate=dateF
    			def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
    			def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.applicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
    			def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
    			def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
    			def recTotal=recDet.size()
    			def total
    			def pendTotal=pendDet.size()
    			def compTotal=compDet.size()
    			def orphTotal=orphDet.size()
    			def abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate] ); 
    			def abc2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate]);
    			for(int g=0;g<abc2.size();g++)
    			{
    				allFour=abc2.get(g)
    				if(allFour)
    				{
    					appList.add(((ArrayList)allFour).get(0))
    				}
    			}
    			abc3=appList
    			total=abcR.size()
    			for(int p=0;p<abc3.size();p++)
    						{
    							def abcFinal=(abc3.get(p)).application.actualApplicationDate
    							if(abcFinal.getClass().getName()=="java.sql.Date")
    									{
    									(abc3.get(p)).application.actualApplicationDate=abcFinal
    									}
    								else
    								{
    							DateCustom dd=new DateCustom()
    							def xyz= dd.toDate(abcFinal)
    						(abc3.get(p)).application.actualApplicationDate=xyz
    								}
    						}
    			render(view:'popPageSummary',model:[level:level,orphList:orphList,pendList:pendList,compList:compList,abc3:abc3,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

def orphan={
    	 try {
    		def paramList
    			def orphList
    			def pendList
    			def compList
    			def abc
    			def abc3
    			def allFour= new ArrayList()
    			def appList= new ArrayList()
    			def pendingWithList= new ArrayList()
    			def rolependingWithList= new ArrayList()
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			Date date = new Date();
    			Calendar calendar = Calendar.getInstance();
    			calendar.add(Calendar.MONTH, -3);
    			Date date1 = new Date(dateFormat.format(calendar.getTime()));   
    			def dateF=date1
    			def checkDate=dateF
    			def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
    			def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
    			def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
    			def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
    			def recTotal=recDet.size()
    			def total
    			def pendTotal=pendDet.size()
    			def compTotal=compDet.size()
    			def orphTotal=orphDet.size()
    			def level
    			level="Unattended Applications"
    			def orphL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan' order by dateCheck.id desc", [checkDate]); 
    			abc=orphL
    				for(int u=0;u<abc.size();u++)
    				{
    					def abcFinal=(abc.get(u)).actualApplicationDate
    					if(abcFinal.getClass().getName()=="java.sql.Date")
    								{
    								(abc.get(u)).actualApplicationDate==abcFinal
    								}
    							else
    							{
    								DateCustom dd=new DateCustom()
    					def xyz= dd.toDate(abcFinal)
    				(abc.get(u)).actualApplicationDate=xyz
    							}
    				}	
    				total=orphTotal
    				render(view:'popPageSummary',model:[level:level,orphList:orphList,pendList:pendList,compList:compList,abc:abc,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
    		}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }

def completed={
    	 try {
    		def paramList
    			def orphList
    			def pendList
    			def compList
    			def abc
    			def abc3
    			def allFour= new ArrayList()
    			def appList= new ArrayList()
    			def pendingWithList= new ArrayList()
    			def rolependingWithList= new ArrayList()
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			Date date = new Date();
    			Calendar calendar = Calendar.getInstance();
    			calendar.add(Calendar.MONTH, -3);
    			Date date1 = new Date(dateFormat.format(calendar.getTime()));   
    			def dateF=date1
    			def checkDate=dateF
    			def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
    			def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
    			def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
    			def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
    			def recTotal=recDet.size()
    			def total
    			def pendTotal=pendDet.size()
    			def compTotal=compDet.size()
    			def orphTotal=orphDet.size()
    			def level
    			level="Completed Applications"
    				def compL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  order by dateCheck.id desc", [checkDate]);
    				for(int g=0;g<compL.size();g++)
    				{
    					allFour=compL.get(g)
    					if(allFour)
    					{
    						appList.add(((ArrayList)allFour).get(0))
    						pendingWithList.add(((ArrayList)allFour).get(1))
    								rolependingWithList.add((((ArrayList)allFour).get(1)).role)
    					}
    				}
    				abc=appList
    				for(int u=0;u<abc.size();u++)
    				{
    					def abcFinal=(abc.get(u)).actualApplicationDate
    						
    					if(abcFinal.getClass().getName()=="java.sql.Date")
    								{
    						(abc.get(u)).actualApplicationDate=abcFinal
    								}
    							else
    							{
    					DateCustom dd=new DateCustom()
    					def xyz= dd.toDate(abcFinal)
    				(abc.get(u)).actualApplicationDate=xyz
    							}
    				}	
    				total=compTotal
    				render(view:'popPageSummary',model:[rolependingWithList:rolependingWithList,level:level,orphList:orphList,pendList:pendList,compList:compList,abc:abc,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
    		}catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}

def pending={
    	 try {
    		def paramList
    			def orphList
    			def pendList
    			def compList
    			def abc
    			def abc3
    			def allFour= new ArrayList()
    			def appList= new ArrayList()
    			def pendingWithList= new ArrayList()
    			def rolependingWithList= new ArrayList()
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			Date date = new Date();
//////////////////////////////////get date three months back
    			Calendar calendar = Calendar.getInstance();
    			calendar.add(Calendar.MONTH, -3);
    			Date date1 = new Date(dateFormat.format(calendar.getTime()));   
    			def dateF=date1
    			def checkDate=dateF
    			def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
    			def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
    			def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
    			def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
    			def recTotal=recDet.size()
    			def total
    			def pendTotal=pendDet.size()
    			def compTotal=compDet.size()
    			def orphTotal=orphDet.size()
    			def level
    			level="Pending Applications"
    				def pendL=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  order by dateCheck.id desc", [checkDate]); 
    			for(int g=0;g<pendL.size();g++)
    				{
    					allFour=pendL.get(g)
    					if(allFour)
    					{
    						appList.add(((ArrayList)allFour).get(0))
    						pendingWithList.add(((ArrayList)allFour).get(1))
    						rolependingWithList.add((((ArrayList)allFour).get(1)).role)
    					}
    				}
    				abc=appList
    				for(int u=0;u<abc.size();u++)
    				{
    					def abcFinal=(abc.get(u)).actualApplicationDate
    					DateCustom dd=new DateCustom()
    						if(abcFinal.getClass().getName()=="java.sql.Date")
    								{
    									(abc.get(u)).actualApplicationDate=abcFinal
    								}
    								else
    								{
    								def xyz= dd.toDate(abcFinal)
    								System.out.println(xyz.getClass().getName()+xyz)
    							(abc.get(u)).actualApplicationDate=xyz
    	   					}
    				}	
    				total=pendTotal
    				render(view:'popPageSummary',model:[level:level,orphList:orphList,pendList:pendList,compList:compList,abc:abc,pendingWithList:pendingWithList,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal,rolependingWithList:rolependingWithList])
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
    }
    
def received={
    	 try {
    		def paramList
    			def orphList
    			def pendList
    			def compList
    			def abc
    			def abc3
    			def allFour= new ArrayList()
    			def appList= new ArrayList()
    			def pendingWithList= new ArrayList()
    			def rolependingWithList= new ArrayList()
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			Date date = new Date();
//    			 get date three months back
    			Calendar calendar = Calendar.getInstance();
    			calendar.add(Calendar.MONTH, -3);
    			Date date1 = new Date(dateFormat.format(calendar.getTime()));   
    			def dateF=date1
    			def checkDate=dateF
    			def recDet=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id",  [checkDate] )
    			def	orphDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck WHERE dateCheck.actualApplicationDate > ? and dateCheck.completionStatus='orphan'  ", [checkDate]); 
    			def	compDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus !='pending' and appPendDet.applicationStatus !='orphan'  ", [checkDate]);
    			def	pendDet=IndApplicationDetails.findAll("From IndApplicationDetails dateCheck, ApplicationPendingDetails appPendDet  WHERE dateCheck.id = appPendDet.application  and dateCheck.actualApplicationDate > ? and appPendDet.applicationStatus ='pending'  ", [checkDate]); 
    			def recTotal=recDet.size()
    			def total
    			def pendTotal=pendDet.size()
    			def compTotal=compDet.size()
    			def orphTotal=orphDet.size()
    			def level="Received Applications"
    			def abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate] ); 
    	    		def abc2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.completionStatus='completed' order by dateCheck.id desc",  [checkDate]);
    	    		for(int g=0;g<abc2.size();g++)
    				{
    					allFour=abc2.get(g)
    					if(allFour)
    					{
    						appList.add(((ArrayList)allFour).get(0))
    					}
    				}
    				abc3=appList
    	    		total=abcR.size()
    	    		for(int p=0;p<abc3.size();p++)
    							{
    								def abcFinal=(abc3.get(p)).application.actualApplicationDate
    								if(abcFinal.getClass().getName()=="java.sql.Date")
    									{
    									(abc3.get(p)).application.actualApplicationDate=abcFinal
    									}
    								else
    								{
    								DateCustom dd=new DateCustom()
    								def xyz= dd.toDate(abcFinal)
    							(abc3.get(p)).application.actualApplicationDate=xyz
    								}
    							}
    				render(view:'popPageSummary',model:[level:level,orphList:orphList,pendList:pendList,compList:compList,abc3:abc3,total:total,paramList:paramList,pendTotal:pendTotal,compTotal:compTotal,orphTotal:orphTotal,recTotal:recTotal])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}
    
def routeUnattended = {
    	 try {
    		def maxInt
    			def offsetInt
    			if(params.max)
    	   		{
    				maxInt=(params.max).toInteger()
    	   		}
    	   		else
    	   		{
    	   			maxInt=10
    	   		}
    	   		if(params.offset)
    	   		{
    	   			offsetInt=(params.offset).toInteger()
    	   		}
    	   		else
    	   		{
    	   			offsetInt=0
    	   		}
    			def indAppDetUnattendedListSize=IndApplicationDetails.findAll("from IndApplicationDetails as b where b.completionStatus='orphan' ");//IndApplicationDetails.findAllByCompletionStatus("orphan");
    			List indAppDetUnattendedList = IndApplicationDetails.findAll("from IndApplicationDetails as b where b.completionStatus='orphan' order by b.id desc ",[max:maxInt,offset:offsetInt]);//IndApplicationDetails.findAllByCompletionStatus("orphan");
    			def totalSize=indAppDetUnattendedListSize.size()
    			return[indAppDetUnattendedList:indAppDetUnattendedList,totalSize:totalSize]
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}
    
def updateGroups = {
    	 try {
    		if(params.cont != ""){
    				List grpList = GroupMaster.findAllByOffice(OfficeMaster.get(params.cont))
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp', from:grpList,class:'txt4')
    			}else{
    				render g.select( width:'10', optionKey:'id',  id:'grp',name:'grp', from:'',class:'txt4',noSelection:['':'Select Group'])
    			}
    		 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
	
def routeChecked = {
	 try {
		 println("params...."+params)
		  if(params.routeThese!=null && params.grp!="" && params.grp!=null  && params.officeId!="" && params.officeId!=null){
				if((params.routeThese).getClass().getName()== "java.lang.String"){
					GetData route = new GetData((params.routeThese).toInteger())
					def routed = route.routeApp(GroupMaster.get((params.grp).toInteger()))
					
					println("routed----"+routed)
					if(routed)
					flash.message="Routed successfully"
					else
						flash.message="Not Routed.Please select proper Group to Route the Application"	
				}else{
					
					for(int i=0;i<(params.routeThese).size();i++){
						GetData route = new GetData((params.routeThese[i]).toInteger())
						def routed = route.routeApp(GroupMaster.get((params.grp).toInteger()))
						
						println("routed----"+routed)
						if(routed)
						flash.message="Routed successfully"
						else
							flash.message="Not Routed.Please select proper Group to Route the Application"	
					}
					
				}
			}else if(params.routeThese==null){
				flash.message="Please Select The Checkbox"
			}else if(params.officeId=="" || params.officeId==null){
				flash.message="Please Select The Office to route"
			}else {
				flash.message="Please Select The Group to route"
			}
				
			
			redirect(action:routeUnattended)
		
				}catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
	 
	 redirect(controller:'indUser',action:'openIndustryHome')
	 }else if(session.userMaster){
	  
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	          
				session.invalidate()
	            redirect(uri:'/index.gsp');
	 }
	            }
}
    
def deleteUnattended={
    	 try {
    		if(params.routeThese!=null){
    	    	if((params.routeThese).getClass().getName()== "java.lang.String"){
    				def indappInstance=IndApplicationDetails.get((params.routeThese).toInteger())
    				if(indappInstance){
    					indappInstance.completionStatus="ignored"
    					indappInstance.save()
    				}
    			}else{
    				for(int i=0;i<(params.routeThese).size();i++){
    					def indappInstance= IndApplicationDetails.get((params.routeThese[i]).toInteger())
    					if(indappInstance){
    						indappInstance.completionStatus="ignored"
    						indappInstance.save()
    					}
    				}
    	    }
    	    	flash.message="Deleted Successfully"
    	    	}else{
    	    		flash.message="Please Select The Checkbox to delete the application"
    	    	}
    	    	redirect(action:routeUnattended)
    	 }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 } 
  	   
 def searchPrint = {
    	 try {
    		def xyz5
    	   		def qwe
    	   		if(params.max)
    	   		{
    	   			xyz5=(params.max).toInteger()
    	   		}
    	   		else
    	   		{
    	   			xyz5=10
    	   		}
    	   		if(params.offset)
    	   		{
    	   			qwe=(params.offset).toInteger()
    	   		}
    	   		else
    	   		{
    	   			qwe=0
    	   		}
    	    	def paramList= new ArrayList()
    	    	paramList=params
    	   		def appList= new ArrayList()
    			def allFour= new ArrayList()
    				def abc1= new ApplicationPendingDetails()
    	   		def abcR= new IndApplicationDetails()
    				int total;
    	    	def startDate1=params.start_date
    				def endDate1=params.end_date
    				def x
    				def y
    				def totalRes
    				def categories
    				def checkDate=null
    			if(params.category != "xyz")
    			{
    				categories=(params.category).toLong()
    			}
    			else
    			{
    				categories = params.category
    			}
    			def status=params.status 		
    	    	try
    			{
    				def sdfh = new SimpleDateFormat("MM/dd/yyyy"); 
    				x = sdfh.parse(startDate1); //Date
    				y = sdfh.parse(endDate1);  //Date
    				checkDate="checked"
    			}
    			catch(Exception e)
    			{
    				flash.message="Enter Both The Dates in Correct Format "
    				redirect(action:searchPage)
    			}	
    			if(checkDate)
    			{
    			java.sql.Date sqlDate = new java.sql.Date(x.getTime())
    			java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
    			sqlDate2.setDate((sqlDate2.getDate()+1))
    		if(startDate1 && endDate1 && categories=="xyz" && status=="xyz")
    						{
    				abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.actualApplicationDate <= ? order by dateCheck.id desc",  [sqlDate,sqlDate2]); 
    							def var1=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate >= ? and dateCheck.actualApplicationDate <= ? order by dateCheck.id desc",  [sqlDate,sqlDate2] ); 
    	    		            total=abcR.size()
    	    		            for(int g=0;g<var1.size();g++)
    							{
    								allFour=var1.get(g)
    								if(allFour)
    								{
    									appList.add(((ArrayList)allFour).get(0))
    								}
    							}
    							abc1=appList
    							for(int p=0;p<abc1.size();p++)
    							{
    								def abcFinal=(abc1.get(p)).application.actualApplicationDate
    								if(abcFinal.getClass().getName()=="java.sql.Date")
    									{
    									(abc1.get(p)).application.actualApplicationDate=abcFinal
    									}
    								else
    								{
    								DateCustom dd=new DateCustom()
    								def xyz= dd.toDate(abcFinal)
    							(abc1.get(p)).application.actualApplicationDate=xyz
    								}
    						}
    	    				}
    	    		 	if(startDate1 && endDate1 && categories != "xyz" && status=="xyz")
    						{
    	    				abcR=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.id = ? order by dateCheck.id desc ", [sqlDate,sqlDate2,categories]);
    							def var2=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.id = ? order by dateCheck.id desc ", [sqlDate,sqlDate2,categories]);
    							total=abcR.size()
    							for(int g=0;g<var2.size();g++)
    							{
    								allFour=var2.get(g)
    								if(allFour)
    								{
    									appList.add(((ArrayList)allFour).get(0))
    								}
    							}
    							abc1=appList
    							for(int r=0;r<abc1.size();r++)
    							{
    								def abcFin=(abc1.get(r)).application.actualApplicationDate
    								if(abcFin.getClass().getName()=="java.sql.Date")
    									{
    									(abc1.get(r)).application.actualApplicationDate=abcFin
    									}
    								else
    								{
    								DateCustom dd1=new DateCustom()
    								def xyz1= dd1.toDate(abcFin)
    								(abc1.get(r)).application.actualApplicationDate=xyz1
    							}
    							}
    						}	
    						if(startDate1 && endDate1 && categories != "xyz" && status != "xyz" )
    						{
    							def nis
    							def xyz
    						nis=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.id = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status]); 
    						xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and dateCheck.indUser.category.id = ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,categories,status]); 
    						for(int g=0;g<xyz.size();g++)
    							{
    								allFour=xyz.get(g)
    								if(allFour)
    								{
    									appList.add(((ArrayList)allFour).get(0))
    								}
    							}
    							abc1=appList
    						total=nis.size()
    							for(int d=0;d<abc1.size();d++)
    							{
    								def abcFina=(abc1.get(d)).application.actualApplicationDate
    								if(abcFina.getClass().getName()=="java.sql.Date")
    									{
    									(abc1.get(d)).application.actualApplicationDate=abcFina
    									}
    								else
    								{
    								DateCustom dd2=new DateCustom()
    								def xyz2= dd2.toDate(abcFina)
    							(abc1.get(d)).application.actualApplicationDate=xyz2
    								
    								}
    							}
    	    		}
    	    			if(startDate1 && endDate1 && categories == "xyz" && status != "xyz" )
    						{
    							def ewq
    							def xyz
    				ewq=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status]); 
    				xyz=ApplicationPendingDetails.findAll("From ApplicationPendingDetails appPendDet,IndApplicationDetails dateCheck WHERE appPendDet.application= dateCheck.id and dateCheck.actualApplicationDate > ? and dateCheck.actualApplicationDate < ? and appPendDet.applicationStatus = ? order by dateCheck.id desc", [sqlDate,sqlDate2,status]); 
    					for(int a=0;a<xyz.size();a++)
    							{
    								allFour=xyz.get(a)
    								if(allFour)
    								{
    									appList.add(((ArrayList)allFour).get(0))
    								}
    							}
    	        			abc1=appList
    	        			total=ewq.size()
    	        			for(int k=0;k<abc1.size();k++)
    							{
    								def abcFinl=(abc1.get(k)).application.actualApplicationDate
    								if(abcFinl.getClass().getName()=="java.sql.Date")
    									{
    									(abc1.get(k)).application.actualApplicationDate=abcFinl
    									}
    								else
    								{
    								DateCustom dd3=new DateCustom()
    								def xyz3= dd3.toDate(abcFinl)
    								
    								(abc1.get(k)).application.actualApplicationDate=xyz3
    								}
    							}
    						}
    	    		if(abc1.size()==0)
    	    				{
    	    					flash.message="No Result Found With This Search Combination"
    	    				}
    	    				if(sqlDate>sqlDate2)
    						{
    							flash.message="End Date should be Greater than Starting Date"
    						}	
    	    				render(view:'popSearchPrint',model:[abc1:abc1,total:total,paramList:paramList])
    			}
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}
    
def printConditionalPage={
    	 try {
    	def listValue=params.listVal
    	    	def listToPrint= new ArrayList()
    	    	def today=new Date()
    	    	def diffList= new ArrayList()
    	    	def level=params.level
    	    	def levlPrint
    	    	if(level=="less7"){
    	    		levlPrint="Application Pending since 7 days or Less"
    	    	}else if(level=="bet7to15"){
    	    		levlPrint="Application Pending since between 7 to 15 days"
    	    	}else {
    	    		levlPrint="Application Pending since 15 days or more"
    	    	}
    	    int sizeVal
    	    	def conLong
    	    	if(listValue){
    	    	if(listValue.getClass().getName()=="java.lang.String")
    	    	{
    	    		sizeVal=1
    	    	}
    	    	else{
    	    		sizeVal=listValue.size()
    	    	}
    	    	for(int i=0;i<sizeVal;i++){
    	    		if(listValue.getClass().getName()=="java.lang.String")
    	        	{
    	    			conLong=listValue.toInteger()
    	    		}
    	        	else{
    	        		conLong=listValue[i].toInteger()
    	        	}
    	    		def instance=IndApplicationDetails.get(conLong)
    	    		def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(instance,[max:1,sort:"lastUpdated", order:"desc"])
    	    					def abcFinal=instance.actualApplicationDate
    							if(appProcessingInstance)
    							{
    								def appProcessingTime=appProcessingInstance[0].lastUpdated
    								long diff = today.getTime() - appProcessingTime.getTime();
    								int diffDays=diff / (1000*60*60*24)
    								diffList.add(diffDays.toString())
    								abcFinal=appProcessingTime
    							}else{
    							long diff = today.getTime() - abcFinal.getTime();
    							int diffDays=diff / (1000*60*60*24)
    							diffList.add(diffDays.toString())
    	    	}
    	    		DateCustom dd=new DateCustom()
    				if(abcFinal.getClass().getName()=="java.sql.Date")
    						{
    							instance.actualApplicationDate=abcFinal
    						}
    						else
    						{
    						def xyz= dd.toDate(abcFinal)
    					instance.actualApplicationDate=xyz
    						}
    	    		listToPrint.add(instance)
    	    	}
    	    }
    	    	render(view:'printConditionalPage',model:[listVal:listToPrint,diffList:diffList,levlPrint:levlPrint])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
    
def printConditionalPageUnattended={
    	 try {
    		def listValue=params.listVal
    	    	def listToPrint= new ArrayList()
    	    	def today=new Date()
    	    	def diffList= new ArrayList()
    	    	def level=params.level
    	    	def levlPrint
    	    	if(level=="less7"){
    	    		levlPrint="Application not attended since 7 days or Less"
    	    	}else if(level=="bet7to15"){
    	    		levlPrint="Application not attended since between 7 to 15 days"
    	    	}else {
    	    		levlPrint="Application not attended since 15 days or more"
    	    	}
    	    	int sizeVal
    	    	def conLong
    	    	if(listValue){
    	    	if(listValue.getClass().getName()=="java.lang.String")
    	    	{
    	    		sizeVal=1
    	    	}
    	    	else{
    	    		sizeVal=listValue.size()
    	    	}
    	    	for(int i=0;i<sizeVal;i++){
    	    		if(listValue.getClass().getName()=="java.lang.String")
    	        	{
    	    			conLong=listValue.toInteger()
    	    		}
    	        	else{
    	        		conLong=listValue[i].toInteger()
    	        	}
    	    		def instance=IndApplicationDetails.get(conLong)
    	    		def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(instance,[max:1,sort:"lastUpdated", order:"desc"])
    	    					def abcFinal=instance.actualApplicationDate
    							if(appProcessingInstance)
    							{
    								def appProcessingTime=appProcessingInstance[0].lastUpdated
    								long diff = today.getTime() - appProcessingTime.getTime();
    								int diffDays=diff / (1000*60*60*24)
    								diffList.add(diffDays.toString())
    								abcFinal=appProcessingTime
    							}else{
    							long diff = today.getTime() - abcFinal.getTime();
    							int diffDays=diff / (1000*60*60*24)
    							diffList.add(diffDays.toString())
    	    	}
    	    		DateCustom dd=new DateCustom()
    				if(abcFinal.getClass().getName()=="java.sql.Date")
    						{
    							instance.actualApplicationDate=abcFinal
    						}
    						else
    						{
    						def xyz= dd.toDate(abcFinal)
    					instance.actualApplicationDate=xyz
    						}
    	    		listToPrint.add(instance)
    	    	}
    	    	}
    	    	render(view:'printConditionalPageUnattended',model:[listVal:listToPrint,diffList:diffList,levlPrint:levlPrint])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
    
def searchPrintPending={
    	 try {
    		def listValue=params.listVal
    	    	def listToPrint= new ArrayList()
    	    	def today=new Date()
    	    	def diffList= new ArrayList()
    	    	def level=params.level
    	    	def endDate=session.endDate1ForPrint
    	    	def startDate=session.startDateForPrint
    	    	
    	    	def levlPrint
    	    	def dtDuration
    	    	if(level=="less7"){
    	    		levlPrint="Application not attended since 7 days or Less"
    	    		dtDuration=" Application  from"+startDate+" to Date"+endDate
    	    	}else if(level=="bet7to15"){
    	    		levlPrint="Application not attended since between 7 to 15 days"
    	    		dtDuration=" Application  from"+startDate+" to Date"+endDate
    	    	}else {
    	    		levlPrint="Application not attended since 15 days or more"
    	    		dtDuration=" Application  from "+startDate+" to Date "+endDate
    	    	}
    	    	int sizeVal
    	    	def conLong
    	    	if(listValue){
    	    	if(listValue.getClass().getName()=="java.lang.String")
    	    	{
    	    		sizeVal=1
    	    	}
    	    	else{
    	    		sizeVal=listValue.size()
    	    	}
    	    	for(int i=0;i<sizeVal;i++){
    	    		if(listValue.getClass().getName()=="java.lang.String")
    	        	{
    	    			conLong=listValue.toInteger()
    	    		}
    	        	else{
    	        		conLong=listValue[i].toInteger()
    	        	}
    	    		def instance=ApplicationPendingDetails.get(conLong)
    	    		def appPendInstance=instance.application
    	    		def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(appPendInstance,[max:1,sort:"lastUpdated", order:"desc"])
    	    					def abcFinal=instance.application.actualApplicationDate
    							if(appProcessingInstance)
    							{
    								def appProcessingTime=appProcessingInstance[0].lastUpdated
    								long diff = today.getTime() - appProcessingTime.getTime();
    								int diffDays=diff / (1000*60*60*24)
    								diffList.add(diffDays.toString())
    								abcFinal=appProcessingTime
    							}else{
    							long diff = today.getTime() - abcFinal.getTime();
    							int diffDays=diff / (1000*60*60*24)
    							diffList.add(diffDays.toString())
    	    	}
    	    		DateCustom dd=new DateCustom()
    				if(abcFinal.getClass().getName()=="java.sql.Date")
    						{
    							instance.application.actualApplicationDate=abcFinal
    						}
    						else
    						{
    						def xyz= dd.toDate(abcFinal)
    					instance.application.actualApplicationDate=xyz
    						}
    	    		listToPrint.add(instance)
    	    	}
    	    	}
    	    	render(view:'searchPrintPending',model:[listVal:listToPrint,diffList:diffList,levlPrint:levlPrint,dtDuration:dtDuration])
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}
    
def printCondUnattended={
    	 try {
    		def listValue=params.listVal
    	    	def listToPrint= new ArrayList()
    	    	def today=new Date()
    	    	def diffList= new ArrayList()
    	    	def level=params.level
    	    	def levlPrint
    	    	if(level=="less7"){
    	    		levlPrint="Application not attended since 7 days or Less"
    	    	}else if(level=="bet7to15"){
    	    		levlPrint="Application not attended since between 7 to 15 days"
    	    	}else {
    	    		levlPrint="Application not attended since 15 days or more"
    	    	}
    	    	int sizeVal
    	    	def conLong
    	    	if(listValue){
    	    	if(listValue.getClass().getName()=="java.lang.String")
    	    	{
    	    		sizeVal=1
    	    	}
    	    	else{
    	    		sizeVal=listValue.size()
    	    	}
    	    	for(int i=0;i<sizeVal;i++){
    	    		if(listValue.getClass().getName()=="java.lang.String")
    	        	{
    	    			conLong=listValue.toInteger()
    	    		}
    	        	else{
    	        		conLong=listValue[i].toInteger()
    	        	}
    	    		def instance=IndApplicationDetails.get(conLong)
    	    		def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(instance,[max:1,sort:"lastUpdated", order:"desc"])
    	    				def abcFinal=instance.actualApplicationDate
    							if(appProcessingInstance)
    							{
    								def appProcessingTime=appProcessingInstance[0].lastUpdated
    								long diff = today.getTime() - appProcessingTime.getTime();
    								int diffDays=diff / (1000*60*60*24)
    								diffList.add(diffDays.toString())
    								abcFinal=appProcessingTime
    							}else{
    							long diff = today.getTime() - abcFinal.getTime();
    							int diffDays=diff / (1000*60*60*24)
    							diffList.add(diffDays.toString())
    	    	}
    	    		DateCustom dd=new DateCustom()
    				if(abcFinal.getClass().getName()=="java.sql.Date")
    						{
    							instance.actualApplicationDate=abcFinal
    						}
    						else
    						{
    						def xyz= dd.toDate(abcFinal)
    					instance.actualApplicationDate=xyz
    					}
    	    		listToPrint.add(instance)
    	    	}
    	    	}
    	    	render(view:'printCondUnattended',model:[listVal:listToPrint,diffList:diffList,levlPrint:levlPrint])
    	     }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
 }
    
def printAllCriteriasList={
    	 try {
    		def listValue=params.listVal
    	    	def listToPrint= new ArrayList()
    	    	def today=new Date()
    	    	def diffList= new ArrayList()
    	    	int sizeVal
    	    	def conLong
    	    	if(listValue){
    	    	if(listValue.getClass().getName()=="java.lang.String")
    	    	{
    	    		sizeVal=1
    	    	}
    	    	else{
    	    		sizeVal=listValue.size()
    	    	}
    	    	for(int i=0;i<sizeVal;i++){
    	    		if(listValue.getClass().getName()=="java.lang.String")
    	        	{
    	    			conLong=listValue.toInteger()
    	    		}
    	        	else{
    	        		conLong=listValue[i].toInteger()
    	        	}
    	    		def instance=ApplicationPendingDetails.get(conLong)
    	    		def appPendInstance=instance.application
    	    		def appProcessingInstance=ApplicationProcessingDetails.findAllByApplication(appPendInstance,[max:1,sort:"lastUpdated", order:"desc"])
    	    				def abcFinal=instance.application.actualApplicationDate
    							if(appProcessingInstance)
    							{
    								def appProcessingTime=appProcessingInstance[0].lastUpdated
    								long diff = today.getTime() - appProcessingTime.getTime();
    								int diffDays=diff / (1000*60*60*24)
    								diffList.add(diffDays.toString())
    								abcFinal=appProcessingTime
    							}else{
    							long diff = today.getTime() - abcFinal.getTime();
    							int diffDays=diff / (1000*60*60*24)
    							diffList.add(diffDays.toString())
    	    	}
    	    		DateCustom dd=new DateCustom()
    				if(abcFinal.getClass().getName()=="java.sql.Date")
    						{
    							instance.application.actualApplicationDate=abcFinal
    						}
    						else
    						{
    						def xyz= dd.toDate(abcFinal)
    					instance.application.actualApplicationDate=xyz
    					}
    	    		listToPrint.add(instance)
    	    	}
    	    	}
    	    	render(view:'printAllCriteriasList',model:[listVal:listToPrint,diffList:diffList])
    	    }catch(Exception e) {
    	            e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
    				if(session.indUser){
    			redirect(controller:'indUser',action:'openIndustryHome')
    	 }
    	 else if(session.userMaster){
    	  redirect(controller:'userMaster',action:'openSpcbHome');
    	 }else{
    	        session.invalidate()
    	        redirect(uri:'/index.gsp');
    	 }
    	   }
}
    			
}				
				
      
