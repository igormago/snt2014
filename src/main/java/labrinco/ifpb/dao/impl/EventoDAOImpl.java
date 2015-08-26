package labrinco.ifpb.dao.impl;

import java.io.Serializable;

import labrinco.ifpb.dao.EventoDAO;
import labrinco.ifpb.model.Evento;
import labrinco.ifpb.model.Usuario;

public class EventoDAOImpl extends DAOImpl<Evento> implements Serializable,
		EventoDAO {

	public EventoDAOImpl() {
		this.classe = Evento.class;
	}

}
