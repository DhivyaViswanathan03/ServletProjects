package com.divs.Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class RequestAttributeListenerDemo
 *
 */
public class RequestAttributeListenerDemo implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public RequestAttributeListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+" attribute is removed");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println(srae.getName()+" attribute is added");
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
        System.out.println(srae.getName()+" attribute is replaced");
    }
	
}
