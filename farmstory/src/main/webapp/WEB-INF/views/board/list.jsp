<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<jsp:include page="./inc/_aside_${group}.jsp" />
<section id="board" class="list">
    <h3>글목록</h3>
    <article>
        <table border="0">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td><a href="/farmstory/board/view?group=${group}&cate=${cate}">제목입니다.</a>&nbsp;[3]</td>
                <td>길동</td>
                <td>20-09-10</td>
                <td>3</td>
            </tr>
        </table>
    </article>

    <!-- 페이지 네비게이션 -->
        <div class="paging">
        	<a href="#" class="prev">이전</a>
            <a href="#" class="num current"></a>                
			<a href="#" class="next">다음</a>
        </div>

        <!-- 글쓰기 버튼 -->
    <a href="/farmstory/board/write?group=${group}&cate=${cate}" class="btnWrite">글쓰기</a>

</section>
<%@ include file="./inc/_aside_tail.jsp" %>
<%@ include file="../_footer.jsp" %>