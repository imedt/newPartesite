package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessInvestment;
import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.OrderRow;

@Stateless
public class BusinessInvestment implements IBusinessInvestment {

	@EJB
	IDaoOrderRow daoOrderRow;

	@Override
	public int getNbInvestment(Identity identity) {
		int investments = 0;
		List<OrderRow> orderRows = daoOrderRow.getByCreatedBy(identity.getIdIdentity());
		if(!orderRows.isEmpty()){
			for (OrderRow orderRow : orderRows) {
				if (!orderRow.getPack().getReward()) {
					investments++;
				}
			}
		}
		return investments;
	}

	@Override
	public int getNbGift(Identity identity) {
		int gifts = 0;
		List<OrderRow> orderRows = daoOrderRow.getByCreatedBy(identity.getIdIdentity());
		if(!orderRows.isEmpty()){
			for (OrderRow orderRow : orderRows) {
				if (orderRow.getPack().getReward()) {
					gifts++;
				}
			}
		}
		return gifts;
	}

}
