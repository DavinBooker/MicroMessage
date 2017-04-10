package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * ��message����ص����ݿ����
 * 
 * @author gaojj
 * 
 */
public class MessageDao {
	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ʵ����һ��Message����
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			//ͨ��SqlSessionִ��SQL���
			messageList=sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
		return messageList;
	}

	/*
	 * ����ɾ��
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��SqlSessionִ��SQL���
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
	}
	
	/*
	 * ����ɾ��
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��SqlSessionִ��SQL���
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
				sqlSession.close();	
			}
		}
	}
	
	public static void main(String[] args) {
        MessageDao messageDao=new MessageDao();
        messageDao.queryMessageList("", "");
        Map<String, Message> messageMap=new HashMap<String, Message>();
        messageMap.put("key", new Message());
        /*Logger log = null;
        log.debug("");*/
        
	}

	/*
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	// public List<Message> queryMessageList(String command, String description)
	// {
	// List<Message> messageList = new ArrayList<Message>();
	// try {
	// // ����sql����
	// Class.forName("com.mysql.jdbc.Driver");
	// // ��ȡ���ݿ�����
	// Connection conn = DriverManager.getConnection(
	// "jdbc:mysql://127.0.0.1:3306/test", "root", "root");
	// // �������ݿⲢ����
	// StringBuilder sql = new StringBuilder(
	// "select ID ,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
	// // �Ѳ�ѯ�������һ��������
	// List<String> paramList = new ArrayList<String>();
	// if (command != null && !"".equals(command.trim())) {
	// sql.append(" and COMMAND=?");
	// paramList.add(command);
	// }
	// if (description != null && !"".equals(description.trim())) {
	// sql.append(" and DESCRIPTION like '%' ? '%'");
	// paramList.add(description);
	// }
	//
	// PreparedStatement statement = conn.prepareStatement(sql.toString());
	// for (int i = 0; i < paramList.size(); i++) {
	// statement.setString(i + 1, paramList.get(i));
	// }
	// ResultSet rs = statement.executeQuery();
	// while (rs.next()) {
	// Message message = new Message();
	// messageList.add(message);
	// message.setId(rs.getString("ID"));
	// message.setCommand(rs.getString("COMMAND"));
	// message.setDescription(rs.getString("DESCRIPTION"));
	// message.setContent(rs.getString("CONTENT"));
	// }
	//
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return messageList;
	// }
}