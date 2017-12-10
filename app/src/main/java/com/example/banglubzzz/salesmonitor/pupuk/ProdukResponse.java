package com.example.banglubzzz.salesmonitor.pupuk;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProdukResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("rows")
	private int rows;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setRows(int rows){
		this.rows = rows;
	}

	public int getRows(){
		return rows;
	}

	@Override
 	public String toString(){
		return 
			"ProdukResponse{" + 
			"data = '" + data + '\'' + 
			",rows = '" + rows + '\'' + 
			"}";
		}
}