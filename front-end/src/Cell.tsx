import React from 'react';
import { Cell } from './game';


interface Props {
  cell: Cell
}

class BoardCell extends React.Component<Props> {
  render(): React.ReactNode {
    
    if(this.props.cell.text!='C')
    return (
      <div className={`cell ` }>{this.props.cell.text}</div>
    )
    else 
      return (   
      <img src={require(".//images//ship.jpg")} alt="Nothing" className={`image `}></img>  
      )
  }
}

export default BoardCell;