package com.example.test;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView mPostRecyclerView;
    EditText mSearchValue;
    private JsonPlaceHolderAPI mJsonPlaceHolderAPI;
    private PostAdapter mPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPostRecyclerView = findViewById(R.id.post_recyclerview);
        Post post = new Post();
        mSearchValue = findViewById(R.id.search);
        mSearchValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPostAdapter.filterPost(editable.toString());
            }
        });
        prepareRecyclerView();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mJsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        getPosts();
    }


    private void getPosts() {
        Call<List<Post>> call = mJsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Post> posts = response.body();
                mPostAdapter = new PostAdapter(MainActivity.this, posts);
                mPostRecyclerView.setAdapter(mPostAdapter);
                mPostAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                runOnUiThread(()->{
//                    Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                });
            }
        });
    }

    private void prepareRecyclerView() {
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPostRecyclerView.setHasFixedSize(true);
    }

}