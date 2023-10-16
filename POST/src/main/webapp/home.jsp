<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css" />
</head>
<body>

	Current user: ${sessionScope.username}
	<button class="action-button btn-createPost">Create post</button>

	<div class="post-create-container hidden">
		<div class="post-title">
			<label for="title">Title:</label> <input type="text" id="title"
				name="title" />
		</div>
		<div class="post-content-create">
			<label for="content">Content:</label>
			<textarea id="content" name="content" rows="10" cols="50"></textarea>
		</div>
		<button class="action-button btn-post">Đăng</button>
	</div>

	<div class="post-container">
		<c:forEach var="post" items="${listPost}">

			<div class="post" data-post-id = ${post.post_id}>
				<div class="user-info">
					<img src="user-avatar.jpg" alt="Avatar" class="user-avatar hidden" />
					<span class="user-name">user'uid</span># <span class="user-id"> ${post.uid}</span>
				</div>
				<div class="post-content">
					<p>Title: ${post.title}</p>
					<p>Content: ${post.contentPost}</p>
					<img src="post-image.jpg" alt="Post Image" class="post-image hidden" />
				</div>

				<div class="post-actions">
					<button class="action-button">Like</button>
					<button class="action-button btn-comment">Comment</button>
					<button class="action-button">Share</button>
				</div>
				<div class="comment hidden">
					<div class="comment-list"></div>
					<form class="comment-submit" action="" data-post-username = "${sessionScope.username}">
					${sessionScope.username}
						<input class="comment-input" type="text" /> <input type="submit"
							value="send" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
	<script type="module" src="home.js"></script>
	<script type="module" src="loadCommentHome.js"></script>
</body>
</html>