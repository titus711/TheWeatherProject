package com.titusnangi.theweatherproject.binding;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.titusnangi.theweatherproject.R;

public class BindingAdapters {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void setImageUrl(ImageView view, String imageUrl) {
        if (imageUrl != null && imageUrl.length() > 0) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.patlycloud)
                    .into(view);

        }
    }
}
