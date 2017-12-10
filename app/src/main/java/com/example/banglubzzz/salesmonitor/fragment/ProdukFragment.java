package com.example.banglubzzz.salesmonitor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banglubzzz.salesmonitor.R;
import com.example.banglubzzz.salesmonitor.network.RestClient;
import com.example.banglubzzz.salesmonitor.pupuk.DataItem;
import com.example.banglubzzz.salesmonitor.pupuk.ProdukResponse;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdukFragment extends Fragment {


    @BindView(R.id.menuPeroduk)
    RecyclerView menuPeroduk;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    List<DataItem> listweater;//list apa yang ada dalam weater
    private RecyclerAdapter<DataItem> adapter;
    RestClient restClient = RestClient.getInstance();

    public ProdukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk, container, false);
        ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        adapter = new RecyclerAdapter<DataItem>(getActivity(), R.layout.row_menu_produk) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final DataItem data) {
                final int position = helper.getAdapterPosition();

                Log.i(getTag(),"hi");
                helper.setText(R.id.produkJudul,data.getNamaProduk());
                helper.setText(R.id.produkKet,data.getJenis());
                helper.setText(R.id.produkHarga,data.getHarga());
                helper.setImageUrl(R.id.menuPic,"https://mitos.or.id/pupuk/assets/uploads/produk/"+data.getFoto());
//                helper.setText(R.id.txt_ajuan_total_pinjaman, CTools.getRP(String.valueOf(data.getTotalPinjaman()),true));

                helper.setOnClickListener(R.id.l_history, new View.OnClickListener() {
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
        menuPeroduk.setLayoutManager(llm);
        menuPeroduk.setAdapter(adapter);

        getDataKetuaPengajuan();
    }
    private void getDataKetuaPengajuan() {
        Call<ProdukResponse> call = restClient.getApiService().getProgram();
        call.enqueue(new Callback<ProdukResponse>() {
            @Override
            public void onResponse(Call<ProdukResponse> call, Response<ProdukResponse> response) {
                adapter.addAll(response.body().getData());
                Log.d("tes",response.body().getData().toString());

            }

            @Override
            public void onFailure(Call<ProdukResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
