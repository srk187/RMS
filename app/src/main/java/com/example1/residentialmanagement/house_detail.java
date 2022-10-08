package com.example1.residentialmanagement;

public class house_detail {
    private String houseno,htype, memberNo;

    public house_detail() {
    }

    public house_detail(String houseno, String htype, String memberNo) {
        this.houseno = houseno;
        this.htype = htype;
        this.memberNo = memberNo;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getHtype() {
        return htype;
    }

    public void setHtype(String htype) {
        this.htype = htype;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
}
