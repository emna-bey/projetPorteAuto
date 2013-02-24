package tn.porteautomatique;

import tn.porteautomatique.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}
	
	public void onClickVoitures(View view){
		
		startActivity(new Intent(DashboardActivity.this, voitureActivity.class));
		
	}
	
}