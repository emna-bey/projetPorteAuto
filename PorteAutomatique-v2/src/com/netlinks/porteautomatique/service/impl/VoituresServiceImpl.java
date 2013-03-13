package com.netlinks.porteautomatique.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.netlinks.porteautomatique.config.config;
import com.netlinks.porteautomatique.model.Voiture;
import com.netlinks.porteautomatique.service.VoituresService;

public class VoituresServiceImpl implements VoituresService{

	String result = "";
	List<Voiture> voitures;

	@Override
	public List<Voiture> getAll() {
	
		voitures = new ArrayList<Voiture>();
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(config.getAllService);
	
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

	@Override
	public void add(Voiture v) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(config.addService);
		try{
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();  
		    pairs.add(new BasicNameValuePair("matricule",""));  
		    pairs.add(new BasicNameValuePair("couleur","")); 
		    pairs.add(new BasicNameValuePair("nom",""));
		    post.setEntity((HttpEntity) new UrlEncodedFormEntity(pairs));
		    
		     HttpResponse response = httpClient.execute(post);
		      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		      String line = "";
		      while ((line = rd.readLine()) != null) {
		        System.out.println(line);
		      }
		} catch (IOException e) {
		      e.printStackTrace();
		    }
		    
	}

	}


