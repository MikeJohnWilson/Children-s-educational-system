package com.team_06.random;

public class Random {
	/**
	 * ����һ�������
	 * 
	 * @return һ�������
	 */
	public int randomNum() {
		int num = (int) Math.abs(Math.random() * 100 + 1);
		return num;
	}
}
