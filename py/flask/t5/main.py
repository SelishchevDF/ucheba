import random
from fastapi import FastAPI, Request
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from pydantic import BaseModel


app = FastAPI()
templates = Jinja2Templates(directory='templates')


class User(BaseModel):
    id: int
    name: str
    email: str
    password: str

    
ivanova = User(id=1, name="ivanova", email="123", password="123")
pupkina = User(id=2, name="pupkina", email="312", password="312")
lupkina = User(id=3, name="lupkina", email="qwe", password="qwe")
users = [ivanova, pupkina, lupkina]


@app.get("/users", response_class=HTMLResponse) 
async def get_users(request: Request):
    return templates.TemplateResponse('list_Users.html', {'request': request, 'users': users})


@app.post("/create", response_model=User)
async def add_user(user: User):
    #user.id = random.randint(10_000_000)
    users.append(user)
    return user


@app.put("/update/{user_id}", response_model=User)
async def update_users(user_id: int, user_upd: User):
    for user in users:
        if user.id == user_id:
            user = user_upd
            return user


@app.delete("/delete/{user_id}")
async def delete_users(user_id: int):
    i = 0
    flag = 0
    for user in users:
        if user.id == user_id:
            flag = i
            break
        i += 1
    if flag != 0:
        users.pop(flag)
    return {"message": "удалили"}
