package labrinco.ifpb.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import labrinco.ifpb.dao.EventoDAO;
import labrinco.ifpb.model.Evento;
import labrinco.ifpb.service.EventoService;

public class EventoServiceImpl extends ServiceImpl<Evento> implements
		Serializable, EventoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EventoDAO eventoDAO;

}