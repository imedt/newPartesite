package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Address;
import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.IdentityRight;
import fr.afcepf.al23.partesite.model.entities.Phone;

@Remote
public interface IDaoIdentity {
public Identity add(Identity identity);
public Identity update(Identity identity);
public Identity get(Integer idIdentity);
public List<IdentityRight> getIdentityRights(Integer idIdentityRole);
public List<Address> getAddresses(Integer idIdentity);
public List<Phone> getPhones(Integer idIdentity);
public Identity connexion(String email, String mdp);
public boolean phoneExist(String phoneNumber);
public boolean emailExist(String email);
public List<Identity> getBlackList();
public List<Identity> getAll();
}
