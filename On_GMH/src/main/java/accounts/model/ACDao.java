package accounts.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ACDao")
public class ACDao {
	private String namespace = "accounts.model.AC";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int updateac(ACBean ac) {
		int cnt=-1;
		cnt = sqlSessionTemplate.update(namespace + ".updateac", ac);
		return cnt;
	}
}