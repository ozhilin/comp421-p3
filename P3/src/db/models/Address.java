package db.models;

import java.sql.ResultSet;

import db.util.QueryHelper;

public class Address {
	public int aid;

	public int num;
	public String street;
	public Integer apartmentNumber;
	public String postalCode;
	public String city;
	public String province;
	public String country;
	
	public Address() { }
	
	public Address(ResultSet rs) {
		this.aid = QueryHelper.readInt(rs, "aid");
		this.num = QueryHelper.readInt(rs, "address_num");
		this.street = QueryHelper.readString(rs, "street");
		this.apartmentNumber = QueryHelper.readInt(rs, "apt_num");
		this.postalCode = QueryHelper.readString(rs, "postal_code");
		this.city = QueryHelper.readString(rs, "city");
		this.province = QueryHelper.readString(rs, "province");
		this.country = QueryHelper.readString(rs, "country");
	}
}
