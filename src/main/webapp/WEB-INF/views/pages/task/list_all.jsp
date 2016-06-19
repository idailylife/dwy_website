<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/19
  Time: 上午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>任务大厅 <small>Assignment Hall</small></h1>
            </div>

            <div class="assignment-list">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>发布者编号</th>
                        <th>任务编号</th>
                        <th>设备类型</th>
                        <th>发布时间</th>
                        <th>搜索入口</th>
                        <th>宝贝价格</th>
                        <th>进度</th>
                        <th>佣金</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Tasks -->
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td>${task.ownerId}</td>
                            <td>${task.id}</td>
                            <td>${(task.deviceType eq 0) ? '移动端':'电脑端'}</td>
                            <td><fmt:formatDate value="${task.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${task.entranceTypeName}</td>
                            <td>${task.price}</td>
                            <td>${task.claimedCount}/${task.qtyToBuy}</td>
                            <td>${task.commission}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <nav class="text-center">
                <ul class="pagination">
                    <c:if test="${currentPage gt 1}">
                        <li>
                            <a href="<c:url value="/task/all/${currentPage - 1}"/>" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${pageCount}" var="pageNo">
                        <li><a href="<c:url value="/task/all/${pageNo}"/>">${pageNo}</a></li>
                    </c:forEach>

                    <c:if test="${currentPage lt pageCount}">
                        <li>
                            <a href="<c:url value="/task/all/${currentPage + 1}"/>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                </ul>
            </nav>
        </div>
    </div>
</div>