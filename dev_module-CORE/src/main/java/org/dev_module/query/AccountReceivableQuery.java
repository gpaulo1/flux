package org.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.model.AccountReceivable;
import org.dev_module.model.QAccountReceivable;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class AccountReceivableQuery {

	@PersistenceContext
	private EntityManager em;

	public List<AccountReceivableDTO> findAllAccountsOrdeByIdDesc() {

		QAccountReceivable predicate = QAccountReceivable.accountReceivable;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(predicate)
				.orderBy(predicate.dataVencimento.desc())
				.list(Projections.fields(AccountReceivableDTO.class,
						predicate.id, predicate.dataVencimento,
						predicate.descricao, predicate.formaPagamento));

	}

}
