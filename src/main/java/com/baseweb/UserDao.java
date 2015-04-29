package com.baseweb;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField="", table="user")
public class UserDao {

    /**
     */
    private String user_id;

    /**
     */
    private String password;
}
