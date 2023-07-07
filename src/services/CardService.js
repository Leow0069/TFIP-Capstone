import axios from "axios";

const CARDS_REST_API_URL = "http://localhost:8080/api/allCards";
const ADDCARD_REST_API_URL = "http://localhost:8080/api/addCard";
const UPDATECARD_REST_API_URL = `http://localhost:8080/api/updateCard`;

class CardService {
  getCards() {
    return axios.get(CARDS_REST_API_URL);
  }
  addCards(details) {
    return axios.post(ADDCARD_REST_API_URL, details);
  }
  updateCard(details) {
    return axios.get(UPDATECARD_REST_API_URL, details);
  }
}

const cardInstance = new CardService();
export default cardInstance;
