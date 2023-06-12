<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 절대경로 : pageContext.request.contextPath -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    
 <style>
   .bd-placeholder-img {
     font-size: 1.125rem;
     text-anchor: middle;
     -webkit-user-select: none;
     -moz-user-select: none;
     user-select: none;
   }

   @media (min-width: 768px) {
     .bd-placeholder-img-lg {
       font-size: 3.5rem;
     }
   }

   .b-example-divider {
     width: 100%;
     height: 3rem;
     background-color: rgba(0, 0, 0, .1);
     border: solid rgba(0, 0, 0, .15);
     border-width: 1px 0;
     box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
   }

   .b-example-vr {
     flex-shrink: 0;
     width: 1.5rem;
     height: 100vh;
   }

   .bi {
     vertical-align: -.125em;
     fill: currentColor;
   }

   .nav-scroller {
     position: relative;
     z-index: 2;
     height: 2.75rem;
     overflow-y: hidden;
   }

   .nav-scroller .nav {
     display: flex;
     flex-wrap: nowrap;
     padding-bottom: 1rem;
     margin-top: -1px;
     overflow-x: auto;
     text-align: center;
     white-space: nowrap;
     -webkit-overflow-scrolling: touch;
   }

   .btn-bd-primary {
     --bd-violet-bg: #712cf9;
     --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

     --bs-btn-font-weight: 600;
     --bs-btn-color: var(--bs-white);
     --bs-btn-bg: var(--bd-violet-bg);
     --bs-btn-border-color: var(--bd-violet-bg);
     --bs-btn-hover-color: var(--bs-white);
     --bs-btn-hover-bg: #6528e0;
     --bs-btn-hover-border-color: #6528e0;
     --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
     --bs-btn-active-color: var(--bs-btn-hover-color);
     --bs-btn-active-bg: #5a23c8;
     --bs-btn-active-border-color: #5a23c8;
   }
   .bd-mode-toggle {
     z-index: 1500;
   }
 </style>
 
 <!-- Custom styles for this template -->
 <!-- pageContext : 내장되어 있는 클래스 -->
 <!-- 요청된 페이지 contextPath 호출함. -->
<link href="${pageContext.request.contextPath}/resources/css/headers.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath}" class="nav-link active" aria-current="page">home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/boardList" class="nav-link" aria-current="page">게시판 조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/boardInsert" class="nav-link">게시글 등록</a></li>
      </ul>
    </header>
  </div>
</body>
</html>