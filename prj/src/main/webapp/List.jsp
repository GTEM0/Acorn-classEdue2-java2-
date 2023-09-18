<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%
  String dbDriver = "com.mysql.cj.jdbc.Driver";

  String dbUrl = "jdbc:mysql://localhost:3306/a1?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
  String dbUser = "root";
  String dbPass = "";

  Connection con = null;
  Statement stmt = null;
  ResultSet rs = null;

  String sql = "SELECT * FROM article ORDER BY id DESC";

  List<Map<String, Object>> articles = new ArrayList<>();

  try {
    Class.forName(dbDriver);

    con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
    stmt = con.createStatement();
    rs = stmt.executeQuery(sql);

    while (rs.next()) {
      int id = rs.getInt("id");
      String regDate = rs.getString("regDate");
      String title = rs.getString("title");
      String body = rs.getString("body");
      String nickname = rs.getString("nickname");

      Map<String, Object> article = new HashMap<>();
      article.put("id", id);
      article.put("regDate", regDate);
      article.put("nickname", nickname);
      article.put("title", title);
      article.put("body", body);

      articles.add(article);
    }

  } catch (SQLException e) {
    System.out.println("SQLException : " + e.getMessage());
  } catch (ClassNotFoundException e) {
    System.out.println("ClassNotFoundException : " + e.getMessage());
  } finally {
    if (rs != null) {
      try {
        rs.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 > div {
  display: inline-block;
}
h1 > .a1 {
	font-size:3rem;
	font-family:Yj INITIALPOSITIVE;
	color:red;
}
h1 > .a2 {
	font-size:2rem;
	font-family:"굴림체";
	font-weight:bold;
	color:orange;
}
h1 > .a3 {
	font-size:4rem;
	font-family:"바탕체";
	font-weight:bold;
	color:gold;
}
h1 > .a4 {
	font-size:3rem;
	font-family:D2coding;
	font-weight:bold;
	color:green;
}
h1 > .a5 {
	font-size:5rem;
	font-family:Yj WADAG;
	font-weight:bold;
	color:blue;
}
h1 > .a6 {
	font-size:2rem;
	font-family:"궁서체";
	font-weight:bold;
	color:purple;
}
</style>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
  <h1>
    <div class = "a1">게</div>
    <div class = "a2">시</div>
    <div class = "a3">물</div> &nbsp;
    <div class = "a4">리</div>
    <div class = "a5">스</div>
    <div class = "a6">트</div>
  </h1>

  <div>
    <a href="./Write.jsp">작성하기</a>
  </div>
	<br>
  <form action="./doDelete">
  <% ArrayList<Integer> arr = new ArrayList<>(); %>
    <%
      for (int i = 0; i < articles.size(); i++) {
        Map<String, Object> article = articles.get(i);
    %>
    <div>
      번호 :
      <%=article.get("id")%>
    </div>
    <div>
      별명 :
      <%=article.get("nickname")%>
    </div>
    <div>
      작성일 :
      <%=article.get("regDate")%>
    </div>
    <div>
      제목 :
      <%=article.get("title")%>
    </div>
    <div>
      내용 :
      <%=article.get("body")%>
    </div>
    <div>
      <input type="hidden" name="id" value="<%=article.get("id")%>">
    </div>
    <div>
      <button
        onclick="location.href = 'http://localhost:8081/Exam1/doDelete?id='+<%=article.get("id")%>;">삭제</button>
    </div>
  </form>
  <hr>
  <%
    }
  %>
</body>

</html>