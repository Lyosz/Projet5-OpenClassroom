package com.safetynet.webmicroservice.constants;

public class DBConstants {

	public static final String SAVE_PERSON = "insert into person(FIRSTNAME, LASTNAME, ADDRESS, CITY, ZIP, PHONE, EMAIL) values(?,?,?,?,?,?,?)";
    public static final String UPDATE_PERSON = "update person set ADDRESS=?, CITY=?, ZIP=?, PHONE=?, EMAIL=? where FIRSTNAME=? and LASTNAME=?";
    public static final String GET_PERSON = "select p.FIRSTNAME, p.LASTNAME, p.ADDRESS, p.CITY, p.ZIP, p.PHONE, p.EMAIL from person p where p.firstname=? and p.lastname=?";
    public static final String DELETE_PERSON = "delete person where FIRSTNAME=? and LASTNAME=?";
    
    public static final String SAVE_FIRESTATION = "insert into firestation(ADDRESS, STATION) values(?,?)";
    public static final String UPDATE_FIRESTATION = "update firestation set STATION=? where ADDRESS=? or STATION=?";
    public static final String GET_FIRESTATION = "select f.ADDRESS, f.STATION from firestation f where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? order by t.IN_TIME";
    public static final String DELETE_FIRESTATION = "delete firestation where STATION=? or ADDRESS=?";
    
    public static final String SAVE_MEDICALRECORD = "insert into person.medicalrecord(BIRTHDAY, MEDICATIONS, ALLERGIES) values(?,?,?), where FIRSTNAME=? and LASTNAME=?";
    public static final String UPDATE_MEDICALRECORD = "update medicalrecord set PRICE=?, OUT_TIME=? where FIRSTNAME=? and LASTNAME=?";
    public static final String GET_MEDICALRECORD = "select p.FIRSTNAME, p.LASTNAME, p.m.BIRTHDAY, p.m.MEDICATIONS, p.m.ALLERGIES from person p,medicalrecord m where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? order by t.IN_TIME";
    public static final String DELETE_MEDICALRECORD = "delete person.medicalrecord where FIRSTNAME=? and LASTNAME=?";
    
}


