import React from 'react';


export const historyList = (list) => {
  if (list.length <= 0) return '-';

  return list.map((item) => <span key={item}>{item}<br /></span>);
}