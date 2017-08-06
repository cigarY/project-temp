package com.wgh.core; //�����ౣ�浽com.wgh.core����

import java.io.InputStream; //����java.io.InputStream��
import java.sql.*; //����java.sql���е�������
import java.util.Properties; //����java.util.Properties��

public class ConnDB {
    public Connection conn = null; // ����Connection�����ʵ��
    public Statement stmt = null; // ����Statement�����ʵ��
    public ResultSet rs = null; // ����ResultSet�����ʵ��
    private static String dbClassName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";//���屣�����ݿ������ı���
    private static String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=db_netExam_Data";
    private static String dbUser = "sa";
    private static String dbPwd = "2252";
    public ConnDB() {   //���幹�췽��
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (Exception ex) {
            System.out.println("���ݿ����ʧ��");
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("creatConnectionError!");
        }
        if (conn == null) {
            System.err
                    .println("����: DbConnectionManager.getConnection() ������ݿ�����ʧ��.\r\n\r\n��������:"
                            + dbClassName
                            + "\r\n����λ��:"
                            + dbUrl
                            + "\r\n�û�/����"
                            + dbUser + "/" + dbPwd);
        }
        return conn;
    }

    /*
     * ���ܣ�ִ�в�ѯ���
     */
    public ResultSet executeQuery(String sql) {
        try { // ��׽�쳣
            conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); // ����쳣��Ϣ
        }
        return rs; // ���ؽ��������
    }

    /*
     * ����:ִ�и��²���
     */
    public int executeUpdate(String sql) {
        int result = 0; // ���屣�淵��ֵ�ı���
        try { // ��׽�쳣
            conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql); // ִ�и��²���
        } catch (SQLException ex) {
            result = 0; // �����淵��ֵ�ı�����ֵΪ0
        }
        return result; // ���ر��淵��ֵ�ı���
    }

    /*
     * ����:�ر����ݿ������
     */
    public void close() {
        try { // ��׽�쳣
            if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
                rs.close(); // �ر�ResultSet����
            }
            if (stmt != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
                stmt.close(); // �ر�Statement����
            }
            if (conn != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
                conn.close(); // �ر�Connection����
            }
        } catch (Exception e) {
            e.printStackTrace(System.err); // ����쳣��Ϣ
        }
    }

}
