package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Phone;
@Remote
public interface IBusinessPhone {
public Phone save(Phone phone);
public Phone get(int idPhone);
public List<Phone> getByIdIdentity(int idIdentity);
}
