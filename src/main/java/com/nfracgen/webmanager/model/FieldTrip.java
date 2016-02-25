package com.nfracgen.webmanager.model;

import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class FieldTrip implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@NotEmpty
	@Column(name = "field_name", nullable = false, length = 80)
	private String fieldName;
	
	//TODO: change to goeolocalization Type
	@NotEmpty
	@Column(nullable = false, length = 80)
	private String localization;
	
	//Name of collection team
	@Column(name = "team_name", nullable = true, length = 80)
	private String teamname;
	
	//---------------------------------------------novo ------------------- 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date datecollect;
	
	@Column(name = "field_type", nullable = true, length = 80)
	@Enumerated(EnumType.STRING)
	private FieldType fieldtype;
	
	@Column(nullable = true, length = 50)
	@Enumerated(EnumType.STRING)
	private DataType datatype;
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	
	//-----
	
	public Date getDatecollect() {
		return datecollect;
	}

	public void setDatecollect(Date datecollect) {
		this.datecollect = datecollect;
	}

	public FieldType getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(FieldType fieldtype) {
		this.fieldtype = fieldtype;
	}

	public DataType getDatatype() {
		return datatype;
	}

	public void setDatatype(DataType datatype) {
		this.datatype = datatype;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	//PrePersist
	@PrePersist
	@PreUpdate
	public void dateConfigCreateModify(){
		this.modifyDate = new Date();
		
		if(this.createDate == null){
			this.createDate = new Date();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldTrip other = (FieldTrip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

