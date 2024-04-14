import Header from './components/Header/Header';
import MainMenu from './components/MainMenu/MainMenu';
import Content from './components/Content/Content';
import Aside from './components/Aside/Aside';
import Footer from './components/Footer/Footer';
import { ProductProvider } from "./context/ProductContext";
import { FilterProvider } from "./context/FilterContext";
import { CartProvider } from './context/CartContext';
import './App.scss';
import Cart from './components/Cart/Cart';


function App() {
  return (
    <>
      <ProductProvider>
        <FilterProvider>
          <CartProvider>
            <div className='contenedor'>
              <Header></Header>
              <MainMenu></MainMenu>
              <Cart></Cart>
              <div id='aside'>
                <Aside></Aside>
              </div>
              <div id='main'>
                <h2>UF3. Exercicis Pràctica 2</h2>
                <Content></Content>
              </div>
              <Footer></Footer>
            </div>
          </CartProvider>
        </FilterProvider>
      </ProductProvider>
    </>
  );
}

export default App;
