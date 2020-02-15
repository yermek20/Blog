package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DBManager {

    private static ArrayList<Users> users = new ArrayList<>();

    String dbUrl = "jdbc:mysql://localhost:3306/project_blog?useUnicode=true&serverTimezone=UTC";
    String dbUser = "root";
    String dbPassword = "";

    private static Connection connection;

    public void connect() {
        try {
            //создаём объект каласса class для класса указанного в аргументе
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Users getUser(){

        Users user = null;

        try{

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM users");


            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }


    public Users getUser(String email){

        Users user = null;

        try{

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM users WHERE email = ?");

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }

    public static Users getUser(String login, String password){
        ArrayList<Users> userArrayList = new ArrayList<>();
        try {
            //PreparedStatement: предварительно компилирует запросы которые могут содержать входные параметры
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");

                userArrayList.add(new Users(id, email, pass, full_name));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Users u: userArrayList){
            if (u.getEmail().equals(login)&&u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public static Users checkUser(String name, String Password){
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        Users user = null;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, Password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("email");
                String userpassword = resultSet.getString("password");
                user = new Users(username,userpassword);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return user;
    }

    public void addUser(Users user){
        try{

            PreparedStatement statement =
                    connection.prepareStatement("" +
                            "INSERT INTO users (id, email, password, full_name) " +
                            "VALUES (NULL, ?,?,?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteUser(Long id){
        try{

            PreparedStatement statement =
                    connection.prepareStatement("DELETE FROM users " +
                            "WHERE id =?");

            statement.setLong(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addBlog(Blogs blog){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    " INSERT INTO blogs (id, user_id, title, content, post_date, active) " +
                    " VALUES (NULL,?,?,?,NOW(),1)");

            statement.setLong(1, blog.getAuthor().getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContent());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Blogs> getAllBlogs(){

        ArrayList<Blogs> blogs = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    " SELECT b.id, b.user_id, b.title, b.short_content, b.post_date, b.active, u.full_name " +
                    " FROM blogs b " +
                    " LEFT OUTER JOIN users u ON b.user_id = u.id " +
                    " ORDER BY b.post_date DESC ");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                blogs.add(new Blogs(
                        resultSet.getLong("id"),
                        new Users(
                                resultSet.getLong("user_id"),
                                null, null,
                                resultSet.getString("full_name")
                        ),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        null,
                        resultSet.getDate("post_date"),
                        resultSet.getInt("active"),
                        null
                ));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return blogs;

    }
    public Blogs getBlog(Long id){

        Blogs blog = null;

        try{

            PreparedStatement statement =
                    connection.prepareStatement("" +
                            "SELECT b.id, b.title, b.short_content, b.content, b.user_id, b.post_date, u.full_name, u.email " +
                            "FROM blogs b " +
                            "LEFT OUTER JOIN users u ON u.id = b.user_id " +
                            "WHERE b.id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){

                Long userId = resultSet.getLong("user_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String shortContent = resultSet.getString("short_content");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                Date postDate = resultSet.getDate("post_date");

                blog = new Blogs(id, new Users(userId, email, null, fullName),title, shortContent, content, postDate, 0,null);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return blog;

    }
    public void deleteBlog(Long id, Long userId){
        try{

            PreparedStatement statement =
                    connection.prepareStatement("DELETE FROM blogs " +
                            "WHERE id =? AND user_id = ?");

            statement.setLong(1, id);
            statement.setLong(2, userId);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
