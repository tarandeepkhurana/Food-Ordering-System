package FOS.pack1;

import java.util.HashMap;
public class IdandPasswords {
    private HashMap<String,String> logininfo = new HashMap<String,String>();
	IdandPasswords(){
		
		logininfo.put("tsk","smart");
		logininfo.put("pj","dumb");
		logininfo.put("tv","good");
	}
	
      protected HashMap getLoginInfo(){
		return logininfo;
	}
    
}

