<%@ include file="/init.jsp" %>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/ju/dt-1.10.20/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/ju/dt-1.10.20/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>

<portlet:renderURL var="showStandardDataUrl">
    <portlet:param name="mvcPath" value="/showStandardData.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="showAreaAndSpecUrl">
    <portlet:param name="mvcPath" value="/showAreaAndSpec.jsp"></portlet:param>
</portlet:renderURL>

<b> ${map1}</b>

<aui:button-row>
    <aui:button onClick="<%= showStandardDataUrl.toString() %>" value="getStandardRequest"></aui:button>
    <aui:button onClick="<%= showAreaAndSpecUrl.toString() %>" value="getAreaAndSpec"></aui:button>
</aui:button-row>

<portlet:actionURL name="makeExampleRequest" var="actionURLByPortletTagURL">
</portlet:actionURL>

<form action="${actionURLByPortletTagURL}" method="post">
    <input type="submit" value="Submit">
</form>
               <table id=datatable1 class="table table-striped table-bordered" style="width:100%">
                <thead>
                           <tr>
                               <th>Name</th>
                               <th>Position</th>
                           </tr>
                       </thead>
                       <tbody>
                                                  <c:forEach var="entry" items="${map}">
                                                      <tr>
                                                      <td><c:out value="${entry.key}"/></td>
                                                      <td><c:out value="${entry.value}"/> </td>
                                                      </tr>
                                                  </c:forEach>
                                                  </tbody>
                                                   <tfoot>
                                                              <tr>
                                                                  <th>Name</th>
                                                                  <th>Position</th>
                                                              </tr>
                                                          </tfoot>
                                              </table>



                                                  <script type="text/javascript">
                                                  $(document).ready(function() {
                                                      $('#datatable1').DataTable();
                                                  } );
                                                  </script>
