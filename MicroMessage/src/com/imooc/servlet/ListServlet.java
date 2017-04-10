package com.imooc.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

/**
 * �б�ҳ���ʼ������
 * 
 * @author gaojj
 * 
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//����ҳ���ֵ
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		//��ҳ�洫ֵ
		req.setAttribute("command",command);
		req.setAttribute("description",description);
		QueryService listService=new QueryService();
		//��ѯ��Ϣ�б�������ҳ��
		req.setAttribute("messageList",listService.queryMessageList(command, description));
		//��ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}