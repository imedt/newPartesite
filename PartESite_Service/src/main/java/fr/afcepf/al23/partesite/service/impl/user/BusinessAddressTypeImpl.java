package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.idao.user.IDaoAddressType;
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddressType;
import fr.afcepf.al23.partesite.model.entities.AddressType;


@Stateless
public class BusinessAddressTypeImpl implements IBusinessAddressType {

	@EJB
	private IDaoAddressType daoAddT;
	
	@Override
	public AddressType save(AddressType addressType) {
		if (addressType.getIdAddressType() == 0)
			daoAddT.add(addressType);
		else
			daoAddT.update(addressType);
		return addressType;
	}

	@Override
	public AddressType get(int idAddresstype) {
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
