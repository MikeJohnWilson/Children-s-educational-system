package com.team_06.random;

public class Random {
	/**
	 * 产生一个随机数
	 * 
	 * @return 一个随机数
	 */
	public int randomNum() {
		int num = (int) Math.abs(Math.random() * 100 + 1);
		return num;
	}
}
