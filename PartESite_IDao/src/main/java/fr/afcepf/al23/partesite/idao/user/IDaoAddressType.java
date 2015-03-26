package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.AddressType;;

@Remote
public interface IDaoAddressType {
	public AddressType add(AddressType addressType);
	public AddressType update(AddressType addressType);
	public AddressType get(int idAddressType);
	public List<AddressType> getall();
}
