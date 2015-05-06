package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Address;
import fr.afcepf.al23.partesite.idao.user.IDaoAddress;
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddress;

@Stateless
public class BusinessAddressImpl implements IBusinessAddress {
	
	@EJB
	private IDaoAddress daoAdd;

	@Override
	public Address save(Address address) {

			if (address.getIdAddress() == null)
				daoAdd.add(address);
			else
				daoAdd.update(address);

		return address;
	}

	@Override
	public Address get(Integer idAddress) {
		Address address = null;

			address = daoAdd.get(idAddress);

		return address;
	}

	@Override
	public List<Address> getByIdIdentity(Integer idIdentity) {
		List<Address> addresses = null;

			addresses = daoAdd.getByIdIdentity(idIdentity);

		return addresses;
	}

	@Override
	public void deleteAddress(Address a) {		
		daoAdd.delete(a);
	}

}
