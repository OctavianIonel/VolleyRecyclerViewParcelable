package com.ionel.octavian.testgithub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

/**
 * Created by octavian on 1/29/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private ArrayList<MyModel> myData;
    private Context mContext;


    public RVAdapter(Context context, ArrayList<MyModel> myData) {
        mContext = context;
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(mContext).inflate(R.layout.element, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.cardNumberTv.setText(String.valueOf(position+1));

//        final Target target = new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                holder.photoIv.setImageBitmap(bitmap);
//            }
//
//            @Override
//            public void onBitmapFailed(Drawable errorDrawable) {
//                Log.e("RVAdapter", "error loading bitmap");
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//            }
//        };
//        Picasso.with(mContext).load(myData.get(position).getPhoto()).resize(30, 30).into(target);
        Utils.setImage(mContext, holder.photoIv, myData.get(position).getPhoto());
        holder.nameTv.setText("Name: " + myData.get(position).getName());
        holder.repositoryNameTv.setText("Repository: " + myData.get(position).getRepositoryName());
        holder.shortDescriptionTv.setText("Short description (max 15 words): " + myData.get(position).getDescription());

        holder.stargazersTv.setVisibility(View.GONE);
        holder.forksTv.setVisibility(View.GONE);
        holder.watchersTv.setVisibility(View.GONE);
        holder.openIssuesTv.setVisibility(View.GONE);

        holder.cardViewCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra(Utils.MY_MODEL, myData.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewCv;
        private TextView cardNumberTv;
        private ImageView photoIv;
        private TextView nameTv;
        private TextView repositoryNameTv;
        private TextView shortDescriptionTv;
        private TextView stargazersTv;
        private TextView forksTv;
        private TextView watchersTv;
        private TextView openIssuesTv;


        public MyViewHolder(View itemView) {
            super(itemView);
            cardViewCv = (CardView)itemView.findViewById(R.id.cv);
            cardNumberTv = (TextView)itemView.findViewById(R.id.card_number);
            photoIv = (ImageView)itemView.findViewById(R.id.photo);
            nameTv = (TextView)itemView.findViewById(R.id.name);
            repositoryNameTv = (TextView)itemView.findViewById(R.id.repository_name);
            shortDescriptionTv = (TextView)itemView.findViewById(R.id.short_description);
            stargazersTv = (TextView)itemView.findViewById(R.id.stargazersTv);
            forksTv = (TextView)itemView.findViewById(R.id.forksTv);
            watchersTv = (TextView)itemView.findViewById(R.id.watchersTv);
            openIssuesTv = (TextView)itemView.findViewById(R.id.openIssuesTv);
        }
    }

}
