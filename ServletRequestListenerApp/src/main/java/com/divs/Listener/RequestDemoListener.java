package com.divs.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


public class RequestDemoListener implements ServletRequestListener {
	public static int count=0;

static {
	System.out.println("Listener is loading..");
}
    public RequestDemoListener() {
       System.out.println("Listener is instantiated..");
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
       System.out.println("Listener is destroyed..");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	count++;
         System.out.println("listener is initialized");
         System.out.println("Hit count is::"+count);
    }
	
}
