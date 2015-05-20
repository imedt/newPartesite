package fr.afcepf.al23.partesite.iservice.stats;
public interface IBusinessStatistics {
	public String getProjectsByCategories();
	public String getUsersBySignInDate(int year);
	public String getSalesByDate(int year);
	public String getUsersByCountry();  
}
