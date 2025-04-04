import React from 'react';
import { Cell } from './game';


interface Props {
  cell: Cell
}

class BoardCell extends React.Component<Props> {
  render(): React.ReactNode {
    const playable = this.props.cell.playable ? 'playable' : '';
    var cellPlayed = '';
    if(this.props.cell.text=='X'){
      cellPlayed='PLAYER0'
    }
    else if(this.props.cell.text=='O')cellPlayed='PLAYER1'
    if(this.props.cell.text!='P')
    return (
      <div className={`cell ${playable} ${cellPlayed}` }>{this.props.cell.text}</div>
    )
    else 
      return (   
      <img src={require(".//images//ship.jpg")} alt="Nothing" className={`image `}></img>  
      )
  }
}

export default BoardCell;