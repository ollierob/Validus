import * as React from "react";
import * as ReactDOM from "react-dom";
import {LeftMenu, RightContent, TopMenu} from "./Layout";

class Main extends React.PureComponent {

    render() {
        return <div className="body">
            <TopMenu/>
            <LeftMenu/>
            <RightContent/>
        </div>
    }

}

ReactDOM.render(<Main/>, document.getElementById("main"));