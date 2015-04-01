package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessInvestment;

@Stateless
public class BusinessInvestment implements IBusinessInvestment {

	@EJB
	IDaoOrderRow daoOrderRow;

	@Override
	public Integer getNbInvestment(Identity identity) {
		Integer investments = 0;
		List<OrderRow> orderRows = daoOrderRow.getByCreatedBy(identity.getIdIdentity());
		if(!orderRows.isEmpty()){
			for (OrderRow orderRow : orderRows) {
				if (!orderRow.getItem().getPack().getReward()) {
					investments++;
				}
			}
		}
		return investments;
	}

	@Override
	public Integer getNbGift(Identity identity) {
		Integer gifts = 0;
		List<OrderRow> orderRows = daoOrderRow.getByCreatedBy(identity.getIdIdentity());
		if(!orderRows.isEmpty()){
			for (OrderRow orderRow : orderRows) {
				if (orderRow.getItem().getPack().getReward()) {
					gifts++;
				}
			}
		}
		return gifts;
	}

}
