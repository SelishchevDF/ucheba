import React from 'react';
import { Link } from 'react-router-dom';
import header from "../img/header.png";

function Header() {
    return (
        <header>
            <Link to="/cart"><img src={header} /></Link>
            <div className="nav">
                <Link to="/">Home</Link>
                <Link to="/catalog">Catalog</Link>
                <Link to="/cart">Cart</Link>
            </div>
        </header>
    );
};

export default Header;