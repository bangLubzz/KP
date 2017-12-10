package com.example.banglubzzz.salesmonitor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banglubzzz.salesmonitor.R;
import com.example.banglubzzz.salesmonitor.Task;
import com.example.banglubzzz.salesmonitor.network.RestClient;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {


    Unbinder unbinder;
    List<Task> list_task;
    @BindView(R.id.menu_task)
    RecyclerView menuTask;
    private RecyclerAdapter<Task> adapter;
    RestClient restClient = RestClient.getInstance();

    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this, view);


        show();
        return view;
    }

    private void show() {
        adapter = new RecyclerAdapter<Task>(getActivity(), R.layout.row_task) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final Task data_task) {
                final int position = helper.getAdapterPosition();

                Log.i(getTag(),"data task");
//                helper.setImageUrl(R.id.img_task, data_task.getGambar());
                helper.setText(R.id.judul_task, data_task.getJudul());
//                helper.setText(R.id.maps, data_task.getMap());

                helper.setOnClickListener(R.id.cv_task, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent i = new Intent(getActivity(), KetuaDetailActivity.class);
//                        i.putExtra("status", data.getStatus());
//                        i.putExtra("id_pengajuan", data.getIdPengajuan());
//                        startActivity(i);
                    }
                });

            }
        };
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        menuTask.setLayoutManager(llm);
        menuTask.setAdapter(adapter);

        adapter.addAll(load());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public List<Task> load() {
        List<Task> list = new ArrayList<>();
        list.add(new Task("", "Pontianak", ""));
        list.add(new Task("", "Lot Of Coffee", ""));
        list.add(new Task("", "hayamuruk", ""));
        return list;
    }
}

