# People

## __BaseEntity__
  - Id

## __Person__ extends __BaseEntity__
  - firstName
  - middleName
  - lastName
  - gender
  - dateRegistered
  - Address

## __Patient__ extends __Person__
  - Occupation
  - Medical History
    - Allergies(food, medication, environmental, products)
    - Illnesses
    - Injuries
    - Surgeries
    - Medications(Taken before)
    - Lifestyle
      - Alcoholism
      - Smoking
  - Emergency Contact
    - Relationship
    - Phone Number
  - Visitation
  - InsuranceInfo
    - provider name
    - expiration date
    - policy number
    - group number

## __Staff__ extends __Person__
  - Salary
  - Specialty

## Specialty
  - String

## __Nurse__ extends __Staff__

## __Doctor__ extends __Staff__