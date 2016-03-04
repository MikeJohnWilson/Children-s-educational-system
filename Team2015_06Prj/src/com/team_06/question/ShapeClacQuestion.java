package com.team_06.question;

public interface ShapeClacQuestion extends Question {
	/**
	 * 系统获取图形的正确面积.
	 */
	public double getRightArea();

	/**
	 * 系统获取图形的正确周长.
	 */
	public double getRightPerimeter();

	/**
	 * 设置面积 答案、
	 * 
	 * @param area
	 *            面积值
	 * @return 答案正确否,正确：true,错误：false。
	 */
	public boolean setAreaAnswer(double area);

	/**
	 * 设置周长 答案、
	 * 
	 * @param perimeter
	 *            周长值
	 * @return 答案正确否,正确：true,错误：false。
	 */
	public boolean setPerimeterAnswer(double perimeter);

	/**
	 * 是否回答面积
	 * 
	 * @return 是否回答，回答true 未答 false
	 */
	public boolean AnseweredArea();

	/**
	 * 是否回答周长.
	 * 
	 * @return 是否回答， 回答 true， 未答 false.
	 */
	public boolean AnseweredPerimeter();

	/**
	 * 获取形状名称.
	 * 
	 * @return 形状名称.
	 */
	public String getShapeName();
}
