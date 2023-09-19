from datetime import datetime
from pydantic import BaseModel, Field


class UserIn(BaseModel):
    name: str = Field()
    surname: str = Field()
    email: str = Field()
    password: str = Field()


class User(BaseModel):
    id: int
    name: str = Field()
    surname: str = Field()
    email: str = Field()
    password: str = Field()


class ProductIn(BaseModel):
    title: str = Field()
    description: str = Field()
    price: int = Field(default=0)


class Product(BaseModel):
    id: int
    title: str = Field()
    description: str = Field()
    price: int = Field(default=0)


class OrderIn(BaseModel):
    user_id: int
    prod_id: int
    date: datetime
    status: str


class Order(BaseModel):
    id: int
    user_id: int
    prod_id: int
    date: str
    status: str = Field(default="created")