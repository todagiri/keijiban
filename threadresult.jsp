<%@ page pageEncoding="Windows-31J"
	import="java.util.*,bean.*"
	contentType="text/html;charset=Windows-31J"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<title>�X���b�h�ꗗ</title>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<a href="index.html">
	
	<style type="text/css">
	#biaoge{
		margin:6px;
	padding:2px;
		text-align:center;
	}

	#biaoge table{
		margin:0px auto;
	}
	</style>
	
	<div class="text" style=" text-align:center;">

	<hr>
	
	<h1>�X���b�h�ꗗ</h1>
	
	<c:if test="${ fn:length(al) < 100}" >
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp
		
		<a href="threadnew">
	</c:if>
	<c:if test="${ fn:length(al) >= 100 }" >
		�X���b�h��������𒴂��܂����B<a href="showthread?thread=11">�Ǘ���</a>�֕񍐂��Ă��������B
	</c:if>
	
	</div>
	<div id="biaoge" style=" text-align:center;">
	
		<tr> <th>�X���b�h�쐬���</th><br><th>�^�C�g��</th> <th>�J�e�S��</th> <th>���X��</th> </tr>
		<br><br>
		<c:forEach var="tb" items="${al}">
			<tr>
				<td> <a href="/kb/showthread?thread=${tb.threadNo}"> <c:out value="${tb.title}" /> </a> </td>
				<td> <c:out value="${tb.category}" /> </td>
				<td> <c:out value="${tb.commentCount}" /> </td>
			</tr><br><br>
		</c:forEach>
	</table>
	<br>
	<!-- no-break space �̗��ŁA���s����Ȃ��󔒕��� -->
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp
		
		
	<br><br>

	</div>

</body>
</html>