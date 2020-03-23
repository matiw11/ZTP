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
                <button onClick={this.syncFile}>syncrhonizuj plik z bazą danych</button>
                <button onClick={this.syncDB}>syncrhonizuj baz danych z plikiem</button>
                <select onChange={e => this.setState({type: e.target.value})}>
                    <option value="DB" selected>baza danych</option>
                    <option value="FILE">plik</option>
                </select>
                <button onClick={this.readData}>wczytaj</button>
                <br/>
                {this.state.data && this.state.show &&
                <VirusPanel viruses={JSON.parse(JSON.stringify(this.state.data))} save={this.save}/>}

            </div>
        );
    }

    syncFile = () => {
        axios.get("http://localhost:8080/synchronizeFileWithDB/")
            .then(window.alert("zsynchronizowano"))
    }
    syncDB = () => {
        axios.get("http://localhost:8080/synchronizeDBWithFile/")
            .then(window.alert("zsynchronizowano"))
    }
    readData = () => {
        this.setState({show: null})
        axios.get("http://localhost:8080/getProblem/" + this.state.type)
            .then(response => this.setState({data: response.data, show: true}))
    }
    save = (data) => {
        this.setState({show: null})
        axios.post("http://localhost:8080/saveProblem/" + this.state.type, data)
            .then(response => this.setState({data: response.data, show: true}))
    }
}

export default Ztp;
