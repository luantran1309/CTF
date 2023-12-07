package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuenMatKhau_View;
import view.DangNhap_View;
import view.TrangChu_Vi;

public class TrangChu_Controller implements ActionListener {
	private TrangChu_Vi manHinhChinh_View;

	public TrangChu_Controller(TrangChu_Vi manHinhChinh_View) {
		super();
		this.manHinhChinh_View = manHinhChinh_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("QUẢN LÝ KHO")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyKho();
		} else if (cm.equals("QUẢN LÝ BÁN HÀNG")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyBanHang();
		} else if (cm.equals("THỐNG KÊ")) {
			this.manHinhChinh_View.chuyenSangManHinhThongKe();
		} else if (cm.equals("DOANH THU")) {
			this.manHinhChinh_View.chuyenSangManHinhDoanhThu();
		}else if(cm.equals("Đăng xuất")) {
			this.manHinhChinh_View.chuyenVeManHinhDangNhap();
		}else if(cm.equals("Thanh toán")) {
			this.manHinhChinh_View.chuyenSangManHinhXacNhan();
		}else if(cm.equals("Trở lại")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyBanHang();
		}
	}

}
