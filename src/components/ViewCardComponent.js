import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import cardInstance from "../services/CardService";

function ViewCardComponent() {
  const [cards, setCards] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    getCards();
  }, []);

  const getCards = () => {
    cardInstance.getCards().then((response) => {
      setCards(response.data);
      console.log(response.data);
    });
  };

  return (
    <div className="container">
      <h1 className="text-center">Card List</h1>
      <div>
        <Link to="/addCard">
          <button type="button" className="btn btn-primary">
            Add Card
          </button>
        </Link>
      </div>
      <div>
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Pokemon Species</th>
              <th>Power Type</th>
              <th>Bought From</th>
              <th>Shop Name</th>
              <th>Buying Cost</th>
              <th>TCG Pricing</th>
              <th>Quantity onhand</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {cards.map((card, index) => (
              <tr key={index}>
                <td>{card.speciesName}</td>
                <td>{card.powerType}</td>
                <td>{card.boughtFrom}</td>
                <td>{card.shopName}</td>
                <td>{card.buyingCost}</td>
                <td>{card.highPrice}</td>
                <td>{card.quantity}</td>
                <td>
                  <button
                    onClick={() => {
                      navigate("/updateCard", { state: card });
                    }}
                  >
                    Update
                  </button>
                  {/* <Link className="btn btn-info" to={`/update`}>
                    Update
                  </Link> */}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewCardComponent;

//For search without Bootstrap => youtube "make a search bar with react(with API Calls) Beginners Tutorial : 16:50"
