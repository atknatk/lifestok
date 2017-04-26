
package com.lifeweb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DMGenel {

    private static DMGenel instance = null;
    private static Object lock = new Object();

    public static DMGenel MyNewInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new DMGenel();
            }
        }
        return instance;
    }

    private DMGenel() {
    }

    public String MyBeginTransaction(Connection parConn) {
        try {
            parConn.setAutoCommit(false);
            return "000";
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }

    public String MyCommit(Connection parConn) {
        try {
            parConn.commit();
            parConn.setAutoCommit(true);
            return "000";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public String MyRollback(Connection parConn) {
        try {
            parConn.rollback();
            parConn.setAutoCommit(true);
            return "000";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public ResultSet MyExecuteReader(String ParCmdText, Connection ParConn) {
        ResultSet rs = null;
        try {
            rs = ParConn.createStatement().executeQuery(ParCmdText);
            return rs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String MyExecuteNonQuery(String ParCmdText, Connection ParConn) {
      
        try {
             ParConn.createStatement().executeUpdate(ParCmdText);
            return "000";
        } catch (SQLException e) {
            return e.getMessage();
        }

    }
 private int myKeyCount(String parTable) {
    if (parTable.equals("cari_hesaplar"))
      return 1;
    if (parTable.equals("ADSPAR"))
      return 4;
    if (parTable.equals("ADSTIP"))
      return 3;
    if (parTable.equals("ADSMLZ"))
      return 3;
    if (parTable.equals("ADSPAK"))
      return 4;
    if (parTable.equals("ADSFIY"))
      return 5;
    if (parTable.equals("ADSGAR"))
      return 3;
    if (parTable.equals("ADSMAS"))
      return 4;
    if (parTable.equals("CARHES")) {
      return 3;
    }
    if ((parTable.equals("ADSDOS")) || (parTable.equals("ADSIPT")))
      return 5;
    if (parTable.equals("ADSKPM"))
      return 3;
    if (parTable.equals("ADKPML")) {
      return 4;
    }
    return 1;
  }
 
  private String myIdColumnName(String parTable) {
    if (parTable.equals("cari_hesaplar"))
      return "MUSTERI_ID";
    return "";
  }
    public String myPrepareSql(String parIslem, Connection parConn, String parTable) {

        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        int colCount = 0;
        StringBuilder sqlText = new StringBuilder();
        try {
            if (parIslem.equals("trInsert")) {
                rs = MyNewInstance().MyExecuteReader("select * from " + parTable + " where 1 = 0", parConn);
                rsmd = rs.getMetaData();
                colCount = rsmd.getColumnCount();
                sqlText.append("insert into " + parTable + " (");
                for (int W_I = 1; W_I <= colCount; W_I++) {
                    sqlText.append(rsmd.getColumnName(W_I));
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(") values (");
                for (int W_I = 1; W_I <= colCount; W_I++) {
                    sqlText.append("?");
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(");");
                rs.close();
            }
            if (parIslem.equals("trModify")) {
                rs = MyNewInstance().MyExecuteReader("select * from " + parTable + " where 1 = 0", parConn);
                rsmd = rs.getMetaData();
                colCount = rsmd.getColumnCount();
                sqlText.append("update " + parTable + " set ");
                for (int W_I = 1; W_I <= colCount; W_I++) {
                    sqlText.append(rsmd.getColumnName(W_I) + " = ?");
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(" where ");
                   int keyCount = myKeyCount(parTable);
                for (int i = 1; i <= keyCount; i++) {
                    sqlText.append(rsmd.getColumnName(i) + " = ?");
                    if (i < keyCount) {
                        sqlText.append(" AND ");
                    }
                }
                rs.close();
            }
            if (parIslem.equals("trDelete")) {
                   sqlText.append("delete from " + parTable + " where " + myIdColumnName(parTable) + " = ?;");
       }
            return sqlText.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public String myPrepareSqlWithoutID(String parIslem, Connection parConn, String parTable) {

        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        int colCount = 0;
        StringBuilder sqlText = new StringBuilder();
        try {
            if (parIslem.equals("trInsert")) {
                rs = MyNewInstance().MyExecuteReader("select * from " + parTable + " where 1 = 0", parConn);
                rsmd = rs.getMetaData();
                colCount = rsmd.getColumnCount();
                sqlText.append("insert into ").append(parTable).append(" (");
                for (int W_I = 2; W_I <= colCount; W_I++) {
                    sqlText.append(rsmd.getColumnName(W_I));
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(") values (");
                for (int W_I = 2; W_I <= colCount; W_I++) {
                    sqlText.append("?");
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(");");
                rs.close();
            }
            if (parIslem.equals("trModify")) {
                rs = MyNewInstance().MyExecuteReader("select * from " + parTable + " where 1 = 0", parConn);
                rsmd = rs.getMetaData();
                colCount = rsmd.getColumnCount();
                sqlText.append("update ").append(parTable).append(" set ");
                for (int W_I = 2; W_I <= colCount; W_I++) {
                    sqlText.append(rsmd.getColumnName(W_I)).append(" = ?");
                    if (W_I < colCount) {
                        sqlText.append(",");
                    }
                }
                sqlText.append(" where ");
                int keyCount =10;
                for (int i = 2; i <= keyCount; i++) {
                    sqlText.append(rsmd.getColumnName(i)).append(" = ?");
                    if (i < keyCount) {
                        sqlText.append(" AND ");
                    }
                }
                rs.close();
            }
            if (parIslem.equals("trDelete")) {
                sqlText.append("delete from ").append(parTable).append(" where ").append(myIdColumnName(parTable)).append(" = ?;");
            }
            return sqlText.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}
