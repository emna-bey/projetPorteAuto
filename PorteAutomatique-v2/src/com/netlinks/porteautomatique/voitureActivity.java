package com.netlinks.porteautomatique;



import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import com.netlinks.porteautomatique.adapter.listAdapter;
import com.netlinks.porteautomatique.mock.mockVoituresService;
import com.netlinks.porteautomatique.model.Voiture;
import com.netlinks.porteautomatique.service.VoituresService;


public class voitureActivity extends Activity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.voitures);

		listView = (ListView) findViewById(R.id.listVoitures);

	}
	@Override
	protected void onResume() {
		
		super.onResume();
		voitureAsyncTask async = new voitureAsyncTask();
		async.execute();
	}

	
	private class voitureAsyncTask extends
			AsyncTask<Void, Void, List<Voiture>> {

		@Override
		protected List<Voiture> doInBackground(Void... params) {

			List<Voiture> voitures = null;
			try {
				VoituresService mockService = new mockVoituresService();
				voitures = mockService.getAll();
			} catch (Exception e) {
				cancel(false);
			}
			return voitures;
		}

		@Override
		protected void onPostExecute(List<Voiture> voitures) {

			listView.setAdapter(new listAdapter(voitureActivity.this, voitures));

		}

	}

}

