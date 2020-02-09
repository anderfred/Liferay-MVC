<%@ include file="/init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<portlet:actionURL name="showAreaAndSpec" var="showAreaAndSpecUrl">
    <portlet:param name="jspPage" value="/showStandardData.jsp" />
 </portlet:actionURL>

<portlet:renderURL var="bladeRender">
	<portlet:param name="jspPage" value="/showStandardData.jsp" />
</portlet:renderURL>

<aui:button href="<%= bladeRender %>" value="Показать вакансии для Новосибирска" />

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
		<input class="btn btn-primary" type="submit" value="Показать">
	</aui:button-row>
</aui:form>