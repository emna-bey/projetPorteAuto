package tn.porteautomatique;



import java.util.List;

import tn.porteautomatique.R;
import tn.porteautomatique.adapter.listAdapter;
import tn.porteautomatique.mock.mockVoituresService;
import tn.porteautomatique.model.Voiture;
import tn.porteautomatique.services.VoituresService;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;


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

