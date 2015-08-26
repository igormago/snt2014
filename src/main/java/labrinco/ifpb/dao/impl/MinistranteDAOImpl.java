package labrinco.ifpb.dao.impl;

import java.io.Serializable;

import labrinco.ifpb.dao.MinistranteDAO;
import labrinco.ifpb.model.Ministrante;

public class MinistranteDAOImpl extends DAOImpl<Ministrante> implements
		Serializable, MinistranteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MinistranteDAOImpl() {
		this.classe = Ministrante.class;
	}

}
