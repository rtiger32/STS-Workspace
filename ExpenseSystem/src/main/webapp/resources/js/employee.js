/**
 * 
 */
 
 /**
 * 
 */
 
 // the div to watch to update content
 let container = document.getElementById('reqstatus');

async function getPosts(){
	let res = await fetch('http://localhost:8080/ExpenseSystem/api/employee');
	let data = await res.json();
	populate(data);
}
function populate(data){
	for (postObj of data) {
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.username}</h2>
                      <p>${postObj.content}</p>`;
        console.log(postObj);
        container.append(post);
    }
}

let form = document.getElementById("makeRequest").addEventListener('submit', newReq)

async function newReq(e){
	e.preventDefault();
	let amount = document.getElementById("amount").value;
	let reason = document.getElementById("reason").value;
	
	let out = {
		amount,
		reason
	}
	
	console.log(out);
	
	
	try{
		let req = await fetch('http://localhost:8080/ExpenseSystem/api/employee', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		let res = await req.json();

	} catch(e){
		alert('Something went Wrong');
		return;
	}
}
