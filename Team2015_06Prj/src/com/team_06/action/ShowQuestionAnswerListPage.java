package com.team_06.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.entity.Questions;
import com.team_06.entity.User;

public class ShowQuestionAnswerListPage extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * �û���id����session��ȡ
	 */
	int userId;
	ActionContext ctx;
	/**
	 * �û���������������
	 */
	List<Questions> allQuestionList;
	/**
	 * ��ǰ������ʾ���û���������Ŀ
	 */
	List<Questions> showQuestionList;
	/**
	 * ÿҳ��ʾ����Ŀ��
	 */
	final int showNum = 6;
	/**
	 * ��ǰҳ��
	 */
	public static int nowPage = 1;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	public List<Questions> getAllQuestionList() {
		return allQuestionList;
	}

	public void setAllQuestionList(List<Questions> allQuestionList) {
		this.allQuestionList = allQuestionList;
	}

	public List<Questions> getShowQuestionList() {
		return showQuestionList;
	}

	public void setShowQuestionList(List<Questions> showQuestionList) {
		this.showQuestionList = showQuestionList;
	}

	public static int getNowPage() {
		return nowPage;
	}

	public static void setNowPage(int nowPage) {
		ShowQuestionAnswerListPage.nowPage = nowPage;
	}

	public int getShowNum() {
		return showNum;
	}

	/**
	 * ���췽��
	 */
	public ShowQuestionAnswerListPage() {
		Init();
	}

	/**
	 * ��ʼ��
	 */
	public void Init() {
		ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		User user = new User();
		user = (User) session.get("user");
		setUserId(user.getId());
	}

	@Override
	public String execute(){
		getAllQuestion();
		System.out.println("@@@@@@@@@@@@@@@");
		return SUCCESS;
	}
	/**
	 * ��ȡ�û����������������б���ʾǰ������¼
	 */
	public List<Questions> getAllQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
		allQuestionList = new ArrayList<Questions>();
		allQuestionList = dao.selectUserDid(getUserId());

		int key=5;
		if(allQuestionList.size()<key){
			key=allQuestionList.size();
		}
		
		showQuestionList = new ArrayList<Questions>();
		for (int i = 0; i < key; i++) {
			showQuestionList.add(allQuestionList.get(i));
		}
		return showQuestionList;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 */
	//public List<Questions> nextPage() {
	public String nextPage() {
		getAllQuestion();
		nowPage++;	
		int last=allQuestionList.size();
		
		if(last/showNum==nowPage){
			nowPage=last/showNum;
		}else if(last/showNum+1<nowPage){
			nowPage=last/showNum+1;
		}
		
		int first=(nowPage - 1) * showNum;
		
		if(first+5<last){
			last=first+5;
		}
		
		showQuestionList = new ArrayList<Questions>();
		for (int i = first-1; i < last; i++) {
			showQuestionList.add(allQuestionList.get(i));
		}
		return SUCCESS;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 */
	//public List<Questions> beforePage() {
	public String beforePage() {
		getAllQuestion();
		nowPage--;
		if(nowPage<=0){
			nowPage=1;
		}
		showQuestionList = new ArrayList<Questions>();
		
		int first=(nowPage - 1) * showNum;
		int last=(nowPage) * showNum - 1;
		
		if(first<=0){
			first=0;
		}
		
		for (int i = first; i < last; i++) {
			showQuestionList.add(allQuestionList.get(i));
		}
		return SUCCESS;
	}
}
