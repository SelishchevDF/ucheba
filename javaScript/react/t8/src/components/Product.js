import React from 'react';

function Product({ product, addToCart }) {
    return (
        <div className="product">
            <img src={require('../images/' + product.image)} alt={product.name} />
            <h3>{product.name}</h3>
            <p>Size: {product.size}</p>
            <p>Price: ${product.price}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
        </div>
    );
};

export default Product;