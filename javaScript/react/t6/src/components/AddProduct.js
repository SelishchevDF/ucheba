import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addProduct } from '../redux/productsSlice';
import {v4 as uuidv4} from 'uuid';

const AddProduct = () => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const [available, setAvailable] = useState(true);
  const dispatch = useDispatch();

  const handleSubmit = (e) => {
    e.preventDefault();
    const newProduct = {
      id: uuidv4(),
      name,
      description,
      price: parseFloat(price),
      available,
    };

    dispatch(addProduct(newProduct));
    setName('');
    setDescription('');
    setPrice('');
    setAvailable(true);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Название"
        value={name}
        onChange={(e) => setName(e.target.value)}
        required
      />

      <input
        type="text"
        placeholder="Описание"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        required
      />

      <input
        type="number"
        placeholder="Цена"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
        required
      />

      <button type="submit">Добавить</button>
    </form>
  );
};

export default AddProduct;