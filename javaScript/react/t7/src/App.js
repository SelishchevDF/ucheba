import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTasks } from "./redux/tasksSlice";
import React, { useEffect } from "react";

function App() {
  const dispatch = useDispatch();
  const tasks = useSelector((state) => state.tasks.items);
  const taskStatus = useSelector((state) => state.tasks.status);

  useEffect(() => {
    if (taskStatus === 'idle') {
      dispatch(fetchTasks());
    }
  }, [taskStatus, dispatch]);

  return (
    <div className="App">
      {taskStatus === 'loading' && <div>Загрузка</div>}
      {taskStatus === 'succeeded' && (
        <div>
          {tasks.map((task) => (
            <div key={task.id}>
              {task.title}: {task.completed ? 'Выполнено' : 'Не выполнено'}
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default App;
