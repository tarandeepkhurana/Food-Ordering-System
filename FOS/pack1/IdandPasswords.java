package FOS.pack1;

import java.util.HashMap;
public class IdandPasswords {
    private HashMap<String,String> logininfo = new HashMap<String,String>();
	IdandPasswords(){
		
		logininfo.put("Bro","pizza");
		logininfo.put("Brometheus","PASSWORD");
		logininfo.put("BroCode","abc123");
	}
	
      protected HashMap getLoginInfo(){
		return logininfo;
	}
    
}

