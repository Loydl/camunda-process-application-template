import React from 'react';
import PropTypes from 'prop-types'

const getVariable = (name, variables) => {
    if (variables.length !== 0 && variables) {
        for (let i=0; i < variables.length; i++) {
            if (variables[i].key === name) {
                return variables[i].value;
            }
        }
    } else {
        return 'no variables';
    }
};

class Form extends React.Component {

    constructor() {
        super();

        this.state = {
            MANUAL_DECISION: "ACCEPT",
            variables: [
                "CREDIT_APPLICATION",
                "CUSTOMER_DATA"
            ]
        };
    }

    componentDidMount() {
        this.props.fetchVariables(this.state.variables);
    }

    componentDidUpdate() {
        this.props.fetchVariables(this.state.variables);
    }

    render() {

        const CUSTOMER_DATA = getVariable("CUSTOMER_DATA", this.props.variables);
        const CREDIT_APPLICATION = getVariable("CREDIT_APPLICATION", this.props.variables);


        return (
            <form onSubmit={(e) => { e.preventDefault(); this.props.complete([{ key: "MANUAL_DECISION", value: this.state.MANUAL_DECISION, valueType: "String" }])}}>
                <p><b>Kunden-Nr.</b>: {CUSTOMER_DATA.customerId}</p>
                <p><b>Name</b>: {CUSTOMER_DATA.fullName}</p>
                <p><b>Kreditsumme</b>: {CREDIT_APPLICATION.amountInEuro} </p>
                <p><b>Person</b>: {CUSTOMER_DATA.personality}</p>
                <p><b>Rating</b>: {CUSTOMER_DATA.rating}</p>
                <label>
                    Entscheidung
                    <select value={this.state.MANUAL_DECISION} onChange={(e) => this.setState({ MANUAL_DECISION: e.target.value})}>
                        <option value="ACCEPT">Annehmen</option>
                        <option value="REJECT">Ablehnen</option>
                    </select>
                </label>
                <p className="float-right"><input className="btn btn-default" type="submit" value="Complete" /></p>
            </form>
        )
    }
}

Form.propType = {
    variables: PropTypes.array.isRequired,
    complete: PropTypes.func.isRequired,
    fetchVariables: PropTypes.func.isRequired
};

export default Form;