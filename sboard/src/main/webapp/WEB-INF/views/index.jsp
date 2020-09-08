<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 로그인 안 한 경우 로그인으로 이동 -->
<c:if test="${empty member}">
	<jsp:forward page="/user/login"></jsp:forward>
</c:if>

<!-- 로그인 한 경우 리스트로 이동 -->
<c:if test="${member}">
	<jsp:forward page="/list"></jsp:forward>
</c:if>
