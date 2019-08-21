export const dateFormat = (date) => { 
  if (!date) return '';
  const newDate = new Date(date);
  const month = new Intl.DateTimeFormat('en-US', { month: 'long'}).format(newDate);
  const day = newDate.getDate();
  const year = newDate.getFullYear();
  return `${month} ${day}, ${year}`;
}

export const timeFormat = (date) => {
  if (!date) return '';
  const newDate = new Date(date);
  const hour = newDate.getHours() + 1;
  const minutes = newDate.getMinutes();

  return `${hour}:${minutes} ${hour > 11 ? 'PM' : 'AM'}`;
}





