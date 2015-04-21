package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Phone;
import fr.afcepf.al23.partesite.idao.user.IDaoPhone;
import fr.afcepf.al23.partesite.iservice.user.IBusinessPhone;
@Stateless
public class BusinessPhoneImpl implements IBusinessPhone {

	@EJB
	private IDaoPhone daoPh;
	
	@Override
	public Phone save(Phone phone) {

			if(phone.getIdPhone() == null)
				daoPh.add(phone);
			else
				daoPh.update(phone);

		return phone;
	}

	@Override
	public Phone get(Integer idPhone) {
		Phone phone = null;

			phone = daoPh.get(idPhone);	

		return phone; 
	}

	@Override
	public List<Phone> getByIdIdentity(Integer idIdentity) {
		List<Phone> phones = null;

			phones = daoPh.getByIdIdentity(idIdentity);

		return phones;
	}

}
