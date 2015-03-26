package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Address;

@Remote
public interface IDaoAddress {
public Address add(Address address);
public Address update(Address address);
public Address get(int idAddress);
public List<Address> getByIdIdentity(int idIdentity);
}
