package FOS.pack1;

import java.util.HashMap;
public class IdandPasswords {
    private HashMap<String,String> logininfo = new HashMap<String,String>();
	IdandPasswords(){
		
		logininfo.put("TSK","smart");
		logininfo.put("PJ","dumb");
		logininfo.put("TV","good");
	}
	
      protected HashMap getLoginInfo(){
		return logininfo;
	}
    
}

