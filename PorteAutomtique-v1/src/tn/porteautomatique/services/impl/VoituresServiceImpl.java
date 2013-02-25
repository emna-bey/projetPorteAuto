package tn.porteautomatique.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import tn.porteautomatique.config.config;
import tn.porteautomatique.model.Voiture;
import tn.porteautomatique.services.VoituresService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class VoituresServiceImpl implements VoituresService{

	String result = "";
	List<Voiture> voitures;

	@Override
	public List<Voiture> getAll() {
	
		voitures = new ArrayList<Voiture>();
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(config.service);
	
		ResponseHandler<String> handler = new BasicResponseHandler();
		try{
			result = httpClient.execute(request,handler);
			httpClient.getConnectionManager().shutdown();
			
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			JsonArray userArray = jsonParser.parse(result).getAsJsonArray();
			
			for( JsonElement uneVoiture : userArray)
			{
				Voiture a = gson.fromJson(uneVoiture, Voiture.class);
				voitures.add(a);
			}
			return voitures;
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return voitures;
	}

	}


