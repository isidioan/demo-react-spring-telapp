import React, {Component} from 'react';
import './App.css';
import {
    ListGroup,
    ListGroupItem,
    ListGroupItemHeading,
    ListGroupItemText,
    Pagination,
    PaginationItem,
    PaginationLink
} from 'reactstrap';

class CallerList extends Component {

    state = {
        isLoading: true,
        callers: [],
        recordsPerPage: 15,
        currentPage: 1
    };

    async componentDidMount() {
        const response = await fetch('/api/callers/all');
        const body = await response.json();
        this.setState({callers: body, isLoading: false});
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
                    <PaginationLink  onClick={() => this.setState({currentPage: 1})} first href="!#"/>
                </PaginationItem>
                <PaginationItem disabled = {currentPage <= 1}>
                    <PaginationLink onClick={() => this.setState({currentPage: currentPage - 1})} previous href="!#"/>
                </PaginationItem>

                {pages.map(num =>
                    <PaginationItem active = {num === currentPage} key={num}>
                        <PaginationLink  onClick={() => this.setState({currentPage: num})} href="!#">{num}</PaginationLink>
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