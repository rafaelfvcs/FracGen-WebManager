package com.nfracgen.webmanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@NotEmpty
	@Column(name = "field_name", nullable = false, length = 80)
	private String fieldName;
	
	//TODO: change to goeolocalization Type
	@NotEmpty
	@Column(nullable = false, length = 20)
	private String localization;
	
	@Column(nullable = true, length = 50)
	@Enumerated(EnumType.STRING)
	private DataType datatype;
	
	@Column(name = "field_type", nullable = false, length = 80)
	private FieldType fieltype;
	
	@Column(nullable = true, length = 30)
	private String equipament;
	
	//Name of collection team
	@Column(name = "team_name", nullable = false, length = 80)
	private String teamname;
	
	@NotNull 
	@Temporal(TemporalType.DATE)
	private Date datecollect;

	//private Date fieldperiod;
	
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

	public DataType getDatatype() {
		return datatype;
	}

	public void setDatatype(DataType datatype) {
		this.datatype = datatype;
	}

	public FieldType getFieltype() {
		return fieltype;
	}

	public void setFieltype(FieldType fieltype) {
		this.fieltype = fieltype;
	}

	public String getEquipament() {
		return equipament;
	}

	public void setEquipament(String equipament) {
		this.equipament = equipament;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public Date getDatecollect() {
		return datecollect;
	}

	public void setDatecollect(Date datecollect) {
		this.datecollect = datecollect;
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

