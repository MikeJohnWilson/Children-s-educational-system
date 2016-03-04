package com.team_06.question;

public interface ShapeClacQuestion extends Question {
	/**
	 * ϵͳ��ȡͼ�ε���ȷ���.
	 */
	public double getRightArea();

	/**
	 * ϵͳ��ȡͼ�ε���ȷ�ܳ�.
	 */
	public double getRightPerimeter();

	/**
	 * ������� �𰸡�
	 * 
	 * @param area
	 *            ���ֵ
	 * @return ����ȷ��,��ȷ��true,����false��
	 */
	public boolean setAreaAnswer(double area);

	/**
	 * �����ܳ� �𰸡�
	 * 
	 * @param perimeter
	 *            �ܳ�ֵ
	 * @return ����ȷ��,��ȷ��true,����false��
	 */
	public boolean setPerimeterAnswer(double perimeter);

	/**
	 * �Ƿ�ش����
	 * 
	 * @return �Ƿ�ش𣬻ش�true δ�� false
	 */
	public boolean AnseweredArea();

	/**
	 * �Ƿ�ش��ܳ�.
	 * 
	 * @return �Ƿ�ش� �ش� true�� δ�� false.
	 */
	public boolean AnseweredPerimeter();

	/**
	 * ��ȡ��״����.
	 * 
	 * @return ��״����.
	 */
	public String getShapeName();
}
