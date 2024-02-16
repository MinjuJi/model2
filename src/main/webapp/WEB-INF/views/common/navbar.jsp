<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light">
	<div class="container">
		
		<ul class="navbar-nav">
			<li class="nav-item me-auto">
				<a class="nav-link ${menu eq '홈' ? 'active': ''}" href="/model2/home.do">홈</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${menu eq '게시판' ? 'active': ''}" href="/model2/board/list.do">게시판</a>
			</li>
		</ul>
		
		<ul class="navbar-nav ">
			<li class="nav-item">
				<a class="nav-link ${menu eq '로그인' ? 'active': ''}" href="/model2/login.do">로그인</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/logout.do">로그아웃</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${menu eq '회원가입' ? 'active': ''}" href="/model2/register.do">회원가입</a>
			</li>
		</ul>
		
	</div>
</nav>