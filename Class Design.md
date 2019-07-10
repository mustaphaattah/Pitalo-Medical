### Classes

- BaseEntity
  - Id

* Person extends BaseEntity
  - firstName
  - lastName
  - Address

- Patient extends Person
  - Medical History
  - Appointments
  - Visits

* Staff extends Person

  - Salary
  - Specialty

* Specialty

  - String

* Nurse extends Staff

- Doctor extends Staff

* Visit

  - Status
  - Vitals
  - Staff

* Status
  - Name

- Appointment extends Status

  - DateTime
  - Staff to see - Doctor
  - Staff who made appointment - Nurse

- Walk-in extend Status

* Emergency extends Status
  - EmergencyCode
  - DateTime
  - Staff who raised emergency

- EmergencyCode
  - color
  - Message

* Vitals
  - bloodType - Enum
  - BloodPressure
  - Body Temperature
  - Pulse Rate
  - Weight
  - Height
  - Respiration rate
