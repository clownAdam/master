package kmmall;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.kmmall.bean.Atype;
import com.kmmall.dao.AtypeDao;
import com.kmmall.dao.impl.AtypeDaoImple;

public class DaoTest {
	private AtypeDao atypeDao = new AtypeDaoImple();

	@Test
	public void insertAtype() throws SQLException {
		Atype atype = new Atype("运动", 007);
		boolean res = atypeDao.insert(atype);
		System.out.println(res);
	}

	@Test
	public void selectAtypeAll() throws SQLException {
		List<Atype> res = atypeDao.select();
		System.out.println(res);
	}
}
