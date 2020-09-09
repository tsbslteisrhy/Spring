<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/sboard/css/style.css">    
</head>
<body>
    <div id="wrapper">
        <section id="board" class="list">
            <h3>글목록</h3>
            <article>
                <p>
                   	${member.nick}님 반갑습니다.
                    <a href="/sboard/user/logout" class="logout">[로그아웃]</a>
                </p>
                <table border="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <c:forEach var="article" items="${articles}">
                    <tr>
                        <td>${count = count-1}</td>
                        <td><a href="/sboard/view">${article.title}</a>&nbsp;[${article.comment}]</td>
                        <td>${article.nick}</td>
                        <td>${article.rdate.substring(2, 10)}</td>
                        <td>${article.hit}</td>
                    </c:forEach>
                    </tr>
                </table>
            </article>

            <!-- 페이지 네비게이션 -->
            <div class="paging">
            	<a href="#" class="prev">이전</a>
				<c:forEach var="i" begin="1" end="${pageEnd}">                
                	<a href="/sboard/list?pg=${i}" class="num ${currentPg == i ? 'current' : ''}">${i}</a>                
				</c:forEach>
				<a href="#" class="next">다음</a>
                
            </div>

            <!-- 글쓰기 버튼 -->
            <a href="/sboard/write" class="btnWrite">글쓰기</a>

        </section>
    </div>    
</body>
</html>