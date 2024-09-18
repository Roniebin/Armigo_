import logo from "./logo.svg";
import "./App.css";
import { Button, Navbar, Container, Nav } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import data from "./data";
import { useEffect, useState } from "react";
import Detail from "./detail";
import Items from "./Items";
import Fitting from "./fitting";
import axios from "axios";
import LoginForm from "./LoginForm";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import Signup from "./Signup";

function App() {
  let [items, setItem] = useState(data); // 옷 오브젝트 데이터들
  let [location, setLocation] = useState(0); // 메인페이지, 상세페이지, 가상피팅페이지 구별하기위함
  let [id, setId] = useState(0); // 클릭한 옷의 제품번호
  let [fade, setFade] = useState("start");
  let [hide, setHide] = useState("");

  let [isLogin, setLogin] = useState(false);
  let [user, setUser] = useState("");

  let navigate = useNavigate();

  // useEffect(() => {
  //   axios
  //     .get("/join")
  //     .then((result) => {
  //       console.log(result.data);

  //       // 가져온 데이터 바인딩
  //       setItem(result);
  //     })
  //     .catch(() => {});
  // });

  useEffect(() => {
    setTimeout(() => {
      setFade("end");
    }, 50);
  });

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

          <Link to="/creating-dress" style={{textDecoration:"none",color:"white"}} onClick={()=>{setFade("start")}}>드레스 제작</Link>

          {isLogin == false ? (
            <Link
              to="/login"
              className="login-btn"
              onClick={() => {
                setHide("hide");
              }}
            >
              login
            </Link>
          ) : (
            <span>{user} 님 </span>
          )}
        </Container>
      </Navbar>

      <Routes>
        <Route
          path="/login"
          element={<LoginForm setLogin={setLogin} setUser={setUser} />}
        />
        <Route path="/signup" element={<Signup />} />
        <Route
          path="/"
          element={
            <div className={hide}>
              <div className="shop-main">
                <Category />
                {
                  <div className={"shop-lists " + fade}>
                    {/* 모든 옷들 리스트출력 */}
                    {items.map(function (item, i) {
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
                    })}
                  </div>
                }
              </div>
            </div>
          }
        />
        <Route
          path={`/detail/` + id}
          element={
            <div className={hide}>
              <div className="shop-main">
                <Category />

                <Detail
                  item={items[id]}
                  id={id}
                  location={location}
                  setId={setId}
                  setLocation={setLocation}
                  setFade={setFade}
                />
              </div>
            </div>
          }
        />
        <Route
          path={`/detail/${id}/virtual-fitting`}
          element={
            <div className={hide}>
              <div className="shop-main">
                <Category />
                <Fitting />
              </div>
            </div>
          }
        />
        ``````
        <Route
          path="/creating-dress"
          element={
          
              <div className={"creatingDress "+fade}>
                 <h3>당신만의 완벽한 웨딩 드레스를 만들어보세요</h3>
                 
                 <div className="creatingDress-container">
                    <div className="creatingDress-setting component">
                        <p style={{marginLeft:"0px"}}>웨딩 드레스 설명</p>
                        <span style={{color:"gray",marginLeft:"0px"}}>원하는 웨딩 드레스의 특징을 자세히 적어주세요</span>
                        <br></br>
                        <input type="text" className="propmt" placeholder="예: 긴 소매와 레이스 데티일이 있는 우아한 스타일 드레스"></input>
                        <p>복잡도</p>
                        <input id="slider" type="range" min="0" max="100" list="tickmarks"/>
                        
                        <button class="createBtn">드레스 생성하기</button>
                    </div>
                    <div className="creatingDress-picture component">
                        <h4>생성된 웨딩 드레스</h4>
                        <img src="pic0.jpg" alt=""></img>
                        <button className="picBtn">저장</button>
                        <button className="picBtn">바로 사용</button>
                    </div>
                 </div>
              </div>
        
          }
        ></Route>
        ``````
      </Routes>
    </div>
  );
}

//상세페이지

function Category() {
  return (
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
  );
}
export default App;
