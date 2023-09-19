from datetime import datetime
from fastapi import APIRouter
from random import randint
from db import users, database, products, orders
from models import User, UserIn, Order, OrderIn, Product, ProductIn

router = APIRouter()


@router.get("/")
def root():
    return {"Message": "Hello"}


@router.get("/users", response_model=list[User])
async def get_users():
    query = users.select()
    return await database.fetch_all(query)


@router.post("/users", response_model=User)
async def create_user(user: UserIn):
    query = users.insert().values(
        name=user.name,
        surname=user.surname,
        email=user.email,
        password=user.password
    )
    last_record_id = await database.execute(query)
    return {**user.dict(), "id": last_record_id}


@router.get("/users/{user_id}", response_model=User)
async def read_user(user_id: int):
    query = users.select().where(users.c.id == user_id)
    return await database.fetch_one(query)


@router.put("/users/{user_id}", response_model=User)
async def update_user(user_id: int, new_user: UserIn):
    query = users.update().where(users.c.id ==
                                 user_id).values(**new_user.dict())
    await database.execute(query)
    return {**new_user.dict(), "id": user_id}


@router.delete("/users/{user_id}")
async def delete_user(user_id: int):
    query = users.delete().where(users.c.id == user_id)
    await database.execute(query)
    return {'message': 'User deleted'}

#query = notes.select(Order.id, Order.dt, Tovar.id, Tovar.name).select_from(Order).join(Tovar, Order.id == Tovar.order_id)

@router.get("/products", response_model=list[Product])
async def get_products():
    query = products.select()
    return await database.fetch_all(query)


@router.post("/products", response_model=Product)
async def create_product(prd: ProductIn):
    query = products.insert().values(
        title = prd.title,
        description = prd.description,
        price = randint(1, 100)
    )
    last_record_id = await database.execute(query)
    return {**prd.dict(), "id": last_record_id}


@router.get("/products/{product_id}", response_model=Product)
async def read_product(product_id: int):
    query = products.select().where(products.c.id == product_id)
    return await database.fetch_one(query)


@router.put("/products/{product_id}", response_model=Product)
async def update_product(product_id: int, new_product: ProductIn):
    query = products.update().where(products.c.id ==
                                 product_id).values(**new_product.dict())
    await database.execute(query)
    return {**new_product.dict(), "id": product_id}


@router.delete("/products/{product_id}")
async def delete_product(product_id: int):
    query = products.delete().where(products.c.id == product_id)
    await database.execute(query)
    return {'message': 'product deleted'}

#----------------------------------------------------------------

@router.get("/orders", response_model=list[Order])
async def get_orders():
    query = orders.select()
    return await database.fetch_all(query)


@router.post("/orders", response_model=Order)
async def create_order(order: OrderIn):
    query = orders.insert().values(
            user_id = order.user_id,
            prod_id = order.prod_id,
            date = datetime.now(),
            status = 'created'        
    )
    last_record_id = await database.execute(query)
    return {**order.dict(), "id": last_record_id}


@router.get("/orders/{order_id}", response_model=Order)
async def read_order(order_id: int):
    query = orders.select().where(orders.c.id == order_id)
    return await database.fetch_one(query)


@router.put("/orders/{order_id}", response_model=Order)
async def update_order(order_id: int, new_order: OrderIn):
    query = orders.update().where(orders.c.id ==
                                 order_id).values(**new_order.dict())
    await database.execute(query)
    return {**new_order.dict(), "id": order_id}


@router.delete("/orders/{order_id}")
async def delete_order(order_id: int):
    query = orders.delete().where(orders.c.id == order_id)
    await database.execute(query)
    return {'message': 'order deleted'}