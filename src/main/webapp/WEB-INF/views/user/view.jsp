<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h2>View Profile</h2>
	<div> Name:</div>
	<div> ${user.name}  </div>
	<div> Email: </div>
	<div> ${user.email}</div>

	<a href="users/${user.name}/edit">Edit Profile</a>
</div>
