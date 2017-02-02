package app.com.thetechnocafe.testui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gurleensethi on 02/02/17.
 */

public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.TestRecyclerViewHolder> {

    private Context mContext;

    public TestRecyclerAdapter(Context context) {
        mContext = context;
    }

    //View Holder for this Adapter
    class TestRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mDescriptionTextView;

        TestRecyclerViewHolder(View view) {
            super(view);
            mDescriptionTextView = (TextView) view.findViewById(R.id.description_text_view);
        }

        //Bind the data from the list
        void bindData(int position) {
            String descriptionText = "Experience music like its the 60's with this beautiful record player #Audiophile #Rock&Roll";
            SpannableString formattedString = HashTagColorUtility.getInstance().colorHashTags(descriptionText, ContextCompat.getColor(mContext, R.color.colorPrimary));
            mDescriptionTextView.setText(formattedString);
        }
    }

    @Override
    public TestRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent, false);
        return new TestRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestRecyclerViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
