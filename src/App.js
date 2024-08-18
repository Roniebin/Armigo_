import logo from './logo.svg';
import './App.css';
import {Button, Navbar, Container, Nav} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import data from './data';
import { useState } from 'react';

function App() {

  let [items,setItems]= useState(data)

  return (
    <div className="App">
       <Navbar style={{position:"sticky",top:0}}bg="dark" variant="dark">
        <Container>
        <Navbar.Brand href="#home">Armigo</Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link href="#home">Home</Nav.Link>
        </Nav>
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


        <div className="shop-lists">
            {
              items.map(function(item,i){
                return(
                  <Item item={item} i={i}></Item>
                )
              })
            }
        </div>
      </div>
    </div>
  );
}

function Item(props){
  return (
            <div className="shop-item">
                <div className="shop-item-image">
                <img src="http://via.placeholder.com/298x180" alt=""></img>
                </div>
                <div className="shop-item-info">
                    <p>{props.item.name}</p>
                    <span>{props.item.description}</span>
                    <br></br>  <br></br>
                    <p>{props.item.price}</p>
                </div>
            </div>
  )

}

export default App;
