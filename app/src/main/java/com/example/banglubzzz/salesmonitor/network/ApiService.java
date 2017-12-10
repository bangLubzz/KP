package com.example.banglubzzz.salesmonitor.network;




import com.example.banglubzzz.salesmonitor.pupuk.ProdukResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {



    @GET("api/produk")
    Call<ProdukResponse> getProgram();
//
//    @GET("api/sub_program/{program_id}")
//    Call<ProgramZis> getProgramDetail(@Path("program_id") String program_id);
//
//    @GET
//    Call<Slider> getSlider(@Url String url);
//
//    @POST("api/cek_email")
//    @FormUrlEncoded
//    Call<EmailForm> postEmail(@Field("email") String email);
//

//    @POST("api/User/register")
//    @FormUrlEncoded
//    Call<ApiResponse> postRegister(
//            @Field("nik") String nik,
//            @Field("email") String email,
//            @Field("gaji_pokok") String gaji_pokok,
//            @Field("hp") String hp,
//            @Field("password") String password,
//            @Field("confirm_password") String confirm_password);
//
//    @POST("api/User/login")
//    @FormUrlEncoded
//    Call<ApiResponse> postLogin(
//            @Field("email") String email,
//            @Field("password") String password);
//
//    @POST("api/User/reset")
//    @FormUrlEncoded
//    Call<ApiResponse> postReset(
//            @Field("email") String email,
//            @Field("nik") String nik);

}

