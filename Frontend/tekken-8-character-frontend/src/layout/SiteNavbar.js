import React from 'react'
import { Container } from 'react-bootstrap';
import {Link} from "react-router-dom";
import { Navbar } from 'react-bootstrap';
import { Nav } from 'react-bootstrap';

export default function SiteNavbar() {
  return (
    <div>
        <Navbar bg="dark" data-bs-theme="dark">
          <Navbar.Brand href="/">
            Character Overview
            </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">
              Home
              </Nav.Link>
            <Nav.Link href="/addCharacter">
              Add Character
              </Nav.Link>
          </Nav>
      </Navbar>
    </div>
  )
}
