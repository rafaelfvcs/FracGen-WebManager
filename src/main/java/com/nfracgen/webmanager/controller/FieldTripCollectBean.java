package com.nfracgen.webmanager.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.nfracgen.webmanager.model.FieldTrip;
import com.nfracgen.webmanager.model.FieldType;
import com.nfracgen.webmanager.repository.FieldTrips;
import com.nfracgen.webmanager.service.RegisterFieldTripServer;
import com.nfracgen.webmanager.util.FacesMessages;


@Named   //para bean CDI
@ViewScoped 
public class FieldTripCollectBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private FieldTrips fieldtrips; //nao eh uma lista - eh um repositorio parecido com lista
	
	@Inject
	private RegisterFieldTripServer registerFieldTrip;
	
	@Inject
	private FacesMessages messages;
	
	private FieldTrip fieldSelect;
	
	private List<FieldTrip> allFields;
	
	private FieldTrip fieldEdit = new FieldTrip(); //p new Empresa() evitar nullpointexecption
	
	public void prepararNovoField() {
		fieldEdit = new FieldTrip();
	}
	
	public void salvar() {
		registerFieldTrip.salvar(fieldEdit);
		consultar();
		
		messages.info("Campo salvo com sucesso!");
		
		//atualiza os componetes caso tenhamos sucesso nas entradas de dados
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs","frm:fieldtrips-table"));
	}
	
	public void excluir(){
		registerFieldTrip.excluir(fieldSelect);
		fieldSelect = null;
		consultar();
		messages.info("Campo excluído com sucesso!");
	}
	
	public void consultar(){
		allFields = fieldtrips.todas();
	}

	public FieldTrip getFieldSelect() {
		return fieldSelect;
	}

	public void setFieldSelect(FieldTrip fieldSelect) {
		this.fieldSelect = fieldSelect;
	}

	public FieldType[] getFieldTypes() {
		return FieldType.values(); //values - metodo do enum
	}
	
	public List<FieldTrip> getAllFields() {
		return allFields;
	}

	public void setAllFields(List<FieldTrip> allFields) {
		this.allFields = allFields;
	}

	public FieldTrip getFieldEdit() {
		return fieldEdit;
	}

	public void setFieldEdit(FieldTrip fieldEdit) {
		this.fieldEdit = fieldEdit;
	}

}
