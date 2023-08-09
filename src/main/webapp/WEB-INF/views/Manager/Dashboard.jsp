<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if ((session.getAttribute("userDetails") == null) || (session.getAttribute("userDetails") == "")) {
%>
 <c:redirect url="../"></c:redirect>
<%}else{%>

<%@include file="include/m_template.jsp" %>
<%@include file="include/m_cards.jsp" %>
<%@include file="include/m_footer.jsp" %>
<%@include file="include/m_logout_alert.jsp" %>
<%}%>