<%@ page pageEncoding="Windows-31J"
	import="java.utill.*,bean.*"
	contentType="text/html;charsey=Windows-31J"%>
	
	
<html>
<head>
	<link href="css/style2.css" rel="stylesheet" type="text/css" />
	<title>�X���b�h�쐬</title>
</head>
<body>
	<div class="text" style=" text-align:center;">
	<h1>�X���b�h�쐬�t�H�[��</h1>
	<a href="index.html">�g�b�v</a>
	<a href="threadresult.jsp">�X���b�h�I��</a>
	<hr>
	<br>
	<from method='Post' action='newthread'>
	�^�C�g��:<input type='text' name='title' placeholder="�S�p50�����܂�">
	<select name='cat'>
		<option value="�G�k">�G�k</option>
		<option value="�Q�[��">�Q�[��</option>
		<option value="�߽��">�߽��</option>
		</select>
		<br>
		<br>
		���O:<input type='text' name='name' placeholder="�������i�S�p10�����܂Łj"><br>
		<textarea name='text' cols='50' rows='5' placeholder="�S�p1000�����܂�"></textarea><br><br>
		<input type='submit' value='�X���b�h�쐬'>
	</form>


</body>
</html>