import React, {Component} from 'react';

class VirusPanel extends Component {
    state ={
        selectedVirusName: null,
        selectedVirus: 0
    }
    render() {
        let viruses = JSON.parse(JSON.stringify(this.props.viruses));
        return (
            <div>
                <select onChange={this.selectVirus}>
                    <option disabled selected></option>
                    {viruses.map(virus => <option value={virus.name}>{virus.name}</option>)}


                </select>
                {this.state.selectedVirusName && (
                    <div>
                        nazwa: <input type={"text"} value={this.state.selectedVirus.name}
                                      onChange={e => this.setState({selectedVirus: {
                                          ...this.state.selectedVirus,
                                              name: e.target.value
                                          }})}/>
                        poziom groźności <input type={"number"}
                                                value={this.state.selectedVirus.dangerLevel}
                                                onChange={e => this.setState({selectedVirus: {
                                                        ...this.state.selectedVirus,
                                                        dangerLevel: e.target.value
                                                    }})}/>
                        <br/>
                        Zainfekowani:
                        {this.state.selectedVirus.people
                            .map(person => <div><input type={"text"} id={person.name} value={person.name}
                            onChange={e=>this.handlePersonChanged(e, person.name)}/>
                            wiek: <input type={"number"} value={person.age} onChange={(e) =>this.handlePersonChanged(e, person.name)}/>
                            <button onClick={() =>this.deletePerson(person.name)}>usun</button></div>)}
                        <br/>
                        <br/>
                        <input type={"text"} value={this.state.newPerson} onChange={e => this.setState({newPerson: e.target.value})}/>
                        <input type={"number"} value={this.state.newAge} onChange={e => this.setState({newAge: e.target.value})}/>
                        <button onClick={this.addPerson}>dodaj</button>
                        <br/>
                        <button onClick={this.save}>zapisz</button>
                        <button onClick={this.saveAsNew}>zapisz jako nowy</button>
                        <button onClick={this.delete}>usun</button>
                    </div>
                )}
            </div>
        );
    }

    save = () =>{
        let newViruses = []
        this.props.viruses.forEach(virus =>{
            if(virus.name !== this.state.selectedVirusName){
                newViruses.push(virus)
            }else{
                newViruses.push(this.state.selectedVirus)
            }
        })
        this.props.save(newViruses)
    }
    delete = () =>{
        let newViruses = []
        this.props.viruses.forEach(virus =>{
            if(virus.name !== this.state.selectedVirusName){
                newViruses.push(virus)
            }
        })
        this.props.save(newViruses)
    }
    saveAsNew = () =>{
        let newViruses = []
        this.props.viruses.forEach(virus =>{
                newViruses.push(virus)
        })
        newViruses.push(this.state.selectedVirus)
        this.props.save(newViruses)
    }

    addPerson = () =>{
        if(this.state.newPerson){
            this.setState({
                selectedVirus:{
                    ...this.state.selectedVirus,
                    people:[
                        ...this.state.selectedVirus.people,
                        {name: this.state.newPerson, virus: null, age: this.state.newAge}
                    ]
                },
                newPerson: "",
                newAge: 0
            })
        }
    }
    deletePerson = (name)=>{
        let newPeople = this.state.selectedVirus.people.filter(person => person.name !== name)
        this.setState({
            selectedVirus:{
                ...this.state.selectedVirus,
                people: newPeople
            }
        })
    }
    handlePersonChanged = (e, name) =>{
        const {selectedVirus} = this.state;
        const people = selectedVirus.people;
        let newPeople = []
        people.forEach(person => {if(person.name === name){
            if(isNaN(e.target.value))
                newPeople.push({name: e.target.value, viruses: null, age: person.age})
            else
                newPeople.push({name: person.name, viruses: null, age: e.target.value})
        }else{
            newPeople.push(person)
        }
        });

        this.setState({
            selectedVirus:{
                ...selectedVirus,
                people: newPeople

            }
        })
    }
    selectVirus = e =>{
        const viruses = this.props.viruses
        let virus = viruses.filter(vir => vir.name === e.target.value )[0]
        this.setState({selectedVirusName: e.target.value, selectedVirus : virus})
    }
}

export default VirusPanel;
