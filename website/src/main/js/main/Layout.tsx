import * as React from "react";

export class TopMenu extends React.PureComponent {

    render() {
        return <div className="topMenu">

        </div>
    }

}

export class LeftMenu extends React.PureComponent {

    render() {
        return <div className="leftMenu">

        </div>
    }

}

export class RightContent extends React.PureComponent {

    render() {
        return <div className="content">
            {this.props.children}
        </div>
    }

}