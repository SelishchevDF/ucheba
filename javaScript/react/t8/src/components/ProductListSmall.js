import React from 'react';
import Product from './Product';

function ProductListSmall({ products, addToCart }) {

    const LENGTHOFARRAY = 6;

    function shuffleArray(array) {
        let i = array.length - 1;

        for (; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            const temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array.slice(0, LENGTHOFARRAY);
    }

    return (
        <div className="product-list-small">
            {shuffleArray(products).map((product) => (
                <Product key={product.id} product={product} addToCart={addToCart} />
            ))}
        </div>
    )
}

export default ProductListSmall;