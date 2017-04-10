package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.DBAccess;

/**
 * @author gaojj
 * ��ָ����Ӧ�����ݿ������
 */
public class CommandDao {
	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Command> queryCommandList(String name, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ʵ����һ��Command����
			Command command=new Command();
			command.setName(name);
			command.setDescription(description);
			//ͨ��SqlSessionִ��SQL���
			commandList=sqlSession.selectList("Command.queryCommandList",command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
		return commandList;
	}

}
