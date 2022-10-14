package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;


public class TaskController {

	public void save(Task task) { // Salvar tarefa selecionada
		String sql = "INSERT INTO tasks "
				+ "(idProject,"+" "
				+ "name,"+" "
				+ "description,"+" "
				+ "completed,"+""
				+ "notes, "
				+ "deadeline, "+" "
				+ "createdAt, "+" "
				+ "updatesAt) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a query
			statement = connection.prepareStatement(sql);
			
			//Setando os valores do statement
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
			
			//Executando a query
			statement.execute();
			
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
			
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Task task) { // Atualizar tarefa selecionada
		
		String sql = "UPDATE tasks SET " //Script SQL com UPDATE
				+ "idProject = ?, "+" "
				+ "name = ?, "+" "
				+ "description = ?,"+" "
				+ "completed = ?, "+" "
				+ "notes = ?,  "+" "
				+ "deadeline = ?, "+" "
				+ "createdAt = ?, "+" "
				+ "updatesAt = ?, "+" "
				+ "WHERE ID = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a query
			statement = connection.prepareStatement(sql);
			
			//Setando os valores do statement
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());
			
			//Executando a query
			statement.execute();
			
			
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
			
		} finally {

			ConnectionFactory.closeConnection(connection, statement); // Fecha a conexão
		}

	}

	
	public void removeById(int taskId) throws SQLException { // Deleta a tarefa selecionada

		String sql = "DELETE FROM tasks WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		// Tratamento de erros
		try { 
			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			// Ajuda a preparar o comando sql que vai ser executado no banco
			statement = connection.prepareStatement(sql);
			
			// Setando valores
			statement.setInt(1, taskId); 
			
			//executando a query
			statement.execute(); 

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
			
		} finally {

			ConnectionFactory.closeConnection(connection, statement); // Fecha a conexão
		}

	}

	public List<Task> getall(int idProject) { // Devolve uma lista de tarefas
		
		String sql = "SELECT * FROM tasks WHERE idProject = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null; //Guarda a resposta do SELECT no bando de dados
		
		
		//Lista de tarefas que será devolvida quando a chamada de método acontecer
		List<Task> tasks = new ArrayList<Task>();
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idProject);// Setando o valor que corresponde ao filtro de busca
			
			// Valor retornado pela execução da query
			resultSet = statement.executeQuery(); 
			
			//Enquanto houver valores a serem percorridos no meu resultSet
			while (resultSet.next()) {
				
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setIdProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setNotes(resultSet.getString("notes"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCreatedAt(resultSet.getDate("createdAt"));
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				tasks.add(task);
				
			}
			
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);
			
		}finally {

			ConnectionFactory.closeConnection(connection, statement, resultSet); // Fecha a conexão
		}
		
	
		//Lista de tarefas que foi criada e carregada do banco de dados
		return tasks;
	}

}
