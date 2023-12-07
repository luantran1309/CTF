package model;

import java.time.LocalDate;

public class HangHoa {
	private String maSanPham;
	private String tenSanPham;
	private String nhaSanXuat;
	private int soLuong;
	private double giaBan;
	private LocalDate ngaySanXuat;
	private LocalDate hanSuDung;

	public HangHoa() {
		// TODO Auto-generated constructor stub
	}

	public HangHoa(String maSanPham, String tenSanPham, String nhaSanXuat, int soLuong, double giaBan,LocalDate ngaySanXuat, LocalDate hanSuDung) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.nhaSanXuat = nhaSanXuat;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(LocalDate hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

}