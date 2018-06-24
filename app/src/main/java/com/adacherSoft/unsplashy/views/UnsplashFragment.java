package com.adacherSoft.unsplashy.views;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adacherSoft.unsplashy.R;
import com.adacherSoft.unsplashy.adapter.UnsplashyAdapter;
import com.adacherSoft.unsplashy.background.GetDataSplash;
import com.adacherSoft.unsplashy.models.Unsplash;

import java.util.Arrays;

public class UnsplashFragment extends Fragment {

    private UnsplashyAdapter adapter;


    public UnsplashFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unsplash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UnsplashyAdapter();
        recyclerView.setAdapter(adapter);
        new backgroundRandom().execute();

    }
    private class backgroundRandom extends GetDataSplash
    {
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Unsplash[] unsplashes) {
            if(unsplashes != null)
            {
                adapter.update(Arrays.asList(unsplashes));


            }
            progressDialog.dismiss();
        }


    }

}
