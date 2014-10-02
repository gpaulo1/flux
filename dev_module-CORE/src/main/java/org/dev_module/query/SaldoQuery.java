package org.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.SaldoFluxoDTO;
import org.dev_module.model.QCaixa;
import org.dev_module.model.QFluxo;
import org.dev_module.model.QSaldo;
import org.dev_module.model.Saldo;
import org.springframework.stereotype.Service;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class SaldoQuery {

	@PersistenceContext
	private EntityManager em;

	public List<SaldoFluxoDTO> buscarSaldoPeloIdCaixa(Long id) {
		QSaldo saldo = QSaldo.saldo;
		QCaixa caixa = QCaixa.caixa;
		QFluxo fluxo = QFluxo.fluxo;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(caixa)
				.innerJoin(caixa.fluxos, fluxo)
				.where(caixa.id.eq(new Long(1)))
				.list(Projections.fields(SaldoFluxoDTO.class,
						saldo.saldoCredito, saldo.saldoDebito,
						saldo.saldoDisponivel, fluxo.data, fluxo.descricao, fluxo.valor));
	}
}
