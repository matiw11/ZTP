import React, {Component} from 'react';
import axios from 'axios'
import VirusPanel from "./VirusPanel";
class Ztp extends Component {
    state = {
        type: "DB"
    }
    render() {
        return (
            <div style={{padding: "25px"}}>
            <select onChange={e => this.setState({type: e.target.value})}>
                <option value="DB" selected >baza danych</option>
                <option value="FILE">plik</option>
            </select>
                <button onClick={this.readData}>wczytaj</button>
                <br/>
                {this.state.data &&<VirusPanel viruses={JSON.parse(JSON.stringify(this.state.data))} save={this.save}/>}

            </div>
        );
    }
    readData = () =>{
        axios.get("http://localhost:8080/getProblem/"+this.state.type)
            .then(response => this.setState({data: response.data}))
    }
    save = (data) =>{
        axios.post("http://localhost:8080/saveProblem/"+this.state.type, data)
            .then(response => this.setState({data: response.data}))
    }
}

export default Ztp;
