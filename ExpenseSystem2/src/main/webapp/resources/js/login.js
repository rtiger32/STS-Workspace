/**
 * 
 */
let form = document.getElementById("login").addEventListener('submit', login);

async function login(e){
	e.preventDefault();
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let role = document.getElementById("role").value;
	
	let user = {
		username,
		password,
		role
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
	} catch(e){
		alert('Username or password incorrect!');
		return;
	}
	
	if (role == MANAGER)
	location.href = 'resources/html/manager.html';
	else
	location.href = 'resources/html/employee.html';
}