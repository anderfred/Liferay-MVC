<%@ include file="/init.jsp" %>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/ju/dt-1.10.20/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/ju/dt-1.10.20/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>

</form>
               <table id=datatable1 class="table table-striped table-bordered" style="width:100%">
                <thead>
                           <tr>
                           <th>Зарплата</th>
                               <th>Дата</th>
                               <th>Название</th>
                               <th>Работодатель</th>
                           </tr>
                       </thead>
                       <tbody>
                                                  <c:forEach var="entry" items="${paramList}">
                                                      <tr>
                                                      <td><c:out value="${entry.salary}"/></td>
                                                      <td><fmt:formatDate value="${entry.publishedDate}" pattern="yyyy-MM-dd" /></td>
                                                      <td><c:out value="${entry.text}"/> </td>
                                                      <td><c:out value="${entry.employer}"/> </td>
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
