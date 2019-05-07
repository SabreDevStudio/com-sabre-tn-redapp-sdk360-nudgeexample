package com.sabre.tn.redapp.sdk360.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sabre.tn.redapp.sdk360.nudgeexample.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	
	public final static String DESTINATION_CITY ="DESTINATION CITY" ; 
	public final static String NUDGE_TEXT="NUDGE TEXT"; 
	public final static String NUDGE_ACTION_TEXT ="NUDGE ACTION TEXT "; 
	public final static String NUDGE_ACTION_BUTTON_TEXT ="NUDGE BUTTON TEXT"; 
	
	
	@Override
	public void initializeDefaultPreferences() {
		// TODO Auto-generated method stub
		
		// set default Pref Options 
		
	IPreferenceStore Store = Activator.getDefault().getPreferenceStore(); 
	
	Store.setDefault(DESTINATION_CITY,"MVD");
	Store.setDefault(NUDGE_TEXT,"MORE OFFERS");
	Store.setDefault(NUDGE_ACTION_TEXT,"NUDGE ACTION CLICKED ");
	Store.setDefault(NUDGE_ACTION_BUTTON_TEXT,"CLICK HERE");

	}

}
