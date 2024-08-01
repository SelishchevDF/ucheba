import { useSelector, useDispatch } from 'react-redux';
import { removeProduct, toggleAvailability } from '../redux/productsSlice';

const ProductList = () => {
  const products = useSelector((state) => state.products.products);
  const dispatch = useDispatch();

  return (
    <div>
      {products.map((product) => (
        <div key={product.id}>
          <div>{product.name}</div>
          <div>{product.description}</div>
          <div>Цена {product.price}</div>
          <div>Доступность {product.available ? 'ДА' : 'НЕТ'}</div>
          <button onClick={() => dispatch(removeProduct(product.id))}>Удалить</button>
          <button onClick={() => dispatch(toggleAvailability(product.id))}>Сменить доступность</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;