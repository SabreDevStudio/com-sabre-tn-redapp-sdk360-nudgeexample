package com.sabre.tn.redapp.sdk360.nudgeservices;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointCommand;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointDataOperation;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointRequestWrapper;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointResponse;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointResponseWrapper;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeAction;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeInitEntry;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeInitRQ;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeInitRS;
import com.sabre.stl.pos.srw.nextgen.redapp.nudge.v1.RedAppNudgeItem;
import com.sabre.tn.redapp.sdk360.nudgeexample.Activator;
import com.sabre.tn.redapp.sdk360.preferences.PreferenceInitializer;

public class NudgeInitServiceImp implements NudgeInitService {
	
	
//	private static String DESTINATION ="MVD"; 
	//private static String NUDGETEXT ="OFFERS FOR MVD !! "; 

	@Override
	public FlowExtPointCommand execute(FlowExtPointCommand extPointCommand) {
		// TODO Auto-generated method stub
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore()  ;
		RedAppNudgeInitRQ nudgeRequest = getNudgeRequest(extPointCommand) ; 

		if(nudgeRequest!=null){
			
			for(RedAppNudgeInitEntry entry : nudgeRequest.getEntries()){
			
				
				
				if(entry.getDestination().equals(store.getString(PreferenceInitializer.DESTINATION_CITY))){
					
					RedAppNudgeInitRS response = new RedAppNudgeInitRS();
					
					
					RedAppNudgeItem nudgeItem = new RedAppNudgeItem();
					
					nudgeItem.setMessage(store.getString(PreferenceInitializer.NUDGE_TEXT));
					
					RedAppNudgeAction nudgeAction = new RedAppNudgeAction() ; 
					
					nudgeAction.setId("NudgeAction");
					nudgeAction.setLabel(store.getString(PreferenceInitializer.NUDGE_ACTION_BUTTON_TEXT));
					
					nudgeItem.getAction().add(nudgeAction); 
					
					response.getItem().add(nudgeItem); 
					
					
					// add our Nudge Response to the extPoint response 
					
					      FlowExtPointResponseWrapper wrapper = new FlowExtPointResponseWrapper();
				        wrapper.setResponse(new FlowExtPointResponse());
				        wrapper.getResponse().setStructure(response);
				        wrapper.setOperation(FlowExtPointDataOperation.ADD);
					
					  extPointCommand.getResponses().add(wrapper);
				}
				
			}
		}
		
	
		
		return extPointCommand;
	}
	
	
	private RedAppNudgeInitRQ getNudgeRequest(FlowExtPointCommand  extPointCommand){
		
		for ( FlowExtPointRequestWrapper req:   extPointCommand.getRequests()){
			
			if(req.getRequest() instanceof RedAppNudgeInitRQ ){
				
				RedAppNudgeInitRQ  nudgeRequest = (RedAppNudgeInitRQ ) req.getRequest()  ; 
				
				
				return nudgeRequest ; 
				
			}
			
		}
		
		
		return null; 
	}

}
