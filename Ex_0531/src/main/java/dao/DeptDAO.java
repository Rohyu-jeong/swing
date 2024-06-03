package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// 부서테이블 조회
	// 반환형을 결정하는 것 -> 내가 받환받을 데이터를 어떤 형식으로 받을 것인가
	// 테이블 전체 -> 하나의 행을 각각의 객체에 담은 뒤 객체를 list에 담아서 반호나
	// 하나의 행 -> 객체에 담아서 객체를 반환
	// 추가, 수정, 삭제 -> 바뀐 행 수만큼 정수로 반환
	public List<DeptVO> select() {
		// factory는 어떤 db로 연결하고 어떤 mapper로 접근해야 하는지까지만 알고 있다.
		// 그 정보를 갖고 실제로 쿼리문을 요청하는 것은 SqlSession객체이다.
		SqlSession sqlSession = factory.openSession();
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		sqlSession.close();
		
		return list;
	}
}
