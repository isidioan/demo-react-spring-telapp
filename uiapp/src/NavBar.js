import React, { Component } from 'react';
import './App.css';
import { Collapse, Nav, Navbar, NavbarToggler, NavItem, NavLink } from 'reactstrap';

class NavBar extends Component {

    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        //this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarToggler onClick={() => this.toggle()}/>
            <Collapse isOpen={this.state.isOpen} navbar>
                <Nav className="ml-auto" navbar>
                    <NavItem>
                        <NavLink
                            href="https://www.linkedin.com/in/isidorosioannou/">@isidioan</NavLink>
                    </NavItem>
                </Nav>
            </Collapse>
        </Navbar>
    }

}
export default NavBar;