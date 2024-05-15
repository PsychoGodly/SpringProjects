import React, { useState, useEffect } from "react";
import axios from "axios";

function Contacts() {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get("/api/contacts");
      setContacts(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
      <div className="overflow-x-auto">
      <table className="table-auto w-full">
        <thead>
          <tr>
            <th className="px-4 py-2">Name</th>
            <th className="px-4 py-2">Phone</th>
            <th className="px-4 py-2">Email</th>
            <th className="px-4 py-2">Address</th>
          </tr>
        </thead>
        <tbody>
          {contacts.map((contact) => (
            <tr key={contact.id}>
              <td className="border px-4 py-2 text-center">{contact.name}</td>
              <td className="border px-4 py-2 text-center">{contact.phone}</td>
              <td className="border px-4 py-2 text-center">{contact.email}</td>
              <td className="border px-4 py-2 text-center">{contact.address}</td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
  );
}

export default Contacts;
