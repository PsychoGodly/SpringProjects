import React, { useState, useEffect } from "react";
import User from "./components/Contacts";
import AddUser from "./components/Add_Contact";
import Contacts from "./components/Contacts";


function App() {
  

  return (
    <div className="App">
      <h1 className="text-xl">Data from Backend</h1>
      <AddUser />
      <br /><br /><br />
      <Contacts />
    </div>
  );
}

export default App;
