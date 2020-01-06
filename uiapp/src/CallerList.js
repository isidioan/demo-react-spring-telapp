import React, {Component} from 'react';
import './App.css';
import {
    ListGroup,
    ListGroupItem,
    Pagination,
    PaginationItem,
    PaginationLink,
    FormGroup, Input,
} from 'reactstrap';

class CallerList extends Component {

    state = {
        isLoading: true,
        callers: [],
        recordsPerPage: 15,
        currentPage: 1,
        search : ''
    };


    async componentDidMount() {
        const response = await fetch('/api/callers/all');
        const body = await response.json();
        this.setState({callers: body, isLoading: false});
    }

    handlePageChange(e, index) {

        e.preventDefault();

        this.setState({
            currentPage: index
        });

    }

    async handleSearchChange(e) {
        const search = e.target.value;
        this.setState({search : search});
        console.log('/api/caller/' + search);
        search ?
            await fetch('api/caller/' + search, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }).then(response => response.json())
                .then(result => this.setState({callers: result}))
                .catch(error => console.log('Error', error)) : this.componentDidMount()


    }

    render() {
        const {callers, isLoading, recordsPerPage, currentPage} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }
        const indexOfLast = recordsPerPage * currentPage;
        const indexOfFirst = indexOfLast - recordsPerPage;
        const currentCallers = callers.slice(indexOfFirst, indexOfLast);
        const pageCount = Math.ceil(callers.length / recordsPerPage);
        const pages = [];
        for (let i = 1; i <= pageCount; i++) {
            pages.push(i);
        }
        return (<div>
            <FormGroup>
                <Input type="text" name="search" id="search" value={this.state.search}
                       onChange={(e) => this.handleSearchChange(e)} placeholder="Search"/>
            </FormGroup>
            <ListGroup>
                {currentCallers.map(caller =>
                    <ListGroupItem tag="a" href="#" key={caller.id}>
                        <img
                            src={caller.image} alt="new"
                        />
                        {caller.first_name} {caller.last_name}
                    </ListGroupItem>
                )}
            </ListGroup>
            <br/>

            <Pagination size="sm" aria-label="Page navigation example">
                <PaginationItem disabled = {currentPage <= 1}>
                    <PaginationLink  onClick={(e) => this.handlePageChange(e, 1)} first href="!#"/>
                </PaginationItem>
                <PaginationItem disabled = {currentPage <= 1}>
                    <PaginationLink onClick={(e) => this.handlePageChange(e, currentPage - 1)} previous href="!#"/>
                </PaginationItem>

                {pages.map(num =>
                    <PaginationItem active = {num === currentPage} key={num}>
                        <PaginationLink  onClick={(e) => this.handlePageChange(e, num)} href="!#">{num}</PaginationLink>
                    </PaginationItem>
                )}
                <PaginationItem disabled = {currentPage >= pageCount}>
                    <PaginationLink onClick={() => this.setState({currentPage: currentPage + 1})}  next href="!#"/>
                </PaginationItem>
                <PaginationItem disabled = {currentPage >= pageCount}>
                    <PaginationLink onClick={() => this.setState({currentPage: pageCount})} last href="!#"/>
                </PaginationItem>
            </Pagination>
        </div>);
    }

}

export default CallerList;