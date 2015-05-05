package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Phone;
@Remote
public interface IBusinessPhone {
public Phone save(Phone phone);
public Phone get(Integer idPhone);
public List<Phone> getByIdIdentity(Integer idIdentity);
public void delete(Integer idPhone);
}
