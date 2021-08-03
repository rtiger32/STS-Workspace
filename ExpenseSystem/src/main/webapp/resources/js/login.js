/**
 * 
 */
let form = document.getElementById("login").addEventListener('submit', login);

async function login(e){
	e.preventDefault();
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	let user = {
		username,
		password
	}
	
	console.log(user);
	
	
	try{
		let req = await fetch('http://localhost:8080/ExpenseSystem/api/index', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		let res = await req.json();
//		
//		if (res.userRole.EMPLOYEE) {
//		location.href = 'resources/html/employee.html';
//		} else if (res.userRole.MANAGER) {
//		location.href = 'resources/html/employee.html';
		
	} catch(e){
		alert('Username or password incorrect!');
		return;
	}
	
	location.href = 'resources/html/employee.html';
}