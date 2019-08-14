const bloodTypes = {
  APOSITIVE: "A-positive",
  ANEGATIVE: "A-negative",
  BPOSITIVE: "B-positive",
  BNEGATIVE: "B-negative",
  ABPOSITIVE: "AB-positive",
  ABNEGATIVE: "AB-negative",
  OPOSITIVE: "O-positive",
  ONEGATIVE: "O-negative"
}

export const getBloodType = (type) => bloodTypes[type]
