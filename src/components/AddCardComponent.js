import React, { useState } from "react";
import cardInstance from "../services/CardService";
import { useNavigate } from "react-router-dom";

const AddCardComponent = () => {
  const [speciesName, setSpeciesName] = useState("");
  const [powerType, setPowerType] = useState("");
  const [boughtFrom, setBoughtFrom] = useState("");
  const [shopName, setShopName] = useState("");
  const [buyingCost, setBuyingCost] = useState("");
  const [highPrice, setHighPrice] = useState("");
  const [quantity, setQuantity] = useState("");
  const navigate = useNavigate();

  const saveDetails = (e) => {
    e.preventDefault();

    const details = {
      speciesName,
      powerType,
      boughtFrom,
      shopName,
      buyingCost,
      highPrice,
      quantity,
    };
    console.log(details);

    cardInstance
      .addCards(details)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });

    navigate("/allCards"); //navigate to main page. validate no data input, click cancel then can go back to main page
  };
  return (
    <div className="container">
      <div className="card col-md-6 offset-md-3 offset-md-3">
        <h2 className="text-center">Add Card</h2>
        <div className="card-body">
          <form>
            <div className="form-group mb-2">
              <label className="form-label">Pokemon Species</label>
              <input
                type="text"
                name="speciesName"
                placeholder="eg. Mew"
                className="form-control"
                value={speciesName}
                onChange={(e) => setSpeciesName(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">Power Type</label>
              <input
                type="text"
                name="powerType"
                placeholder="eg. EX, GX"
                className="form-control"
                value={powerType}
                onChange={(e) => setPowerType(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">Bought From</label>
              <input
                type="text"
                name="boughtFrom"
                placeholder="eg. eBay"
                className="form-control"
                value={boughtFrom}
                onChange={(e) => setBoughtFrom(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">Shop Name</label>
              <input
                type="text"
                name="shopName"
                placeholder="eg. Tokyo1"
                className="form-control"
                value={shopName}
                onChange={(e) => setShopName(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">Buying Cost</label>
              <input
                type="text"
                name="buyingCost"
                placeholder="eg. 100.00"
                className="form-control"
                value={buyingCost}
                onChange={(e) => setBuyingCost(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">TCG Pricing</label>
              {/* // this one needs to be same as all Mew V isnt it? */}
              <input
                type="text"
                name="highPrice"
                placeholder="eg. 200.00"
                className="form-control"
                value={highPrice}
                onChange={(e) => setHighPrice(e.target.value)}
              ></input>
            </div>

            <div className="form-group mb-2">
              <label className="form-label">Quantity onhand</label>
              <input
                type="number"
                name="quantity"
                placeholder="eg. 2"
                className="form-control"
                value={quantity}
                onChange={(e) => setQuantity(e.target.value)}
              ></input>
            </div>

            <div>
              <button
                type="button"
                className="btn btn-primary"
                onClick={(e) => saveDetails(e)}
              >
                Submit
              </button>

              <button
                type="button"
                className="btn btn-light"
                onClick={() => navigate("/allCards")}
              >
                Cancel
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddCardComponent;
