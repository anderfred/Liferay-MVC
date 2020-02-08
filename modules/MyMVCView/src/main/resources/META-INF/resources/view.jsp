<%@ include file="/init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<liferay-portlet:actionURL name="showAreaAndSpec" var="showAreaAndSpecUrl" />

<aui:form action="<%= showAreaAndSpecUrl %>" method="post">

  <aui:select name="areaSelect" id="areaSelect" label ="Выберите область">
    <c:forEach var="entry" items="${areas}">
     <aui:option value="${entry.key}">"${entry.value}"</aui:option>
      </c:forEach>
  </aui:select>

  <aui:select name="specSelect" id="specSelect" label ="Выберите специализацию">
      <c:forEach var="entry" items="${specs}">
       <aui:option value="${entry.key}">"${entry.value}"</aui:option>
        </c:forEach>
    </aui:select>

	<aui:button-row>
		<input class="btn btn-primary" type="submit" value="Submit">
	</aui:button-row>
</aui:form>