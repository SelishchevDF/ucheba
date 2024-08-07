import React from 'react';
import CartItem from '../components/CartItem';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Section4 from '../components/section4';

function CartPage({ cartItems, updateQuantity, removeFromCart }) {
    const total = cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);

    return (
        <div className='ctn'>
            <Header />
            <h2>Shopping Cart</h2>
            <div className='cart'>
                {cartItems.length === 0 ? (
                    <p>Your cart is empty</p>
                ) : (
                    cartItems.map((item) => (
                        <CartItem key={item.id} item={item} updateQuantity={updateQuantity} removeFromCart={removeFromCart} />
                    ))
                )}
            </div>
            <h3>GRAND TOTAL: ${total}</h3>
            <Section4 />
            <Footer />
        </div>
    );
};

export default CartPage;