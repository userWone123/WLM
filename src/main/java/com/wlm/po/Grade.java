package com.wlm.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 86182
 * @create 2019-11-20-11:22
 */
@Entity
public class Grade {
    private int gid;
    private String gname;

    @Id
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }



    @Basic
    @Column(name = "gname")
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}

       Grade grade = (Grade) o;

        if (gid != grade.gid) {return false;}
        if (gname != null ? !gname.equals(grade.gname) : grade.gname != null){ return false;}

        return true;
    }
    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        return result;
    }
}
