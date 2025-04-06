import React from 'react';
import { Cell } from './game';


interface Props {
  cell: Cell
}

class BoardCell extends React.Component<Props> {
  render(): React.ReactNode {
    
    if(this.props.cell.text=='P')
    return (
      <img src={require(".//images//pirateShip.jpg")} alt="Nothing" className={`image `}></img>
    )
    else if(this.props.cell.text=='C')
      return (   
      <img src={require(".//images//ship.jpg")} alt="Nothing" className={`image `}></img>  
      )
      else
      return (
        <div className={`cell ` }>{this.props.cell.text}</div>
      )
  }
}

export default BoardCell;