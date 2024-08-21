import logo from "./logo.svg";
import "./App.css";
import { Button, Navbar, Container, Nav } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import data from "./data";
import { useEffect, useState } from "react";
import Detail from "./detail";
import Items from "./Items";
import Fitting from "./fitting";
function App() {
  let [items] = useState(data); // 옷 오브젝트 데이터들
  let [location, setLocation] = useState(0); // 메인페이지, 상세페이지, 가상피팅페이지 구별하기위함
  let [id, setId] = useState(0); // 클릭한 옷의 제품번호
  let [fade,setFade]=useState('start')

  useEffect(()=>{
    setTimeout(() => {
      setFade('end')
    }, 50);
  })

  

  return (
    <div className="App">
      <Navbar style={{ position: "sticky", top: 0 }} bg="dark" variant="dark">
        <Container>
          <Navbar.Brand
            href="/"
            onClick={() => {
              setLocation(0);
            }}
          >
            Armigo
          </Navbar.Brand>
          <input
            type="text"
            className="searching-bar"
            placeholder="Search.."
          ></input>
        </Container>
      </Navbar>

      <div className="shop-main">
        <div className="shop-options">
          <div className="shop-options-stickybox">
            <div className="shop-category">
              <p style={{ fontSize: "16px", fontWeight: "bold" }}>카테고리</p>
              <span className="options">상의</span>
              <span className="options">하의</span>
              <span className="options">뷰티</span>
            </div>

            <hr style={{ marginLeft: "20%", marginTop: "20px" }}></hr>
            <div className="shop-filter">
              <p style={{ fontSize: "16px", fontWeight: "bold" }}>필터</p>
              <span className="options">가격</span>
              <span className="options">사이즈</span>
              <span className="options">색상</span>
            </div>
          </div>
        </div>
        {
          <div className={"shop-lists " + fade}>
            {/* 모든 옷들 리스트출력 */}
            {location == 0 ? (
              items.map(function (item, i) {
                return (
                  <Items
                    key={i}
                    item={item}
                    setLocation={setLocation}
                    location={location}
                    id={id}
                    setId={setId}
                    setFade={setFade}
                  />
                );
              })
            ) : location == 1 ? (
              //상세페이지
              <Detail
                item={items[id]}
                id={id}
                location={location}
                setId={setId}
                setLocation={setLocation}
                setFade={setFade}
              />
            ) : (
              
              <Fitting/>
            )}
          </div>
        }
      </div>
    </div>
  );
}

export default App;
