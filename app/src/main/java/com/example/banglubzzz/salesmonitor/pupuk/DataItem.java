package com.example.banglubzzz.salesmonitor.pupuk;


import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_produk")
	private String idProduk;

	@SerializedName("nama_produk")
	private String namaProduk;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("harga")
	private String harga;

	@SerializedName("foto")
	private String foto;

	@SerializedName("jenis")
	private String jenis;

	public void setIdProduk(String idProduk){
		this.idProduk = idProduk;
	}

	public String getIdProduk(){
		return idProduk;
	}

	public void setNamaProduk(String namaProduk){
		this.namaProduk = namaProduk;
	}

	public String getNamaProduk(){
		return namaProduk;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"id_produk = '" + idProduk + '\'' + 
			",nama_produk = '" + namaProduk + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",harga = '" + harga + '\'' + 
			",foto = '" + foto + '\'' + 
			",jenis = '" + jenis + '\'' + 
			"}";
		}
}