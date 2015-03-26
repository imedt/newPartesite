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
public Identity get(int idIdentity);
public List<IdentityRight> getIdentityRights(int idIdentityRole);
public List<Address> getAddresses(int idIdentity);
public List<Phone> getPhones(int idIdentity);
public Identity connexion(String email, String mdp);
public boolean phoneExist(String phoneNumber);
public boolean emailExist(String email);
public List<Identity> getBlackList();
public List<Identity> getAll();
}
