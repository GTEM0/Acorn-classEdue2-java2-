<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- index.html -->
<!DOCTYPE html>
<html>
<head>
    <title>질문과 답변</title>
</head>
<body>
    <h1>질문 목록</h1>
    <ul>
        <%-- 질문 목록을 표시하기 위한 JSP 코드를 작성합니다. --%>
    </ul>

    <h2>새 질문 등록</h2>
    <form action="AddQuestionServlet" method="post">
        <input type="text" name="question" placeholder="질문 내용" required>
        <input type="submit" value="등록">
    </form>

    <h2>답변 등록</h2>
    <form action="AddAnswerServlet" method="post">
        <select name="questionId">
            <%-- 질문 목록에서 선택한 질문의 ID를 전송합니다. --%>
        </select>
        <input type="text" name="answer" placeholder="답변 내용" required>
        <input type="submit" value="등록">
    </form>
</body>
</html>
