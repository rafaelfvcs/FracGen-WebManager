package com.nfracgen.webmanager.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.nfracgen.webmanager.model.FieldTrip;
import com.nfracgen.webmanager.repository.FieldTrips;
import com.nfracgen.webmanager.util.Transacional;


public class RegisterFieldTripServer implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FieldTrips fieldtrips;
	
	@Transacional
	public void salvar(FieldTrip fieldtrip) {
		fieldtrips.guardar(fieldtrip);
	}
	
	@Transacional
	public void excluir(FieldTrip fieldtrip) {
		fieldtrips.remover(fieldtrip);
	}
}
