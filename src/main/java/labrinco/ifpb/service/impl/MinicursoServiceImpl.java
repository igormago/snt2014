package labrinco.ifpb.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import labrinco.ifpb.dao.MinicursoDAO;
import labrinco.ifpb.dao.MinistranteDAO;
import labrinco.ifpb.model.Minicurso;
import labrinco.ifpb.model.Ministrante;
import labrinco.ifpb.service.MinicursoService;

public class MinicursoServiceImpl extends ServiceImpl<Minicurso> implements
		Serializable, MinicursoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private MinicursoDAO minicursoDAO;

	@Inject
	private MinistranteDAO ministranteDAO;

	@Transactional
	public void adiciona(Minicurso minicurso) {
		Minicurso resposta = minicursoDAO.adiciona(minicurso);
		Set<Ministrante> ministrantes = minicurso.getMinistrantes();

		for (Ministrante ministrante : ministrantes) {

			// TODO GAMBIARRA TEMPORARIA
			if (ministrante != null && ministrante.getNome() != null
					&& !ministrante.getNome().equals("")) {
				System.out.println(ministrante);
				ministrante.setMinicurso(resposta);
				ministranteDAO.adiciona(ministrante);
			} else {
				minicurso.getMinistrantes().remove(minicurso);
			}
		}
	}

	@Override
	public List<Minicurso> buscaPorUsuario(long id) {
		return minicursoDAO.buscaPorUsuario(id);
	}

}