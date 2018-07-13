<%@page import="java.util.Enumeration"%>
<HTML>
<BODY>
<form name="form" method="post" action="https://desa1/pkmslogout.form">
<%

out.println("<h2>Headers</h2><hr/>");
Enumeration<String> headerNames = request.getHeaderNames();
while (headerNames.hasMoreElements()) {
	String headerName = headerNames.nextElement();
	out.print("<br><strong>" + headerName + "</strong><br>");
	
	if( request.getHeaders(headerName)!=null ){
		Enumeration<String> valores=request.getHeaders(headerName);
        while (valores.hasMoreElements()) {
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <code>"+(String)valores.nextElement()+"</code><br>");
        }
	}
}

%>
<br>
<br>
<input type="submit" name="salir" value="salir">
</form>
</BODY>
</HTML>
