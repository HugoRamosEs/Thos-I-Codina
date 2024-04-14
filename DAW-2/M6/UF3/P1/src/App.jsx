// import React, { useState } from 'react';
// import { ProductProvider } from './ProductContext';
// import { FilterProvider } from './FilterContext';
// import { CartProvider } from './CartContext';
import Header from './components/Header/Header';
import MainMenu from './components/MainMenu/MainMenu';
import Content from './components/Content/Content';
import Aside from './components/Aside/Aside';
import Footer from './components/Footer/Footer';
import { ProductProvider } from "./context/ProductContext";
import { FilterProvider } from "./context/FilterContext";
import './App.scss';

function App() {
  return (
    // <ProductProvider>
    //   
    //     <CartProvider>
    //       <div>
    //         <Header/>
    //       </div>
    //     </CartProvider>
    //   </FilterProvider>
    // </ProductProvider>

    <>
      <ProductProvider>
        <FilterProvider>
          <div className='contenedor'>
            <Header></Header>
            <MainMenu></MainMenu>
            <div id='aside'>
              <Aside></Aside>
            </div>
            <div id='main'>
              <h2>UF3. Exercicis Pràctica 1</h2>
              <div id='content'>
                <Content></Content>
              </div>
            </div>
            <Footer></Footer>
          </div>
        </FilterProvider>
      </ProductProvider>
    </>
  );
}

export default App;
