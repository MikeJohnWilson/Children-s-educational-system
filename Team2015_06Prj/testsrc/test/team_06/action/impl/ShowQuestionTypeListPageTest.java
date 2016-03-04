package test.team_06.action.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.team_06.action.ShowQuestionTypeListPage;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.QuestionTypeDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.dao.impl.QuestionTypeDaoImpl;
import com.team_06.entity.QuestionType;

import static org.mockito.Mockito.*;

public class ShowQuestionTypeListPageTest {

	public ActionContext ctx;
	ShowQuestionTypeListPage mtestObj;
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
	//   mtestObj = new ShowQuestionTypeListPage();
		ctx = mock(ActionContext.class);
		Map<String, Object> session = new HashMap<String, Object>();
		when(ctx.getSession()).thenReturn( session);
		
	    mtestObj = new ShowQuestionTypeListPage(){			
			public void Init()
			{
				 this.setCtx(ctx);
			} 
		};
	}
    
	@After
	public void tearDown() throws Exception {
	}
	
	private  List<QuestionType> getExpTypeList()
	{
		String []str = {"计算三角形的面积和周长","计算长方形的面价和周长",
				"计算园的周长和面积","排序",
				"求最值","三角形判断"};

		List<QuestionType> typeList = new ArrayList<QuestionType>();
		for(int i = 0; i < str.length; ++i)
		{
			QuestionType type = new QuestionType();
			type.setId(i+1);
			type.setQuestionTypeName(str[i]);
			typeList.add(type);
		}
		return typeList;
	}
	@SuppressWarnings({ "serial", "unchecked" })
	@Test
	public void testGetQuestionTypeList() {
		@SuppressWarnings("unused")
		List<QuestionType> explist = new ArrayList<QuestionType>();
		explist = getExpTypeList();
		List<QuestionType> actlist = new ArrayList<QuestionType>();
		actlist = mtestObj.getQuestionTypeList();
		for(int i = 0; i < actlist.size(); ++i)
		{
			String expStr = explist.get(i).getQuestionTypeName();
			String actStr = actlist.get(i).getQuestionTypeName();
			assertEquals(expStr,actStr);
		}		
	}
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testGetQuestionTypeUserDid(){ 
		List<QuestionType> explist = new ArrayList<QuestionType>();
		explist = getExpTypeList();
		List<QuestionType> actlist = new ArrayList<QuestionType>();
		mtestObj.setUserId(1);
		actlist = mtestObj.getQuestionTypeUserDid();
		for(int i = 0; i < actlist.size(); ++i){
			String expStr = explist.get(i).getQuestionTypeName();
			String actStr = actlist.get(i).getQuestionTypeName();
			System.out.println(expStr);
			System.out.println(actStr);
			assertEquals(expStr,actStr);
		}
		//Assert.assertEquals(explist,actlist);
	}
	@Test
	public void testGetNumOfUserDid(){	
	    int expNum = 0;
	    String expStr = String.valueOf(expNum);
		int userId = 9;
		mtestObj.setUserId(userId);
		String act = mtestObj.getNumOfUserDid();
	    Assert.assertEquals(expStr,act);
	}
	@Test
	public void testexcute()
	{
		String exp = "success";
		String act = mtestObj.execute();
		assertEquals(exp,act);
	}
}
