package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/organizer";
	public static final String USER = "root";
	public static final String PASS = "";
	
		public static Connection getConnection() { //método que devolve a conexão / static: que não precisas criar um objeto da classe connectionFactory
			try {//Tratamento de exceções/erros
				Class.forName(DRIVER);// carrega o drive(mysql) pra dentro da aplicação
				return DriverManager.getConnection(URL, USER, PASS); // faz a conexão considerando os parâmetros (url, user e pass)
			} catch (Exception ex) {
				throw new RuntimeException("Erro na conexão com banco de dados", ex);
			}
		}
		
		public static void closeConnection(Connection connection) {
			try {
				if (connection != null) {
					connection.close();
					
				} 
			} catch (Exception ex) {
					throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
				}
			
			
		}

}
