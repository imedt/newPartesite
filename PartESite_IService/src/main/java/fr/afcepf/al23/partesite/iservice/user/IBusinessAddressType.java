package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.AddressType;
@Remote
public interface IBusinessAddressType {
public AddressType save(AddressType addressType);
public AddressType get(Integer idAddresstype);
public List<AddressType> getAll();
}
