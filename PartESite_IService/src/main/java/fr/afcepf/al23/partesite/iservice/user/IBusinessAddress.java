package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.model.entities.Address;
@Remote
public interface IBusinessAddress {
public Address save(Address address);
public Address get(Integer idAddress);
public List<Address> getByIdIdentity(Integer idIdentity);
}
