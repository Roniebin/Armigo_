import logo from './logo.svg';
import './App.css';
import {Button, Navbar, Container, Nav} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import data from './data';
import { useState } from 'react';
import Detail from './detail';
import Items from './Items';
function App() {

  let [items]= useState(data)
  let [location,setLocation]=useState(0);
  let [id,setId]=useState(0);

  return (
    <div className="App">
       <Navbar style={{position:"sticky",top:0}}bg="dark" variant="dark">
        <Container>
        <Navbar.Brand href="/" onClick={()=>{setLocation(0)}}>Armigo</Navbar.Brand>
        <input type="text" className="searching-bar" placeholder="Search.."></input>
        </Container>
      </Navbar>

      <div className="shop-main">
        <div className="shop-options">
          <div className="shop-options-stickybox">
            <div className="shop-category">
              
              <p style={{fontSize:"16px",fontWeight:"bold"}}>카테고리</p>
              <span className="options">상의</span>
              <span className="options">하의</span>
              <span className="options">뷰티</span>
            </div>

            <hr style={{marginLeft:"20%",marginTop:"20px"}}></hr>
            <div className="shop-filter">
              <p style={{fontSize:"16px",fontWeight:"bold"}}>필터</p>
              <span className="options">가격</span>
              <span className="options">사이즈</span>
              <span className="options">색상</span>
            </div>
          </div>
          
        </div>
        {
   <div className="shop-lists">
    
    {
      location== 0 ?
      items.map(function(item, i) {
        return (
          <Items 
            key={i} 
            item={item}  
            setLocation={setLocation}
            location={location}
            setId={setId}
          />
        );
      }):  location== 1 ?
    
       <Detail item={items[id]}/>
      : null
    }
  </div> 
}
      </div>
    </div>
  );
}


export default App;
