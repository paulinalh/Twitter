package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;
    //Pass in the context and list of tweets

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // Clean all elements of the recycler
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }

    //for each tweets, inflate the layout
    @NonNull
    @NotNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    //bind values based on the position of the element

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        //Get the data at position
        Tweet tweet = tweets.get(position);

        //Bind the tweet with viewholder
        holder.bind(tweet);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }


    //define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        ImageView ivMedia;
        TextView tvTime;
        TextView tvName;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            ivMedia =itemView.findViewById(R.id.ivMedia);
            tvName=itemView.findViewById(R.id.tvName);
            tvTime=itemView.findViewById(R.id.tvTime);

        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText("@"+ tweet.user.screenName);
            tvName.setText(tweet.user.name);
            tvTime.setText(tweet.createdAt);

            Glide.with(context).load(tweet.user.profileImageUrl).transform(new RoundedCornersTransformation(200, 10)).into(ivProfileImage);


            Log.d("TAG",tweet.mediaUrl);
            if(tweet.mediaUrl!=null){
                ivMedia.setVisibility(View.VISIBLE);
                Glide.with(context).load(tweet.mediaUrl).transform(new RoundedCornersTransformation(40, 0)).into(ivMedia);
            }else{
                ivMedia.setVisibility(View.GONE);
            }

            //Glide.with(context).load(tweet.entities.media.mediaUrl).into(ivMedia);

        }


    }

}
