package courses.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("COSDao")
public class COSDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="courses.model.COSBean";
	
	public List<COSBean> getCOSList(Paging pageInfo, Map<String, String> map){
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<COSBean> list = sqlSessionTemplate.selectList(namespace+".GetCOSList",map,rowBounds);
		return list;
	}
}
