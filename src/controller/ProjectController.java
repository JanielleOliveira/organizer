package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;;

public class ProjectController {

	public void save(Project project) {
		String sql = "INSERT INTO projects " + " " + "(name, " + " " + "description, " + "" + "createdAt, " + " "
				+ "updatedAt) " + "VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();

			// Preparando a query
			statement = connection.prepareStatement(sql);

			// Setando os valores do statement

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

			// Executando a query
			statement.execute();

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar o projeto " + ex.getMessage(), ex);

		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Project project) { // Atualizar tarefa selecionada

		String sql = "UPDATE tasks SET " // Script SQL com UPDATE
				+ "name = ?, " + " " + "createdAt = ?, " + " " + "updatesAt = ?, " + " " + "WHERE ID = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();

			// Preparando a query
			statement = connection.prepareStatement(sql);

			// Setando os valores do statement
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());

			// Executando a query
			statement.execute();

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao atualizar o projeto" + ex.getMessage(), ex);

		} finally {

			ConnectionFactory.closeConnection(connection, statement); // Fecha a conexão
		}

	}

	public List<Project> getall() { // Devolve uma lista de tarefas

		String sql = "SELECT * FROM projects";

		// Criação da lista de projetos
		List<Project> projects = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			// Execução da query
			resultSet = statement.executeQuery();

			// Enquanto existir dados no banco de dados, faça!
			while (resultSet.next()) {

				Project project = new Project(0, sql, sql, null, null);

				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));

				// Adiciono o contato recuperado a lista de contatos
				projects.add((Project) projects);

			}

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);

		} finally {

			ConnectionFactory.closeConnection(connection, statement, resultSet); // Fecha a conexão
		}

		// Lista de tarefas que foi criada e carregada do banco de dados
		return projects;
	}

	public void removeById(int projectId) throws SQLException { // Deleta o projeto selecionado

		String sql = "DELETE FROM projects WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		// Tratamento de erros
		try {

			// Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();

			// Ajuda a preparar o comando sql que vai ser executado no banco
			statement = connection.prepareStatement(sql);

			// Setando valores
			statement.setInt(1, projectId);

			// executando a query
			statement.execute();

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao deletar o projeto" + ex.getMessage(), ex);

		} finally {

			ConnectionFactory.closeConnection(connection, statement); // Fecha a conexão
		}

	}

}
