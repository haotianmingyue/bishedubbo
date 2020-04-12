package com.haotian.api.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Account")
public class Account implements Serializable {
    @Id
    private long userID;  //注意首字母小写 dao层findbyID 之类的 select 是 userID 。 如果你是UserID会找不到对象
    @Column
    private String userPass;
    @Column
    private String userRole;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    //    @Override
//    public String toString() {
//        return "Account{" +
//                "UserID=" + UserID +
//                ", UserPass='" + UserPass + '\'' +
//                ", UserRole='" + UserRole + '\'' +
//                '}';
//    }

}
