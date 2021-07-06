import './App.css';
import{ Form,Table ,Dropdown,Button}from 'react-bootstrap';
import { useEffect, useState } from 'react';
import axios from 'axios';


//http://localhost:8080/api/phone
async function axiosTest( url) {
  const axios = require('axios').default;
  const response = await axios.get(url)
  console.log(response)
  return response.data
}


function App() {
  const [country,setCountry]=useState("");
  const [validity,setValidity]=useState("");
  const [phoneData, setPhoneData] = useState([]);

  useEffect(() => {
    (async function callApi(){
      const url = "http://localhost:8080/api/phone"
      setPhoneData(await axiosTest(url));
    })();
  }, []);

  

  const renderPhone = (phone, index) => {
    return (
      <tr>
        <td>{phone.phone}</td>
        <td>{phone.country}</td>
        <td>{phone.countryCode}</td>
        <td>{phone.validityStatus === true ? "true" : "false"}</td>
      </tr>
    )

  }

  const handleSubmit = async() => {
    const url  = `http://localhost:8080/api/phone?country=${country}&valid=${validity}` ; 
    console.log(url)
    setPhoneData(await axiosTest(url));
  }
  return (
    <div >
      <div className ="ms-3">
        <Form>
          <Form.Group controlId="formBasicEmail" className ="mb-3" >
            <Form.Label >filter by country</Form.Label>
            <Form.Control  onChange={(e)=>{setCountry(e.target.value)}}style ={{width:"25%"}} type="input" placeholder="enter country" />
          </Form.Group>
          <Dropdown onSelect={(e)=>{setValidity(e)}}>
            <Dropdown.Toggle variant="success" id="dropdown-basic" className ="mb-3" >
              {validity==""?"ValidityStatus":validity}
            </Dropdown.Toggle>

            <Dropdown.Menu>
            <Dropdown.Item eventKey="" style ={{height:"30px"}} ></Dropdown.Item>
              <Dropdown.Item eventKey="true">true</Dropdown.Item>
              <Dropdown.Item eventKey="false">false</Dropdown.Item>
            </Dropdown.Menu>
            </Dropdown>
            <Button variant="primary" onClick={handleSubmit}>filter</Button>{' '}
        </Form>
      </div>
      <Table style ={{width:"50%"}}>
        <thead>
          <tr>
            <th>phone</th>
            <th>country name</th>
            <th>country code</th>
            <th>valid</th>
          </tr>
        </thead>
        <tbody>
          {phoneData.map(renderPhone)}
        </tbody>
      </Table>
    </div>
  );
}

export default App;