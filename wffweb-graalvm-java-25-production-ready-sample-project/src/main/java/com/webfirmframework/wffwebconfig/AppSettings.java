package com.webfirmframework.wffwebconfig;

import com.webfirmframework.wffweb.server.page.BrowserPageContext;
import com.webfirmframework.wffwebconfig.server.constants.ServerConstants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppSettings {
    
    public static final ExecutorService VIRTUAL_THREAD_EXECUTOR = Executors.newVirtualThreadPerTaskExecutor();
    
    static {
    	BrowserPageContext.INSTANCE.enableAutoClean(ServerConstants.SESSION_TIMEOUT_MILLISECONDS, VIRTUAL_THREAD_EXECUTOR);
    }
    
}
