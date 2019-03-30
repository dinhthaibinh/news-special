<%--
  Created by IntelliJ IDEA.
  User: BinhDinh
  Date: 3/23/2019
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>

</head>
<body>
<div class="card-body p-0">
    <!-- Nested Row within Card Body -->
    <div class="row">
        <div >
            <img src="http://streaming1.danviet.vn/upload/4-2017/images/2017-10-25/anh-17-1508921324-width650height812.jpg" width="430" height="550">
        </div>
        <%--<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>--%>
        <div class="col-lg-6">
            <div class="p-5">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Hello BaBe</h1>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-danger">
                        <strong>${message}</strong>
                    </div>
                </c:if>
                <form action="<c:url value="/login"/>" class="userModel" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-userModel" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="UserName" name="userName">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control form-control-userModel" id="exampleInputPassword" placeholder="Password" name=password>
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-checkbox small">
                            <input type="checkbox" class="custom-control-input" id="customCheck">
                            <label class="custom-control-label" for="customCheck">Remember Me</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-userModel btn-block">
                        Login
                    </button>
                    <hr>
                </form>
                <hr>
                <div class="text-center">
                    <a class="small" href="#">Forgot Password?</a>
                </div>
                <div class="text-center">
                    <a class="small" href="#">Create an Account!</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
