package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Identity;
@Remote
public interface IBusinessIdentity {
public Identity save(Identity identity);
public Identity get(int IdIdentity);
public Identity connexion(String email, String mdp);
public Identity delete(Identity identity);
public Identity blackList(Identity identity);
public List<Identity> getBlackList();
public List<Identity> getAll();
}
