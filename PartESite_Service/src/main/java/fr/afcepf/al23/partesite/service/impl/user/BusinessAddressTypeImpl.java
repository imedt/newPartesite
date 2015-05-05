package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.AddressType;
import fr.afcepf.al23.partesite.idao.user.IDaoAddressType;
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddressType;


@Stateless
public class BusinessAddressTypeImpl implements IBusinessAddressType {

	@EJB
	private IDaoAddressType daoAddT;
	
	@Override
	public AddressType save(AddressType addressType) {

			if (addressType.getIdAddressType() == null)
				daoAddT.add(addressType);
			else
				daoAddT.update(addressType);

		return addressType;
	}

	@Override
	public AddressType get(Integer idAddresstype) {
		AddressType addressType = null;

			addressType = daoAddT.get(idAddresstype);

		return addressType;
	}

	@Override
	public List<AddressType> getAll() {
		List<AddressType> addressTypes = null;

			addressTypes = daoAddT.getall();
 
		return addressTypes;
	}

}
