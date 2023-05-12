import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";

class App extends Component {
  state = {
    logs: []
  };

  async componentDidMount() {
    const response = await fetch('/daily-log-service/practice-log/current-year/weeks/46?userId=samst');
    const body = await response.json();
    this.setState({logs: body});
 
  }

  render() {
    const {logs} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Weekly Logs</h2>
              {logs.dailyLogs.map(log =>
                  <div key={log.id}>
                    {log.weekId} 
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;
