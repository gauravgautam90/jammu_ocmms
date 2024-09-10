class BootStrap {

     def init = {
    	     servletContext ->
    	     TimerExampleController timer =new TimerExampleController();
    	     timer.hello();
    	  
    	     }
     def destroy = {
     }
} 