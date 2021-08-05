/**
 * 
 */

/**
* 
*/

// the div to watch to update content
let container = document.getElementById('reqstatus');
window.onload = getPosts();

async function getPosts() {
	let res = await fetch('http://localhost:8080/ExpenseSystem/api/employee');
	let data = await res.json();
	console.log(data);
	populate(data);

}
function populate(data) {
	for (postObj of data) {
		let post = document.createElement('div');
		post.innerHTML = `<p>Date submitted: ${postObj.dateSubmitted}</p>
                      <p>Reimbursement Amount: ${postObj.amount} for ${postObj.type.type}</p>
                      <p>Reason: ${postObj.description}</p>
                      <p>Status: ${postObj.status.status}</p><br>`;
		console.log(postObj);
		container.append(post);
	}
}

let form = document.getElementById("makeRequest").addEventListener('submit', newReq)

async function newReq(e) {
	e.preventDefault();
	let amount = document.getElementById("amount").value;
	let type = document.getElementById("type").value;
	let description = document.getElementById("description").value;

	let out = {
		amount,
		type,
		description
	}

	console.log(out);


	try {
		let req = await fetch('http://localhost:8080/ExpenseSystem/api/employee', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(out)
		});
		let res = await req.text();
		console.log(res);
	} catch (e) {
	console.log (e.stack);
		alert('Something went Wrong');
		return;
	}
		function logout() {
			location.href = '/ExpenseSystem/index';
		}


}
