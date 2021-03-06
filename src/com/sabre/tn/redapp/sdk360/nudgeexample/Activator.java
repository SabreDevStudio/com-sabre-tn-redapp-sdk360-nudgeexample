package com.sabre.tn.redapp.sdk360.nudgeexample;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sabre.edge.platform.core.common.plugin.base.AbstractEdgeBasePlugin;
import com.sabre.edge.platform.optional.notifications.INotificationService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractEdgeBasePlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "NudgeExample"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	  private INotificationService notifService;
	  
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	
	  public INotificationService getNotificationService() {
	         return notifService;
	  }

}
