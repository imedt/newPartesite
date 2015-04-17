package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Address;

@Remote
public interface IDaoAddress {
public Address add(Address address);
public Address update(Address address);
public Address get(Integer idAddress);
public List<Address> getByIdIdentity(Integer idIdentity);
}
