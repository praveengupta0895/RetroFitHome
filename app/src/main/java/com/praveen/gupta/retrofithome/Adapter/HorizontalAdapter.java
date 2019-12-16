package com.praveen.gupta.retrofithome.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.praveen.gupta.retrofithome.Model.Popular;
import com.praveen.gupta.retrofithome.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder>{

    private Context context;
    private List<Popular> popularList;

    public HorizontalAdapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popular_single_item, null);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Popular popular = popularList.get(position);

        Picasso.get()
                .load(popular.getImage())
                .into(holder.popularImage);

        holder.nameTextView.setText(popular.getName());
        holder.countOne.setText(String.valueOf(popular.getCount()));
        holder.loremOne.setText(popular.getType());
    }


    @Override
    public int getItemCount() {
        return (null != popularList ? popularList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        ImageView popularImage;
        TextView nameTextView;
        TextView countOne;
        TextView loremOne;
        TextView countTwo;
        TextView loremTwo;
        LinearLayout linearLayout;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        CustomViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            popularImage = itemView.findViewById(R.id.popular_image);
            nameTextView = itemView.findViewById(R.id.name);
            countOne = itemView.findViewById(R.id.count1);
            loremOne = itemView.findViewById(R.id.lorem1);
            countTwo = itemView.findViewById(R.id.count2);
            loremTwo = itemView.findViewById(R.id.lorem2);
            linearLayout = itemView.findViewById(R.id.popular_item);

            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Toast.makeText(context, popularList.get(clickedPosition).getName(), Toast.LENGTH_LONG).show();
        }
    }
}
