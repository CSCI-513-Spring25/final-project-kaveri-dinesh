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
    return (
      <div className={`cell ${playable} ${cellPlayed}` }>{this.props.cell.text}</div>
    )
  }
}

export default BoardCell;