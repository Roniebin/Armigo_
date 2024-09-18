import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route, Link, Outlet } from "react-router-dom";
import axios from 'axios';
import CryptoJS from 'crypto-js';
function LoginForm(props) {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();
    let [signup,setSignup]=useState(0)

    const handleSubmit = (e) => {
        e.preventDefault();

        axios.post('http://ec2-3-39-119-168.ap-northeast-2.compute.amazonaws.com:8080/member/login', {
            name: name,
            password: password,
            
        }).then(res => {
            console.log(res)
        
            // 로그인 로직 처리 (예: API 호출)
            if (name === res.data.id && password === res.data.password) {
                // 성공적으로 로그인하면 리다이렉트
                alert("성공")
                props.setUser(name);
                props.setLogin(true)
                navigate('/');
            } else {
                // 로그인 실패 시 에러 메시지 설정  
                setError('Invalid email or password');
                }

           
        })
        .catch(err => {
            console.error(err);
            alert("로그인 실패");
        });
     
        
    };

    return (

        <Container style={{marginTop:"10%"}}>
            <Row className="justify-content-md-center">
                <Col xs={12} md={6}>
                    <h2 className="mt-5">Login</h2>
                    {error && <Alert variant="danger">{error}</Alert>}
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formBasicEmail" className="mb-3">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control 
                       
                                placeholder="Enter email" 
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                required 
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword" className="mb-3">
                            <Form.Label>Password</Form.Label>
                            <Form.Control 
                                type="password" 
                                placeholder="Password" 
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required 
                            />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Login
                        </Button>
                        <Link
                            to="/signup"
                            className="signup-btn"
                        > 
                            Sign up
                        </Link>
                    </Form>
                    
                </Col>
            </Row>
        </Container>
    );
}

export default LoginForm;
