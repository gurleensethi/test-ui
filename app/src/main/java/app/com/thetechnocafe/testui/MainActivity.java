package app.com.thetechnocafe.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TestRecyclerAdapter mTestRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setUpRecyclerView();
    }

    //Set up the recycler view, if the adapter is null
    //Instantiate the adapter and apply to recycler view, else
    //Update the adapter list and notify data-set changes
    private void setUpRecyclerView() {
        if (mTestRecyclerAdapter == null) {
            mTestRecyclerAdapter = new TestRecyclerAdapter(this);
            mRecyclerView.setAdapter(mTestRecyclerAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mTestRecyclerAdapter.notifyDataSetChanged();
        }
    }
}
