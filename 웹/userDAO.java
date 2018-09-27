package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class userDAO {

	
	//�α��� �õ�
	public int login(String uid,String upw) {
		String SQL="SELECT upw FROM USER WHERE uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { // ���� ��û�� ������ �����Ѵٸ� ��, ���̵� �����Ѵٸ�
				if(rs.getString(1).equals(upw)) {
					return 1; //�α��� ����
				}else {
					return 0; //��й�ȣ Ʋ��
				}
			}
			return -1; //���̵� ����
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return -2; //db����
	}
	
	
	// ȸ������ ����
	public int join(userDTO user) {
		String SQL="INSERT INTO USER VALUES(?,?,?,?,?,false,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUpw());
			pstmt.setString(3, user.getUemail());
			pstmt.setString(4, user.getUname());
			pstmt.setString(5, user.getUphone());
			pstmt.setString(6, user.getUemailHash());
			return pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return -1; // �̹� �����ϴ� ���̵� ����
	}
	
	
	public userDTO getUser(String uid) { // 1���� ����� ���� ��ȯ
		String SQL="SELECT * FROM user WHERE uid=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		userDTO user = new userDTO();
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUid(uid);
				user.setUpw(rs.getString("upw"));
				user.setUemail(rs.getString("uemail"));
				user.setUname(rs.getString("uname"));
				user.setUphone(rs.getString("uphone"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return user;
	}
	
	public int update(userDTO user) {
		String SQL="UPDATE USER SET upw = ? , uemail= ?, uname = ?, uphone = ? WHERE uid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUpw());
			pstmt.setString(2, user.getUemail());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getUphone());
			pstmt.setString(5, user.getUid());
			return pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return -1; 
	}
	
	
	
	// ������� ���̵� �޾Ƽ� �̸����ּҹ�ȯ
	public boolean getUserEmailChecked(String uid) {
		String SQL="SELECT uemailChecked FROM user WHERE uid=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getBoolean(1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return false; // �̸��� ���� ����, db���
	}
	
	
	//�̸��� ����Ȯ���Լ�
	public String getUserEmail(String uid) {
		String SQL="SELECT uemail FROM user WHERE uid=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return null; 
	}
	
	// Ư��������� �̸��� ��������
	public boolean setUserEmailChecked(String uid) {
		String SQL="UPDATE user SET uemailChecked=true WHERE uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null; // sql�� ������ ����� ���
		
		try {
			conn= DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e){e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e){e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return false; 
	}
	
	
	
	
}
