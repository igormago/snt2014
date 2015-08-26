package labrinco.ifpb.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import labrinco.ifpb.dao.HorarioDisponivelDAO;
import labrinco.ifpb.model.HorarioDisponivel;
import labrinco.ifpb.service.HorarioDisponivelService;

public class HorarioDisponivelServiceImpl extends ServiceImpl<HorarioDisponivel> implements
		Serializable, HorarioDisponivelService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private HorarioDisponivelDAO horarioDisponivelDAO;

}