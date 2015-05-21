package aspiro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.model.entities.ProjectContent;

public class Aspi {
	private Logger log = Logger.getLogger(Aspi.class);	 
	private DAO dao;
	public Aspi(){
		dao = new DAO();
	}
	public void startAspi(){		
		try {
			for(int i = 2;i<36;i++){
				
			log.info("https://www.kickstarter.com/discover/advanced?page="+i+"&category_id=0woe_id=0&sort=magic");
			Document doc = Jsoup.connect("https://www.kickstarter.com/discover/advanced?page="+i+"&category_id=0woe_id=0&sort=magic").get();
			Elements projectList = doc.select(".project-card");
			for (Element src : projectList) {
				String linkToProject = ("https://www.kickstarter.com"+src.getElementsByTag("a").attr("href")); 
				getProjectInfo(linkToProject);
			}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.close(); 
	}

	private void getProjectInfo(String linkToProject) {
		try {
			Identity proprio = new Identity();
			ProjectCategory pcat = new ProjectCategory();
			pcat.setIdProjectCategory(Math.round((float)Math.random()*6));
			proprio.setIdIdentity(35+Math.round((float)Math.random()*100));
			boolean isPublished = Math.round((float)Math.random()) == 0 ? false:true;
			//Initialisation données non kickstarter
			Project p = new Project();
			p.setIdentity(proprio);
			p.setProjectCategory(pcat);
			p.setPublish(isPublished);
			if(isPublished){
				Date pubDate = new Date();
				pubDate.setTime(Math.round(Math.random()*pubDate.getTime()));
				p.setPublishingDate(pubDate);
			}
			Date creaDate = new Date();
			creaDate.setTime(Math.round(Math.random()*creaDate.getTime()));
			p.setDisabled(false);
			p.setCreatedDate(creaDate);
			p.setCreatedBy(proprio.getIdIdentity());
			p.setUpdatedDate(creaDate);
			p.setUpdatedBy(1);
			log.info("Projet en cours : "+linkToProject);
			//Connexion a la page projet
			Document doc = Jsoup.connect(linkToProject).get();
			Element img = doc.getElementsByClass("project-image").get(0);
			boolean hasVideo = img.attr("data-has-video").equals("true")?true:false;
			//Récupération titre
			String title = doc.select("#content-wrap > section h2 > a").get(0).text();
			p.setProjectName(title); 
			//Récuperation video/image
			ProjectContent pVideo = new ProjectContent();
			ProjectContent pImg = new ProjectContent();
			ProjectContent pAboutAuthor = new ProjectContent();
			ProjectContent pAboutProject = new ProjectContent();
			String imgSrc;
			String vidSrc;
			if(hasVideo){ 
				vidSrc = doc.getElementById("video_pitch").attr("data-video-url");
				pVideo.setContent(vidSrc);
				imgSrc = doc.getElementById("video_pitch").attr("data-image");
				pImg.setContent(imgSrc);
			}else{
				imgSrc = doc.getElementsByTag("img").get(0).attr("src");
				pImg.setContent(imgSrc);
			}
			//Récupération a propos de l'auteur
			String aboutAuthor = doc.select("#content-wrap > section > div.container-flex.px2 > div:nth-child(2) > div.col.col-8.py4 > div > p").first().text();
			pAboutAuthor.setContent(aboutAuthor);
			//Récupération a propos du projet 
			String aboutProject = doc.getElementsByClass("full-description").get(0).html();
			pAboutProject.setContent(aboutProject);
			//Capital demandé : 
			String pledge =  doc.getElementById("pledged").attr("data-pledged"); 
			p.setAimingAmount(Double.parseDouble(pledge)); 
			//log.info("AUTHOR : "+aboutAuthor+" : ABOUT PROJECT : "+aboutProject);
			//Récupération des packages  
			Elements rewards = doc.getElementsByClass("NS-projects-reward");   
			log.info("number of rewards : "+rewards.size());
			p.setPacks(new ArrayList<Pack>());
			for(int i = 0; i < 3; i++){ 
				try{
					Pack pack = new Pack();
					Element r = rewards.get(i); 
					log.info(r.html()); 
					String description = r.getElementsByClass("desc").get(0).text();
					log.info("description"); 
					pack.setDescription(description);
					pack.setDisabled(false);
					pack.setCreatedDate(creaDate);
					pack.setUpdatedBy(1); 
					pack.setUpdatedDate(creaDate);
					int quantity = (15+ (int)Math.round((float)Math.random()*500));
					pack.setAmount((p.getAimingAmount()/((3-i)*10))*10);
					pack.setStock((int)Math.round(Math.random()*quantity));
					pack.setTotalQuantity(quantity);
					String packTitle = "Package ";
					switch(i){ 
						case 0:
							packTitle += "Basic";
							break;
						case 1:
							packTitle += "Medium";
							break;
						case 2:
							packTitle += "Premium";
							break; 
					} 
					pack.setPackName(packTitle); 
					String price = r.getElementsByClass("mb1").get(0).text().replace("Pledge ","").replace("\\xE2\\x80\\xA8", "").replace("$","").replace("£","").replace("€", "").replace(" or more", "");
					pack.setAmount(Double.parseDouble(price));
					p.addPack(pack);  
				}catch(Exception e){
					e.printStackTrace();
					log.info("no more reward"); 
				}
			}
			p.setProjectContents(new ArrayList<ProjectContent>());
			p.addProjectContent(pImg);
			p.addProjectContent(pVideo); 
			p.addProjectContent(pAboutAuthor); 
			p.addProjectContent(pAboutProject);
			dao.save(p);
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
