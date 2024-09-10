import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class TimerExampleController {

	public void hello(){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TaskExampleRepeating(),1000*60*5, 1000*60*60*24);//5 minute and 24 hour
		//timer.scheduleAtFixedRate(new TaskExampleRepeating(),1000,1000 * 60 * 2)
	}
}
 class TaskExampleRepeating extends TimerTask{
	@Override
	public void run(){
		NoticeReminderController noticeReminder=new NoticeReminderController();
		try{
		//	noticeReminder.moveConsentAppAfter10Days();
		}catch(Exception e){}
		
		try{
			   println("Inside TimerExampleController sendStatusToSingle method start=========")
				noticeReminder.sendStatusToSingle();
			   println("Inside TimerExampleController sendStatusToSingle method end=========")
	       }catch(Exception e){}
       
       
       
        //======================================================================
        
        ///=======================================================================
 	  }
  }