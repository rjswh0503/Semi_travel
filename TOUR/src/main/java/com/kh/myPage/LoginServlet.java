package com.kh.myPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("update".equals(action)) {
			updateUser(request, response);
		} else if ("login".equals(action)) {
			login(request, response);
		} else if ("checkPasswordEdit".equals(action)) {
			checkPasswordEdit(request, response);
		} else if ("updatePassword".equals(action)) {
			updatePassword(request, response);
		} else if ("userDeletePassword".equals(action)) {
			userDeletePassword(request, response);
		} else if ("deleteUser".equals(action)) {
			deleteUser(request, response);
		} else if ("signIn".equals(action)) {
			signIn(request, response);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updateUser 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String userId = request.getParameter("USER_ID");
		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newEmail");
		String newPhone = request.getParameter("newPhone");
		String newSex = request.getParameter("newSex");

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			connection.setAutoCommit(false);

			String sqlUpdateUser = "UPDATE USER_INFO SET USER_NAME=?, USER_SEX=?, USER_EMAIL=?, USER_PHONE=? WHERE USER_ID=?";
			try (PreparedStatement ps = connection.prepareStatement(sqlUpdateUser)) {
				ps.setString(1, newName);
				ps.setString(2, newSex);
				ps.setString(3, newEmail);
				ps.setString(4, newPhone);
				ps.setString(5, userId);

				int rowsUpdated = ps.executeUpdate();

				if (rowsUpdated > 0) {
					// Retrieve the HttpSession
					HttpSession session = request.getSession();

					// Update the session attributes
					session.setAttribute("user_name", newName);
					session.setAttribute("user_sex", newSex);
					session.setAttribute("user_email", newEmail);
					session.setAttribute("user_phone", newPhone);

					connection.commit();
					String redirectURL = request.getContextPath() + "/myPage/user-info.jsp";
					response.sendRedirect(redirectURL);
				} else {
					response.getWriter().println("No rows updated.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("업데이트 실패");
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("log in 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String user_id = request.getParameter("USER_ID");
			String user_pw = request.getParameter("USER_PW");

			String sql = "SELECT * FROM USER_INFO WHERE USER_ID =? AND USER_PW =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_pw);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("user_id", resultSet.getString("USER_ID"));
				session.setAttribute("user_pw", resultSet.getString("USER_PW"));
				session.setAttribute("user_email", resultSet.getString("USER_EMAIL"));
				session.setAttribute("user_phone", resultSet.getString("USER_PHONE"));
				session.setAttribute("user_name", resultSet.getString("USER_NAME"));
				session.setAttribute("user_sex", resultSet.getString("USER_SEX"));
				session.setAttribute("user_age", resultSet.getString("USER_AGE"));

				response.sendRedirect("website.jsp");
			} else {
				request.setAttribute("loginError", "true");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void checkPasswordEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("password 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");

			String getPasswordQuery = "SELECT USER_PW FROM USER_INFO WHERE USER_ID=?";
			try (PreparedStatement getPasswordStatement = connection.prepareStatement(getPasswordQuery)) {
				getPasswordStatement.setString(1, user_id);
				ResultSet resultSet = getPasswordStatement.executeQuery();

				if (resultSet.next()) {
					String currentUserPassword = resultSet.getString("USER_PW");

					session.setAttribute("current_user_password", currentUserPassword);

					String enteredPassword = request.getParameter("USER_PW");

					if (currentUserPassword.equals(enteredPassword)) {
						response.sendRedirect(request.getContextPath() + "/myPage/user_password.jsp");
					} else {
						String wrongPassword = "비밀번호가 일치하지 않습니다.";
						request.setAttribute("wrongPassword", "true");
						request.setAttribute("wrongPassword", wrongPassword);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/user_password-edit.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updatePassword 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");
			String newPassword = request.getParameter("newPassword");
			String confirmNewPassword = request.getParameter("confirmPassword");

			if (newPassword.equals(confirmNewPassword)) {
				String updatePasswordQuery = "UPDATE USER_INFO SET USER_PW=? WHERE USER_ID=?";
				try (PreparedStatement ps = connection.prepareStatement(updatePasswordQuery)) {
					ps.setString(1, newPassword);
					ps.setString(2, user_id);

					int rowsUpdated = ps.executeUpdate();

					if (rowsUpdated > 0) {
						response.sendRedirect(request.getContextPath() + "/myPage/user_password-edit.jsp");
					} else {
						response.getWriter().println("Failed to update password.");
					}
				}
			} else {
				String passwordMismatch = "비밀번호가 일치하지 않습니다.";
				request.setAttribute("passwordMismatch", "true");
				request.setAttribute("passwordMismatch", passwordMismatch);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/user_password.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void userDeletePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("userDeletePassword 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");

			String getPasswordQuery = "SELECT USER_PW FROM USER_INFO WHERE USER_ID=?";
			try (PreparedStatement getPasswordStatement = connection.prepareStatement(getPasswordQuery)) {
				getPasswordStatement.setString(1, user_id);
				ResultSet resultSet = getPasswordStatement.executeQuery();

				if (resultSet.next()) {
					String currentUserPassword = resultSet.getString("USER_PW");

					session.setAttribute("current_user_password", currentUserPassword);

					String enteredPassword = request.getParameter("USER_PW");

					if (currentUserPassword.equals(enteredPassword)) {
						response.sendRedirect(request.getContextPath() + "/myPage/user-delete-confirm.jsp");
					} else {
						String wrongPassword = "비밀번호가 일치하지 않습니다.";
						request.setAttribute("wrongPassword", "true");
						request.setAttribute("wrongPassword", wrongPassword);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/user-delete.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("deleteUser 정상 작동중");
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");

			String deleteUserQuery = "DELETE FROM USER_INFO WHERE USER_ID=?";
			try (PreparedStatement ps = connection.prepareStatement(deleteUserQuery)) {
				ps.setString(1, user_id);
				ps.executeUpdate();
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");

				int rowsDeleted = ps.executeUpdate();

				if (rowsDeleted > 0) {
					session.invalidate();
					response.sendRedirect(request.getContextPath() + "/login.jsp");
				} else {
					response.getWriter().println("회원탈퇴 실패");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("signIn 정상 작동중");

		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "tour";
		String jdbcPassword = "1234";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			String user_email = request.getParameter("user_email");
			String user_phone = request.getParameter("user_phone");
			String user_name = request.getParameter("user_name");
			String user_sex = request.getParameter("user_sex");
			String user_age = request.getParameter("user_age");

			java.sql.Date sqlDate = java.sql.Date.valueOf(user_age);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = sdf.format(new Date());

			String sql = "INSERT INTO USER_INFO (USER_ID, USER_PW, USER_EMAIL, USER_PHONE, USER_NAME, USER_SEX, USER_AGE, USER_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, user_id);
				preparedStatement.setString(2, user_pw);
				preparedStatement.setString(3, user_email);
				preparedStatement.setString(4, user_phone);
				preparedStatement.setString(5, user_name);
				preparedStatement.setString(6, user_sex);
				preparedStatement.setDate(7, sqlDate);

				preparedStatement.setTimestamp(8, Timestamp.valueOf(formattedDate));

				preparedStatement.executeUpdate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			response.sendRedirect(request.getContextPath() + "/signIn/errorId.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/signIn/signIn.jsp");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login.jsp");
	}

}
