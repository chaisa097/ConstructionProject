<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 
 <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
 <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
 <script  type="text/javascript" src="js/util/BeanUtils.js"></script>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>
      <link rel="stylesheet" href="css/style.css">
       <link rel="stylesheet" href="css/base/login.css">
        <title></title>
    </head>
    <body>
    	<c:if test="${not empty error}">
			<div class="error" style="visibility:hidden;" >${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg" style="visibility:hidden;">${msg}</div>
		</c:if>
 		<c:url value="/index.html" var="loginUrl" />
<div class="cont">
  <div class="demo">
    <div class="login">
      <form   action="http://${ipDomainSystem}${loginUrl}" method="post">
      <!--  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->   
        
      <h3 class="form-signin-heading" action="${loginUrl}" method="post">Please sign in</h3>  
      <hr class="colorgraph"><br>   
      <img class="img-responsive img-circle center-block" width="150" height="50" src="images/iConCON.png">
        
      
              <div class="login__form">
     <div class="login__row">
        <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
        <input id="username" name="username" style="color:white;" class="login__input pass" type="text" required="" placeholder="Username">
      </div>
      
      <div class="login__row">
         <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
        <input id="password" name="password"  style="color:white;" class="login__input pass" type="password" required="" placeholder="Password">
      
      <h5 style="color:white;" class="showmsg">${error}</h5>
      <button class="login__submit" id="loginButton" type="submit">Sign in</button>
      </div>
      </div>
    </form>
    </div>
    
  </div>
</div>

    </body>
    
</html>

<script>
	if(BeanUtils.isNotEmpty($('div.error').html())){
		$('h5.showmsg').html($('div.error').html())
	}else{
		$('h5.showmsg').html($('div.msg').html())
	}

</script>