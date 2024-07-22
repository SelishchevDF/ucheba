import React, { useState } from "react";
import {
    TextField,
    Button,
    Card,
    CardContent,
    IconButton,
    Typography,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";


function TodoList() {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState("");

    function handleInputChange(e) {
        setNewTask(e.target.value);
    };

    function handleAddTask() {
        if (newTask.trim() !== "") {
            setTasks([...tasks, newTask]);
            setNewTask("");
        }
    };

    function handleDeleteTask(index) {
        const updatedTasks = tasks.filter((_, i) => i !== index);
        setTasks(updatedTasks);
    };

    return (
        <div>
            <TextField
                variant="standard"
                label="Новая задача"
                value={newTask}
                onChange={handleInputChange}
            />
            <Button variant="contained" onClick={handleAddTask} >
                Добавить
            </Button>
            {tasks.map((task, index) => (
                <Card variant="standard" key={index}>
                    <CardContent>
                        <Typography>{task}</Typography>
                        <IconButton
                            label="Удалить"
                            onClick={() => handleDeleteTask(index)}
                        >
                            <DeleteIcon />
                        </IconButton>
                    </CardContent>
                </Card>
            ))}
        </div>
    );
};

export default TodoList;