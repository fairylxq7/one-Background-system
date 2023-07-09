package com.gxan.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/*
封装增删改查方法：直接使用和数据库交互
executeUpdate:增删改
queryEntity:查询一条数据封装到对象中
queryListEntity：查询多条数据封装到List集合中
findAllForInt：查询总记录数
 */
public abstract class JdbcBuild {
   //封装返回结果是一个List类型的数据
	//执行sql语句QueryRunner
   //MapListHandler获取数据进行封装
   public List<Map<String,Object>> findAllForList(String sql,Object...params) throws SQLException{//...可变参数的方法使用
    	Connection conn=DBConnection.getConnection();
    	QueryRunner queryRunner=new QueryRunner();
    	List<Map<String,Object>> list = queryRunner.query(conn, sql, new MapListHandler(), params);
    	DBConnection.closeConnection();//打点调用
		return list;
    }
   //封装返回结果是一个int类型
   public int findAllForInt(String sql,Object...params) throws SQLException{
	 	Connection conn=DBConnection.getConnection();
    	QueryRunner queryRunner=new QueryRunner();
	    int i=0;
	    i=queryRunner.query(conn, sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet rs) throws SQLException {
				if(rs.next()){
					return rs.getInt(1);		
				}
				return 0;
			}
	    }, params);
	   DBConnection.closeConnection();
	return i;
	   
   }
   /*
    * 统一查询返回一个Map集合
    */
   public Map<String,Object> findAllForMap(String sql,Object...params) throws SQLException{
	   Connection conn=DBConnection.getConnection();
   	   QueryRunner queryRunner=new QueryRunner();
       Map<String,Object> map=queryRunner.query(conn, sql, new MapHandler(), params);
       DBConnection.closeConnection();//打点调用
	   return map;
   }

	/**
	 * 统一查询返回一个实体对象
	 */
	public  <T> T queryEntity(Class<T> clazz,String sql,Object...params) throws SQLException {
		//获取连接
		Connection conn = DBConnection.getConnection();
		QueryRunner run = new QueryRunner();
		T entity = run.query(conn,sql,new BeanHandler<T>(clazz),params);
		DBConnection.closeConnection();
		return entity;
	}

	/**
	 * 统一查询返回一个List集合的实体对象
	 */
	public <T> List<T> queryListEntity(Class<T> clazz,String sql,Object...params) throws SQLException {
		Connection conn = DBConnection.getConnection();
		QueryRunner run = new QueryRunner();
		List<T> list = run.query(conn,sql,new BeanListHandler<T>(clazz),params);
		DBConnection.closeConnection();
		return list;
	}
	/**
	 * 封装一个增、删、改方法，返回int类型
	 */
    public int executeUpdate(String sql,Object...params) throws SQLException {
		Connection conn = DBConnection.getConnection();
		QueryRunner run = new QueryRunner();
		int result = run.update(conn,sql,params);
		DBConnection.closeConnection();
    	return result;
	}







}
