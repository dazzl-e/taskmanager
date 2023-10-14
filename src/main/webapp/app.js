const taskInput = document.querySelector(".task-input");
const taskButton = document.querySelector(".task-button");
const tasklist = document.querySelector(".task-list");

taskButton.addEventListener("click", addTask);

tasklist.addEventListener('click', remove);

function addTask(event)
{
	
	event.preventDefault();
	
	if(taskInput.value != null && taskInput.value != "")
	{
		const taskDiv = document.createElement('div');
		taskDiv.classList.add("task");
		
		
		const newTask = document.createElement('li');
		newTask.innerText = taskInput.value;
		newTask.classList.add("task-item");
		taskDiv.appendChild(newTask);
		
		
		const deletebutton = document.createElement('button');
		deletebutton.innerHTML = '<i class="fas fa-trash"></i>'
		deletebutton.classList.add("delete-btn");
		taskDiv.append(deletebutton);
		
		tasklist.appendChild(taskDiv);
		
		
		
		var http = new XMLHttpRequest();
		
		
    	
    	
    	http.open("POST", "http://ec2-3-145-37-167.us-east-2.compute.amazonaws.com:8080/taskmanager/newTask.jsp", true);
    	
    	http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    	var params = "addTask=" + taskInput.value; 
    	http.send(params);
    	http.onload = function() 
		{
        	alert(http.responseText);
    	}

		taskInput.value = "";
		
	}
	
	
}

function remove(e)
{
	const task = e.target;
	
	if(task.classList[0] === "delete-btn")
	{
		const taskList = task.parentElement;
		
		taskList.classList.add("fall");
		
		taskList.addEventListener("transitionend", function(){
			var http = new XMLHttpRequest();
			
	    	http.open("POST", "http://ec2-3-145-37-167.us-east-2.compute.amazonaws.com:8080/taskmanager/deleteTask.jsp", true);
	    	
	    	http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    	var params = "taskToDelete=" + task.previousElementSibling.innerText; 
	    	http.send(params);
	    	http.onload = function() 
			{
	        	alert(http.responseText);
	    	}
			taskList.remove();
		});
		

	}
}