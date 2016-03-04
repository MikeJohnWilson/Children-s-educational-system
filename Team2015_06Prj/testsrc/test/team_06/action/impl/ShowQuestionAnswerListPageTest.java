package test.team_06.action.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.team_06.action.ShowQuestionAnswerListPage;
import com.team_06.action.ShowQuestionAnswerPage;
import com.team_06.action.ShowQuestionTypeListPage;
import com.team_06.entity.Questions;
import com.team_06.question.Question;

public class ShowQuestionAnswerListPageTest {

	public ActionContext ctx;
	ShowQuestionAnswerListPage mtestObj;
	@Before
	public void setUp() throws Exception {
		ctx = mock(ActionContext.class);
		Map<String, Object> session = new HashMap<String, Object>();
		when(ctx.getSession()).thenReturn( session);
		
	    mtestObj = new ShowQuestionAnswerListPage(){			
			public void Init()
			{
				 this.setCtx(ctx);
			} 
		};
	}

	@After
	public void tearDown() throws Exception {
	}
	
	// ��������Ԥ�ڵ����⼯��������⼯����ΪUserID = 1��
    //�������������⼯
    public List<Questions> getExpAllQuestions(){
    	List<Questions> expList = new ArrayList<Questions>();
		int testNum = 10;
		for(int i = 0;i < testNum; ++i)
		{
			Questions que = new Questions();
			que.setId(93+i);
		    que.setQuestionName("test");
			que.setQuestionBelonged(0);        
            que.setQusetionType(0);
            expList.add(que);
		}	
	    return expList;	
    }
    // ����ָ��ҳ�������⼯
   public List<Questions> getTestDefQuestions(int num){
    	
    	List<Questions> expAllList = new ArrayList<Questions>();
		expAllList = getExpAllQuestions();
		List<Questions> expList = new ArrayList<Questions>();
		int begin = 0;
		int unit_count = 5;  //�����ÿ������ҳ����ʾ����Ŀ����
		//��ShowQuestionAnswerListPage�е�showNum���ָ߶�һ��
		begin = ( num - 1 ) * unit_count;
		for(int i = begin; i < begin + unit_count; ++ i )
		{
			expList.add(expAllList.get(i));
		}
    	return expList;
    }
	@Test
	public void testGetAllQuestion() {
		int first_page = 1;
		List<Questions> expList = new ArrayList<Questions>();
		expList = getTestDefQuestions(first_page);
		int User_id = 0;
		mtestObj.setUserId(User_id);
		List<Questions> actList = new ArrayList<Questions>();
		actList = mtestObj.getAllQuestion();
		// ���������⣬Ϊʲô�����ͬ�������޷���ȣ��Ҳ�������ô�ã�
		// ���Ҷ���ľ��飬������Assert.assertEquals() ������������⣬����find find������
	    for(int i = 0;i<5;i++)
	    {
	    	String actstr = actList.get(i).getQuestionName();
	    
	    	String expstr = expList.get(i).getQuestionName();
	    	assertEquals(expstr,actstr);
	    	
	    }
		
	}
	@Test
	public void testnextPage(){
		
		// next_page ��ʾ��һҳ��ҳ����Ĭ�ϵ�ǰҳ��Ϊ��һҳ��
		                          //������һҳΪ�ڶ�ҳ
		
		String expstr = "success";
		int User_id = 1;
		mtestObj.setUserId(User_id);
		mtestObj.getAllQuestion();
		String actstr = mtestObj.nextPage();
		assertEquals(expstr,actstr);
	}
	@Test
	public void testbeforePage(){
		String expstr = "success" ;
		int User_id = 1;
		mtestObj.setUserId(User_id);
		mtestObj.getAllQuestion();
		
		
		String actstr = mtestObj.beforePage();
		assertEquals(expstr,actstr);
	}
	@Test
	public void testexecute(){
		String expstr = "success";
		String actstr = mtestObj.execute();
		assertEquals(expstr,actstr);
	}
}
