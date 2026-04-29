package model;

import enums.Language;
import enums.RequestStatus;

public class TechSupporter extends Employee{

    public TechSupporter(String id, String name, String username, String password, Language language, String empId, String department) {
        super(id, name, username, password, language, empId, department);
    }

    public void workWithReq(Request r,RequestStatus rs){
        System.out.println("TechSupporter changed status of request");
        r.setStatus(rs);
    }

}
