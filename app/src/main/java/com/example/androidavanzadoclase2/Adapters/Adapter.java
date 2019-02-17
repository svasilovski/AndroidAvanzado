package com.example.androidavanzadoclase2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidavanzadoclase2.R;
import com.example.androidavanzadoclase2.Users.User;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<User> lstUsuario;

    public Adapter(List<User> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    @Override
    public int getCount() {
        return lstUsuario.size();
    }

    @Override
    public Object getItem(int position) {
        return lstUsuario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.activity_celda, parent, false);
        }

        // get current item to be displayed
        User currentItem = (User) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = convertView.findViewById(R.id.txt_name);
        TextView textViewItemDescription = convertView.findViewById(R.id.txt_email);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getName());
        textViewItemDescription.setText(currentItem.getEmail());

        // returns the view for the current row
        return convertView;
    }
}
