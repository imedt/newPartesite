package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Phone;

 
@Remote
public interface IDaoPhone {
	public Phone add(Phone phone);
	public Phone update(Phone phone);
	public Phone get(Integer idPhone);
	public List<Phone> getByIdIdentity(Integer idIdentity);
	public Boolean phoneExist(String phoneNumber);
	public void delete(Integer idPhone);
}
