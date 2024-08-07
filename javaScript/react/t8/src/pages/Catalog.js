import React, { useState } from 'react';
import ProductList from '../components/ProductList';
import SortOptions from '../components/SortOptions';
import productsData from '../data/products';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Section3 from '../components/section3';
import Section4 from '../components/section4';

function Catalog ({ addToCart }) {
    const [sizeFilter, setSizeFilter] = useState('');

    const filteredProducts = productsData.filter(
        (product) => sizeFilter === '' || product.size === sizeFilter
    );

    return (
        <div className='ctn'>
            <Header />
            <SortOptions setSizeFilter={setSizeFilter} />
            <ProductList products={filteredProducts} addToCart={addToCart} />
            <Section3/>
            <Section4/>
            <Footer />
        </div>

    );
};

export default Catalog;