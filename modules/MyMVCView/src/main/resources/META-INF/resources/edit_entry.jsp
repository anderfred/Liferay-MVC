<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addEntry" var="addEntryURL" />

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

	<aui:fieldset>

		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>
*********************************************

<div class="input-group mb-3">
  <select class="custom-select" id="areaSelect" required="true">
    <option selected>Выбрать область</option>
    <c:forEach var="entry" items="${areas}">
     <option value="${entry.key}">"${entry.value}"</option>
      </c:forEach>
  </select>
</div>

<div class="input-group mb-3">
  <select class="custom-select" id="specSelect" name = "specSelect" required="true">
    <option selected>Выбрать специализацию</option>
    <c:forEach var="entry" items="${specs}">
     <option value="${entry.key}">"${entry.value}"</option>
      </c:forEach>
  </select>
</div>