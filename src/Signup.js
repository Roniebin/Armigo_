import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Select from 'react-select';
import axios from 'axios';


function Signup() {
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [type, setType] = useState(null); // 기본값을 null로 설정
    const [city, setCity] = useState('');
    const [street, setStreet] = useState('');
    const [zipcode, setZipcode] = useState('');
    const [error, setError] = useState('');

    const options = [
        { value: 'BUYER', label: 'BUYER' },
        { value: 'SELLER', label: 'SELLER' }
    ];

    const navigate = useNavigate();

    const handleTypeChange = (selectedOption) => {
        setType(selectedOption);
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        
        console.log(JSON.stringify({
            name: name,
            password: password,
            type: type.value, // use type.value to send the selected type
            city: city,
            street: street,
            zipcode: zipcode
        }),)
        if (!type) {
            setError("Type is required");
            return;
        }
    
        fetch('http://ec2-3-39-119-168.ap-northeast-2.compute.amazonaws.com:8080/member/join', {
            method: 'POST', 
            mode: 'cors', 
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: name,
                password: password,
                type: type.value, // use type.value to send the selected type
                city: city,
                street: street,
                zipcode: zipcode
            }),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log(JSON.stringify(data));
            alert("Sign up successful!");
            navigate('/'); // Replace '/somepath' with the actual path you want to navigate to
        })
        .catch((error) => {
            console.error('Error:', error);
            setError(`Sign up failed: ${error.message}`);
        });
    
        // axios.post('http://ec2-43-203-172-221.ap-northeast-2.compute.amazonaws.com:8080/member/join', {
            // name : {name},
            // password : {password},
            // type: {type}, // type의 value를 전송
            // city : {city},
            // street : {street},
            // zipcode : {zipcode}
        // })
        // .then(res => {
        //     console.log(res);
        //     alert("회원가입 완료");
        //     navigate('/somepath'); // 회원가입 성공 후 이동할 경로 설정
        // })
        // .catch(err => {
        //     console.error(err);
        //     alert("회원가입 실패");
        // });
    };

    return (
        <Container style={{ marginTop: "10%" }}>
            <Row className="justify-content-md-center">
                <Col xs={12} md={6}>
                    <h2 className="mt-5">Sign up</h2><br></br>
                    {error && <Alert variant="danger">{error}</Alert>}
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formBasicName" className="mb-3">
                            <Form.Label>Name</Form.Label>
                            <Form.Control 
                                placeholder="Enter Name" 
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

                        <Form.Group controlId="formBasicCity" className="mb-3">
                            <Form.Label>City</Form.Label>
                            <Form.Control 
                                placeholder="City" 
                                value={city}
                                onChange={(e) => setCity(e.target.value)}
                                required 
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicStreet" className="mb-3">
                            <Form.Label>Street</Form.Label>
                            <Form.Control 
                                placeholder="Street" 
                                value={street}
                                onChange={(e) => setStreet(e.target.value)}
                                required 
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicZipcode" className="mb-3">
                            <Form.Label>Zipcode</Form.Label>
                            <Form.Control 
                                placeholder="Zipcode" 
                                value={zipcode}
                                onChange={(e) => setZipcode(e.target.value)}
                                required 
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicType" className="mb-3">
                            <Form.Label>Type</Form.Label>
                            <Select 
                                options={options}
                                value={type}
                                onChange={handleTypeChange}
                                placeholder="Select Type"
                                required
                            />
                        </Form.Group>

                        <br></br>
                        <Button variant="primary" type="submit">
                            Sign up
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}

export default Signup;
