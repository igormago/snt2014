package labrinco.ifpb.dao.impl;

import java.io.Serializable;

import labrinco.ifpb.dao.HorarioDisponivelDAO;
import labrinco.ifpb.model.HorarioDisponivel;

public class HorarioDisponivelImpl extends DAOImpl<HorarioDisponivel> implements Serializable,
		HorarioDisponivelDAO {

	public HorarioDisponivelImpl() {
		this.classe = HorarioDisponivel.class;
	}

}
