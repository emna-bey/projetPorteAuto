package com.netlinks.porteautomatique.adapter;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netlinks.porteautomatique.R;
import com.netlinks.porteautomatique.model.Voiture;

public class listAdapter extends BaseAdapter {

	private List<Voiture> voitures;
	private LayoutInflater listInflater;

	public listAdapter(Context context, List<Voiture> _voitures) {
		this.listInflater = LayoutInflater.from(context);
		this.voitures = _voitures;
	}

	public int getCount() {

		return this.voitures.size();
	}

	public Object getItem(int arg0) {
		return this.voitures.get(arg0);
	}

	public long getItemId(int position) {

		return position;
	}

	public static class ViewHolder {
		TextView matricule;
		TextView nomprop;
		TextView couleur;
		TextView date;
		ImageView icon;

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = listInflater.inflate(R.layout.voiture_item, null);
			holder = new ViewHolder();
			holder.matricule = (TextView) convertView
					.findViewById(R.id.voiture_item_matricule);
			holder.nomprop = (TextView) convertView
					.findViewById(R.id.voiture_item_nomprop);
			holder.couleur = (TextView) convertView
					.findViewById(R.id.voiture_item_couleur);
			holder.date = (TextView) convertView
					.findViewById(R.id.voiture_item_date);
			convertView.setTag(holder);
			holder.icon = (ImageView) convertView.findViewById(R.id.imageView1);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.matricule.setText(voitures.get(position).getMatricule());
		holder.nomprop.setText(voitures.get(position).getNomProp());
		holder.couleur.setText("" + voitures.get(position).getCouleur());
		holder.date.setText(voitures.get(position).getDateAjout().toString());

		return convertView;
	}

}

