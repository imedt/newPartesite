package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Address;
@Remote
public interface IBusinessAddress {
public Address save(Address address);
public Address get(Integer idAddress);
public List<Address> getByIdIdentity(Integer idIdentity);
}
