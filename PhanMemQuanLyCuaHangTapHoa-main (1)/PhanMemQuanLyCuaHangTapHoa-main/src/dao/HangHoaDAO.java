package dao;

import java.util.ArrayList;

public class HangHoaDAO<T> implements DAOInterface<T>{
	
	public static HangHoaDAO getInstance() {
		return new HangHoaDAO();
	}

	@Override
	public int insert(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<T> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectById(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
