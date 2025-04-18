async function getToDos() {
  try {
    const response = await fetch('http://localhost:8080/api/v1/todos');
    todos = await response.json();
  } catch (error) {
    console.error('Error:', error);
  }
}

async function addToDo(todo) {
  try {
    const response = await fetch('http://localhost:8080/api/v1/todos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(todo)
    });

    if (!response.ok) {
      throw new Error('Failed to save todo');
    }
  } catch (error) {
    console.error('Error:', error);
  }
}

async function updateToDo(id, completed) {
  try {
    const response = await fetch(`http://localhost:8080/api/v1/todos/${id}?completed=${completed}`, {
      method: 'PUT'
    });

    if (!response.ok) {
      throw new Error('Failed to update todo');
    }
  } catch (error) {
    console.error('Error:', error);
  }
}

async function deleteToDo(id) {
  try {
    const response = await fetch(`http://localhost:8080/api/v1/todos/${id}`, {
      method: 'DELETE'
    });

    if (!response.ok) {
      throw new Error('Failed to delete todo');
    }
  } catch (error) {
    console.error('Error:', error);
  }
}