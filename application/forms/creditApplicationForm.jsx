import React from 'react';
import PropTypes from 'prop-types'

class Form extends React.Component {

    constructor() {
        super();

        this.state = {
            CUSTOMER_ID: "",
            AMOUNT_IN_EURO: "",
            INTEREST_RATE: "",
            LOAN_PERIOD: ""
        };
    }

    render() {

        return (
            <form onSubmit={(e) => { e.preventDefault(); this.props.submit([
                { key: "CUSTOMER_ID", value: this.state.CUSTOMER_ID, valueType: "STRING" },
                { key: "AMOUNT_IN_EURO", value: this.state.AMOUNT_IN_EURO, valueType: "LONG" },
                { key: "INTEREST_RATE", value: this.state.INTEREST_RATE, valueType: "STRING" },
                { key: "LOAN_PERIOD", value: this.state.LOAN_PERIOD, valueType: "LONG" }
            ])}}>
                <h1>Customer applies for credit.</h1>
                <div className="form-group">
                    <label htmlFor="CUSTOMER_ID">Kunden-Nr.</label>
                    <input type="text" className="form-control" id="CUSTOMER_ID" value={this.state.CUSTOMER_ID} onChange={(e) => this.setState({ CUSTOMER_ID: e.target.value })} />
                </div>
                <div className="form-group">
                    <label htmlFor="AMOUNT_IN_EURO">Kreditsumme</label>
                    <input type="text" className="form-control" id="AMOUNT_IN_EURO" value={this.state.AMOUNT_IN_EURO} onChange={(e) => this.setState({ AMOUNT_IN_EURO: e.target.value })} />
                </div>
                <div className="form-group">
                    <label htmlFor="INTEREST_RATE">Zinssatz</label>
                    <input type="text" className="form-control" id="INTEREST_RATE" value={this.state.INTEREST_RATE} onChange={(e) => this.setState({ INTEREST_RATE: e.target.value })}/>
                </div>
                <div className="form-group">
                    <label htmlFor="LOAN_PERIOD">Laufzeit (Monate)</label>
                    <input type="text" className="form-control" id="LOAN_PERIOD" value={this.state.LOAN_PERIOD} onChange={(e) => this.setState({ LOAN_PERIOD: e.target.value })} />
                </div>
                <input className="btn btn-default float-right" type="submit" value="Start" />
            </form>
        )
    }
}


Form.propType = {
    submit: PropTypes.func.isRequired
};

module.exports = Form;

