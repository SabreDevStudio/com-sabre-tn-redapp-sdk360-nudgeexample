package com.sabre.tn.redapp.sdk360.nudgeservices;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;







import com.sabre.edge.platform.core.ui.threading.UiThreadInvoker;
import com.sabre.edge.platform.optional.notifications.INotificationService;
import com.sabre.edge.platform.optional.notifications.types.Notification;
import com.sabre.edge.platform.optional.notifications.types.Priority;
import com.sabre.edge.platform.optional.notifications.types.SideBarColor;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointCommand;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointRequestWrapper;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeActionRQ;
import com.sabre.tn.redapp.sdk360.nudgeexample.Activator;
import com.sabre.tn.redapp.sdk360.preferences.*;

public class NudgeActionServiceImp implements NudgeActionService {

	@Override
	public FlowExtPointCommand execute(FlowExtPointCommand extPointCommand) {
		// TODO Auto-generated method stub
		
		
		for (FlowExtPointRequestWrapper req : extPointCommand.getRequests() ){
			
			if(req.getRequest() instanceof RedAppNudgeActionRQ ){
				
				RedAppNudgeActionRQ nudgeaction =(RedAppNudgeActionRQ)req.getRequest() ; 
				
			     if(nudgeaction.getActionId().equals("NudgeAction")){
			    	 
			    	 IPreferenceStore store =Activator.getDefault().getPreferenceStore() ; 
			    
			    	 /*
			    	  * 
			    	
			   System.out.println(store.getString(PreferenceInitializer.DESTINATION_CITY));
			   System.out.println(store.getString(PreferenceInitializer.NUDGE_ACTION_TEXT));
			   System.out.println(store.getString(PreferenceInitializer.NUDGE_TEXT));
			    	  */ 
			    	 ShowNotification();
			    	 
			    	 
			     }
				
			}
		}
		
		
		return extPointCommand;
	}
	
	
	private void ShowNotification(){
		
		/*
		 * Get Text from default prefs Store 
		 */
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore()  ; 
		
	    final Notification notification = new Notification();
	    notification.setWindowTitle("Nudge Action ");
	    notification.setPriority(Priority.LOW);
	    notification.setContent(store.getString(PreferenceInitializer.NUDGE_ACTION_TEXT));
	    notification.setLeftSideBarColor(SideBarColor.GREEN);
	    notification.setNotificationTime(30000);
	    
		final INotificationService svc = Activator.getDefault().getServiceReference(INotificationService.class);
		
		
	     UiThreadInvoker <Object> invoker = new UiThreadInvoker <Object>() {
	            protected Object invoke() {
	             svc.createNotification(notification);
	                return null;
	            }
	        };
	        invoker.asyncExec();
		
		
	}
	
	

}
