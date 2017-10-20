package application.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import application.rest.model.MealAppetizer;
import application.rest.model.MealDessert;
import application.rest.model.MealEntree;

public class MenuAggregate {
	  
	  Client client = ClientBuilder.newClient();
	  
	  Config config = ConfigProvider.getConfig();
	  
	  public MealAppetizer getCurrentAppetizers()
	  {
		String appetizer_uri = config.getValue("appetizer_url", String.class);
	    MealAppetizer mealappetizer = client.target(appetizer_uri)
                .request(MediaType.APPLICATION_JSON)
                .get(MealAppetizer.class); 
	    return mealappetizer;
	  }

	  public List<MealAppetizer> getDefaultAppetizers(){
		List<MealAppetizer> listapp = new ArrayList<>();
	    List<String> appetizerList = new ArrayList<String>();
	                 appetizerList.add("Chips");
	                 appetizerList.add("Salsa");
	                 appetizerList.add("Bruschetta");

	    MealAppetizer ma = new MealAppetizer(1, appetizerList, "default-appetizers");
	    listapp.add(ma);
	    return listapp;

	  }
	  
	  public MealEntree getCurrentEntrees()
	  {
		String entree_uri = config.getValue("entree_url", String.class);
		MealEntree mealentree = client.target(entree_uri)
	                .request(MediaType.APPLICATION_JSON)
	                .get(MealEntree.class);
		return mealentree;
	  }

	  public List<MealEntree> getDefaultEntrees(){
		  List<MealEntree> listent = new ArrayList<>();
		    List<String> entreeList = new ArrayList<String>();
		                 entreeList.add("Hamburger");
		                 entreeList.add("Hot Dog");
		                 entreeList.add("Spaghetti");

		    MealEntree me = new MealEntree(2, entreeList, "default-entrees");
		    listent.add(me);
		    return listent;

	  }

	  public MealDessert getCurrentDesserts()
	  {
		  String dessert_uri = config.getValue("dessert_url", String.class);
		  MealDessert mealdessert = client.target(dessert_uri)
		                .request(MediaType.APPLICATION_JSON)
		                .get(MealDessert.class);
		  return mealdessert;
      }

	  public List<MealDessert> getDefaultDesserts(){
		  List<MealDessert> listdes = new ArrayList<>();
		    List<String> dessertList = new ArrayList<String>();
		                 dessertList.add("Cookies");
		                 dessertList.add("Candy");
		                 dessertList.add("Cake");
		    MealDessert md = new MealDessert(3, dessertList, "default-desserts");
		    listdes.add(md);
		    return listdes;

	  }
}
