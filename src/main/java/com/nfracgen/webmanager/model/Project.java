package com.nfracgen.webmanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_project;
	
	@Column
	private String projectName;
	
	@Column
	private String typeOfStudy;
	
	@Column
	private Date studyDate;

	public Long getId_project() {
		return id_project;
	}

	public void setId_project(Long id_project) {
		this.id_project = id_project;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTypeOfStudy() {
		return typeOfStudy;
	}

	public void setTypeOfStudy(String typeOfStudy) {
		this.typeOfStudy = typeOfStudy;
	}

	public Date getStudyDate() {
		return studyDate;
	}

	public void setStudyDate(Date studyDate) {
		this.studyDate = studyDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_project == null) ? 0 : id_project.hashCode());
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
		Project other = (Project) obj;
		if (id_project == null) {
			if (other.id_project != null)
				return false;
		} else if (!id_project.equals(other.id_project))
			return false;
		return true;
	}
	
}
