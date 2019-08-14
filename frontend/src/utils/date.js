export const dateFormat = (date) => { 
  if (!date) return '';
  const [year, month, day] = date;
  const newDate = new Date(year, month - 1, day);
  const monthString = newDate.toLocaleString('default', { month: 'long'});
  return `${monthString} ${day}, ${year}`;
}





