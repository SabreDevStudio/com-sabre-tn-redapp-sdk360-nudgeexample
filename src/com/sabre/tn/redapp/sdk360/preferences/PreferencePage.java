package com.sabre.tn.redapp.sdk360.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sabre.tn.redapp.sdk360.nudgeexample.Activator;



public class PreferencePage  extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {
	
	
	public PreferencePage() {
		// TODO Auto-generated constructor stub
		super(GRID); 
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the Settings for the Nudge Component");
		
		
	}

	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		
		addField(new StringFieldEditor(PreferenceInitializer.DESTINATION_CITY,"Choose The Destination City ", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceInitializer.NUDGE_TEXT,"Choose The Nudge Text ", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceInitializer.NUDGE_ACTION_TEXT,"Choose The Nudge action text ", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceInitializer.NUDGE_ACTION_BUTTON_TEXT,"Choose The Nudge Button Label ", getFieldEditorParent()));
		
	}
	
	
	
	
	


}
