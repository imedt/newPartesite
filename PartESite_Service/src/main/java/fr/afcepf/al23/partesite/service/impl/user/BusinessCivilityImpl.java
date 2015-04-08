package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Civility;
import fr.afcepf.al23.partesite.idao.user.IDaoCivility;
import fr.afcepf.al23.partesite.iservice.user.IBusinessCivility;

@Stateless
public class BusinessCivilityImpl implements IBusinessCivility {
	@EJB
	private IDaoCivility daoCiv;

	@Override
	public Civility save(Civility civility) {
		
			if (civility.getIdCivility() == null)
				daoCiv.add(civility);
			else
				daoCiv.update(civility);

		return civility;
	}

	@Override
	public Civility get(Integer idCivility) {
		Civility civility = null;

			civility = daoCiv.get(idCivility);	

		return civility;
	}

	@Override
	public List<Civility> getAll() {
		List<Civility> civilities = null;
	
			civilities = daoCiv.getall();
	
		return civilities;
	}

}
