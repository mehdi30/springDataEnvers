package Audit.configs;



import java.security.Principal;
import java.util.Date;
import java.util.Optional;

import javax.annotation.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import ch.qos.logback.classic.Logger;



public class AuditRevisionListener implements RevisionListener {



	

   @Override
   public void newRevision(Object revisionEntity) {
       //String uname = SecurityContextHolder.getContext().getAuthentication().getName();
	   //String uname ;

	 /*  String uname;
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    if (principal instanceof UserDetails) {
	    	uname = ((UserDetails) principal).getUsername();
		    System.out.println(uname +"               "+principal);

	    } else {
	    	uname = principal.toString();
		    System.out.println(uname +"               "+principal);

	    }    	*/  
       // System.out.println("data"+ uname);
       
       
       AuditRevisionEntity audit = (AuditRevisionEntity) revisionEntity;
      // audit.setUsername(uname);
       audit.setLastmodifiedAt(new Date());
   }
}