package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.TrangChu_Vi;

public class QlbhController implements ActionListener{
	TrangChu_Vi trangChu_View;
	
	public QlbhController(TrangChu_Vi trangChu_View) {
		this.trangChu_View = trangChu_View;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showConfirmDialog(trangChu_View, "Bạn vừa nhấn: " + cm);
		if(cm.equals("Tìm kiếm")) {
			trangChu_View.TimKiemBanHang();
		}
		else if (cm.equals("Thanh toán")) {
			trangChu_View.HienThiBangDaChon();
		}
		else if (cm.equals("Xóa hàng")) {
			trangChu_View.XoaHangDaChon();
		}
		else if (cm.equals("Chỉnh sửa")) {
			trangChu_View.ChinhSuaDaChon();
		}
		else if (cm.equals("Xác nhận")) {
			trangChu_View.XacNhanDaChon();
		}
		else if (cm.equals("Trở lại")) {
			trangChu_View.TroLaiBangBanHang();
		}
		
	}

}
