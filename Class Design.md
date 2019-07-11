### Classes

- BaseEntity
  - Id

* Person extends BaseEntity
  - firstName
  - middleName
  - lastName
  - gender
  - dateRegistered
  - Address

- Patient extends Person
  - Medical History
  - Consultation

* Staff extends Person

  - Salary
  - Specialty

* Specialty

  - String

* Nurse extends Staff

- Doctor extends Staff

* Consultation

  - ConsultationType
  - Vitals
  - Staff - nurse
  - Staff - doctor
  - Diagnosis

* ConsultationType
  - Name

- Appointment extends ConsultationType

  - DateTime
  - Staff to see - Doctor
  - Staff who made appointment - Nurse

- Walk-in extend ConsultationType

* Emergency extends ConsultationType
  - Complaint
  - DateTime
  - Staff who recorded emergency
  - Doctor taking of it

- EmergencyCode
  - code
  - Info

* Vitals
  - bloodType - Enum
  - BloodPressure
  - Body Temperature
  - Pulse Rate
  - Weight
  - Height
  - Respiration rate
