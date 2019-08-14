import React from 'react';

export const formatAddress = (address) => {
  if (!address) return '';
  return [
    <span key={1}>{address.addressLine1} {}<br /></span>,
    <span key={2}>{address.city}, {address.province} <br /></span>,
    <span key={3}>{address.postalCode}</span>
  ];
}