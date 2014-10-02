package org.dev_module.predicate;

import org.dev_module.model.QSaldo;

import com.mysema.query.types.Predicate;

public class SaldoPredicate {

	public static Predicate buscarSaldoPeloIdCaixa(Long id){
		QSaldo condicao = QSaldo.saldo;
		return condicao.caixa.id.eq(id);
	}
	
}
