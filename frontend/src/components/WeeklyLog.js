import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ClientList extends Component {

    constructor(props) {
        super(props);const 
        
    }

    componentDidMount() {
        response = await fetch('/practice-log/current-year/weeks/46?userId=samst');
        const body = await response.json();
        this.setState({logs: body});
        fetch('/clients')
            .then(response => response.json())
            .then(data => this.setState({clients: data}));
    }
}
export default WeeklyLog;