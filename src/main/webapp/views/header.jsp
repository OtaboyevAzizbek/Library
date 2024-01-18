<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.context.support.ReloadableResourceBundleMessageSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<% Locale lang = (Locale) request.getAttribute("lang");%>
<% ReloadableResourceBundleMessageSource messageSource = (ReloadableResourceBundleMessageSource) request.getAttribute("messageSource"); %>
<head>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/all.css" rel="stylesheet">
    <title>BookStore</title>
</head>
<body>
<%@ include file="navbar.jsp"%>