import React from 'react';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Section from '../components/section';
import Section2 from '../components/section2';
import Section3 from '../components/section3';
import Section4 from '../components/section4';
import productsData from '../data/products';
import ProductListSmall from '../components/ProductListSmall';
import { Link } from 'react-router-dom';

function Home({ addToCart }) {
    return (
        <div className='ctn'>
            <Header />
            <Section />
            <Section2 />
            <main>
            <ProductListSmall products={productsData} addToCart={addToCart} /> 
            <Link to="/catalog">Browse All Product</Link>
            </main>
            <Section3 />
            <Section4 />
            <Footer />
        </div>
    );
};

export default Home;